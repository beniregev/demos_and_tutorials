package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.java8_aho_corasick_implementation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    /**
     *
     * @param path nom du fichier
     * @param encoding encodage du fichier
     * @return le texte dont le path est "path" sous forme d'une String
     * @throws IOException
     */
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
