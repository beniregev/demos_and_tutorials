package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick.basic_implementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] dictionary = new String[]{"a", "ab", "bab", "bc", "bca", "c", "caa"};
        Node trie = constructTrie(dictionary);

        String input = "abccab";
        Match[] matches = findMatches(input, trie);

        System.out.println("trie = ");
        System.out.println(trie);

        System.out.println("matches = ");
        System.out.println(Arrays.toString(matches));
    }

    private static class Match {
        final String str;
        final int index;

        private Match(String str, int index) {
            this.str = str;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Match{" +
                    "str='" + str + '\'' +
                    ", index=" + index +
                    '}';
        }
    }

    private static class Node {
        final Character c;
        final String name;
        boolean inDictionary;
        Node suffix;
        Node dictSuffix;
        final Set<Node> children;

        Node(Character c, String name, boolean inDictionary) {
            this.c = c;
            this.name = name;
            this.inDictionary = inDictionary;
            this.suffix = null;
            this.dictSuffix = null;
            this.children = new HashSet<>();
        }

        @Override
        public String toString() {
            String padding = repeatCharLen(name.length(), ' ');
            return "\n" + padding + "Node{" +
                    "c=" + c +
                    ",name='(" + name + ")'" +
                    ",inDictionary=" + inDictionary +
                    ",suffix=(" + (suffix == null ? null : suffix.name) + ")" +
                    ",dictSuffix=(" + (dictSuffix == null ? null : dictSuffix.name) + ")" +
                    ",children=" + children + '}';
        }
    }

    private static String repeatCharLen(int len, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static void findSuffixDFS(Node parent, Node targetNode) {
        Node traversingNode = parent;
        boolean foundSuffix = false;

        // traverse suffix nodes
        while (traversingNode.suffix != null && !foundSuffix) {
            traversingNode = traversingNode.suffix;

            // check the traversing node's children; if child's character matches the target node's character => found
            for (Node child : traversingNode.children) {
                if (Objects.equals(targetNode.c, child.c)) {
                    targetNode.suffix = child;
                    foundSuffix = true;
                    break;
                }
            }
        }

        // DFS
        for (Node child : targetNode.children) {
            findSuffixDFS(targetNode, child);
        }
    }

    private static void findDictSuffixDFS(Node targetNode) {
        // reference to the node we're checking
        Node traversingNode = targetNode.suffix;

        // traverse suffix nodes until we find one that's in the dictionary
        while (traversingNode != null) {
            if (traversingNode.inDictionary) {
                targetNode.dictSuffix = traversingNode;
                break;
            } else if (traversingNode.dictSuffix != null) {
                targetNode.dictSuffix = traversingNode.dictSuffix;
                break;
            } else {
                traversingNode = traversingNode.suffix;
            }
        }

        // DFS
        for (Node child : targetNode.children) {
            findDictSuffixDFS(child);
        }
    }

    private static Node constructTrie(String[] dictionary) {
        // the root of the trie data structure
        Node root = new Node(null, "", false);

        // add each dictionary entry to the trie
        for (String dictEntry : dictionary) {
            // reference to the parent node for each prefix
            Node parentNode = root;

            // store these in array once
            char[] dictEntryChars = dictEntry.toCharArray();

            // for each prefix (i.e. for each character in the string) check the node exists and is configured
            for (int i = 0; i < dictEntryChars.length; i++) {
                Character c = dictEntryChars[i];
                Node child = null;

                // if prefix already exists in the trie then we'll find a child here
                for (Node childNode : parentNode.children) {
                    if (Objects.equals(c, childNode.c)) {
                        child = childNode;
                        break;
                    }
                }

                // child not found, so we need to create a new Node
                if (child == null) {
                    child = new Node(c, parentNode.name + c, false);
                    parentNode.children.add(child);
                }

                // if this node could correspond to a prefix in the dictionary, mark it true
                // never overwrite if it's already true
                if (!child.inDictionary) {
                    child.inDictionary = i == dictEntryChars.length - 1;
                }

                // update reference so we process the next prefix
                parentNode = child;
            }
        }

        // find blue arcs
        for (Node child : root.children) {
            child.suffix = root;
        }
        for (Node child : root.children) {
            findSuffixDFS(root, child);
        }

        // find green arcs
        findDictSuffixDFS(root);

        // done
        return root;
    }

    private static Match[] findMatches(String input, Node trie) {
        // store matches
        List<Match> matches = new ArrayList<>();

        // store input char into array
        char[] inputCharArr = input.toCharArray();

        // reference to node for traversing
        Node targetNode = trie;

        // make steps in the graph, from the target node, for each character in the input
        for (int i = 0; i < inputCharArr.length; i++) {
            char c = inputCharArr[i];
            boolean extended = false;

            // search children, then suffix's children, then suffix's suffix's children, etc
            while (!extended && targetNode != null) {
                for (Node child : targetNode.children) {
                    if (Objects.equals(c, child.c)) {
                        targetNode = child;
                        if (targetNode.inDictionary) {
                            matches.add(new Match("(" + targetNode.name + ")", i + 1));
                        }
                        if (targetNode.dictSuffix != null) {
                            matches.add(new Match("(" + targetNode.dictSuffix.name + ")", i + 1));
                        }
                        extended = true;
                    }
                }

                if (!extended) {
                    targetNode = targetNode.suffix;
                }
            }
        }

        // done
        return matches.toArray(new Match[0]);
    }
}
