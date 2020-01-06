package com.beniregev.demos_and_tutorials.examples.mapdb;

import org.mapdb.*;
import org.mapdb.volume.MappedFileVol;
import org.mapdb.volume.Volume;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentMap;

public class MapDBExample {

    /**
     * <p>
     *    <div>
     *        Once our {@link DB} object {@code dbMemoryDB} is up and
     *        running, we can use it to build an HTreeMap to work with
     *        our database records.
     *    </div>
     *    <div>
     *         When we're finished with the database, we should close
     *         it to avoid further mutation.
     *    </div>
     * </p>
     *
     */
    public void simpleHashMapMemoryDBExample() {
        System.out.println("simpleHashMapMemoryDBExample()");
        DB dbMemoryDB = DBMaker.memoryDB().make();
        this.simpleHashMapUsageExample(dbMemoryDB);
        dbMemoryDB.close();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * <p>
     *     <div>
     *         To store our data in a file, rather than in memory, all we
     *         need to do is change the way that our DB  object is instantiated.
     *     </div>
     *     <div>
     *         When we're finished with the database, we should close it to
     *         avoid further mutation.
     *     </div>
     * </p>
     */
    public void simpleHashMapFileDBExample() {
        System.out.println("simpleHashMapFileDBExample()");
        DB dbFileDB = DBMaker.fileDB("file.db").make();
        this.simpleHashMapUsageExample(dbFileDB);
        dbFileDB.close();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * <p>
     *     {@link HTreeMap} is {@code MapDB}'s {@link java.util.HashMap}
     *     implementation. So, now that we have data in our database, we
     *     can retrieve it using the {@code get} method.
     * </p>
     * @param database the {@link DB} to use
     */
    private void simpleHashMapUsageExample(DB database) {
        String welcomeMessageKey = "Welcome Message For FileDB";
        String welcomeMessageString = "Welcome Message For FileDB";

        HTreeMap myFileMap = database.hashMap("myFileMap").createOrOpen();
        myFileMap.put(welcomeMessageKey, welcomeMessageString);

        //  HTreeMap is MapDB's HashMap implementation. So, now that we have
        //  data in our database, we can retrieve it using the {@code get} method:
        String welcomeMessageFromDB = (String) myFileMap.get(welcomeMessageKey);
        System.out.println("\tis welcomeMessageString equals welcomeMessageFromDB? " + welcomeMessageString.equals(welcomeMessageFromDB));
    }

    /**
     * MapDB includes different collection types. To demonstrate, let's add and retrieve some data from our database using a NavigableSet, which works as you might expect of a Java Set:
     *
     *
     */
    public void simpleNavigableSetExample() {
        System.out.println("simpleNavigableSetExample()");
        //  Let's start with a simple instantiation of our DB object:
        DB db = DBMaker.memoryDB().make();

        //  Next, let's create our NavigableSet:
        NavigableSet<String> set = db
                .treeSet("mySet")
                .serializer(Serializer.STRING)
                .createOrOpen();

        //  Next, let's add some data:
        set.add("beni regev");
        set.add("captain cook");

        //  Now, let's check that our two distinct values
        //  have been added to the database correctly:
        System.out.println("\tExpecting 2 elements and got " + set.size() + " elements");

        //  Finally, since this is a set, let's add a duplicate string and verify that our database still contains only two values:
        set.add("beni regev");
        System.out.println("\tExpecting 2 elements and got " + set.size() + " elements");
        db.close();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /**
     *  <p>
     *      Much like traditional databases, the DB class
     *      provides methods to commit and rollback the
     *      data we add to our database.
     *  </p>
     *
     */
    public void transactionCommitAndRollbackExample() {
        System.out.println("transactionCommitAndRollbackExample()");
        //  To enable this functionality, we need to initialize
        //  our DB with the transactionEnable method:
        DB db = DBMaker.memoryDB().transactionEnable().make();

        //  Next, let's create a simple set, add some data, and
        //  commit it to the database:
        NavigableSet<String> set = db
                .treeSet("mySet")
                .serializer(Serializer.STRING)
                .createOrOpen();

        set.add("One");
        set.add("Two");
        db.commit();
        System.out.println("\tExpecting 2 elements and got " + set.size() + " elements");

        //  Now, let's add a third, uncommitted string to our database:
        set.add("Three");
        System.out.println("\tExpecting 3 elements and got " + set.size() + " elements");

        //  If we're not happy with our data, we can rollback the data
        //  using DB's rollback method:
        db.rollback();
        System.out.println("\tExpecting 2 elements and got " + set.size() + " elements");

        db.close();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * <p>
     *     <div>
     *         Much like traditional databases, the DB class MapDB
     *         offers a large variety of serializers, which handle
     *         the data within the collection. The most important
     *         construction parameter is the name, which identifies
     *         the individual collection within the DB object.
     *     </div>
     *     <div>
     *         While serialization is recommended, it is optional
     *         and can be skipped. However, it's worth noting that
     *         this will lead to a slower generic serialization
     *         process.
     *     </div>
     * </p>
     */
        public void serializersExample() {
        System.out.println("serializersExample()");
        DB db = DBMaker.memoryDB().transactionEnable().make();
        HTreeMap<String, Long> map = db.hashMap("indentification_name")
                .keySerializer(Serializer.STRING)
                .valueSerializer(Serializer.LONG)
                .create();

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * <p>
     *     MapDB's HTreeMap provides HashMap and HashSet collections
     *     for working with our database. HTreeMap is a segmented hash
     *     tree and does not use a fixed-size hash table. Instead, it
     *     uses an auto-expanding index tree and does not rehash all
     *     of its data as the table grows. To top it off, HTreeMap is
     *     thread-safe and supports parallel writes using multiple
     *     segments.
     * </p>
     */
    public void exampleHTreeMap() {
        System.out.println("exampleHTreeMap()");
        //  To begin, let's instantiate a simple HashMap that uses
        //  String for both keys and values:
        DB db = DBMaker.memoryDB().make();

        HTreeMap<String, String> hTreeMap = db
                .hashMap("myTreeMap")
                .keySerializer(Serializer.STRING)
                .valueSerializer(Serializer.STRING)
                .create();

        //  Above, we've defined separate serializers for the key
        //  and the value. Now that our HashMap is created, let's
        //  add data using the put method:
        hTreeMap.put("key1", "value1");
        hTreeMap.put("key2", "value2");
        System.out.println("\tExpecting 2 elements and got " + hTreeMap.size() + " elements");

        //  As HashMap works on an Object's hashCode method,
        //  adding data using the same key causes the value
        //  to be overwritten:
        hTreeMap.put("key1", "value3");
        System.out.println("\t(Expecting=2) == (actual=\" + hTreeMap.size() + \") ==> " + (hTreeMap.size() == 2));

        db.close();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * <p>
     *     <div>
     *         MapDB's SortedTableMap stores keys in a fixed-size table
     *         and uses binary search for retrieval. It's worth noting
     *         that once prepared, the map is read-only.
     *     </div>
     *     <div>
     *         Let's walk through the process of creating and querying
     *         a SortedTableMap. We'll start by creating a memory-mapped
     *         volume to hold the data, as well as a sink to add data. On
     *         the first invocation of our volume, we'll set the read-only
     *         flag to false, ensuring we can write to the volume.
     *     </div>
     * </p>
     */
    public void exampleSortedTableMap() {
        String VOLUME_LOCATION = "sortedTableMapVol.db";

        //  On the first invocation of our volume, we'll set the read-only
        //  flag to false, ensuring we can write to the volume:
        Volume vol = MappedFileVol.FACTORY.makeVolume(VOLUME_LOCATION, false);

        SortedTableMap.Sink<Integer, String> sink =
                SortedTableMap.create(
                        vol,
                        Serializer.INTEGER,
                        Serializer.STRING)
                        .createFromSink();

        //  Next, we'll add our data and call the create method on the sink
        //  to create our map:
        for(int i = 0; i < 100; i++){
            sink.put(i, "Value " + Integer.toString(i));
        }
        sink.create();

        //  Now that our map exists, we can define a read-only volume and
        //  open our map using SortedTableMap's open method:
        Volume openVol = MappedFileVol.FACTORY.makeVolume(VOLUME_LOCATION, true);

        SortedTableMap<Integer, String> sortedTableMap = SortedTableMap
                .open(  openVol,
                        Serializer.INTEGER,
                        Serializer.STRING);

        System.out.println("\tExpecting 100 elements and got " + sortedTableMap.size() + " elements");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * <p>
     *     <h3>4.1. Binary Search</h3>
     *     <div>
     *         Before we move on, let's understand how the SortedTableMap utilizes binary search in more detail.
     *     </div>
     *     <div>
     *         SortedTableMap splits the storage into pages, with each page containing several nodes comprised of keys and values. Within these nodes are the key-value pairs that we define in our Java code.
     *     </div>
     *     <div>
     *         SortedTableMap performs three binary searches to retrieve the correct value:
     *     </div>
     *     <ol>
     *         <li>Keys for each page are stored on-heap in an array. The SortedTableMap performs a binary search to find the correct page.</li>
     *         <li>Next, decompression occurs for each key in the node. A binary search establishes the correct node, according to the keys.</li>
     *         <li>Finally, the SortedTableMap searches over the keys within the node to find the correct value.</li>
     *     </ol>
     * </p>
     * <div>
     *     Before we move on, let's understand how the SortedTableMap utilizes binary search in more detail.
     * </div>
     * <div>
     *      SortedTableMap splits the storage into pages, with each page containing several nodes comprised of keys and values. Within these nodes are the key-value pairs that we define in our Java code.
     *  </div>
     *  <div>
     *      SortedTableMap performs three binary searches to retrieve the correct value:
     *  </div>
     * <ol>
     *     <li>
     *         Keys for each page are stored on-heap in an array. The SortedTableMap performs a binary search to find the correct page.
     *     </li>
     *     <li>
     *         Next, decompression occurs for each key in the node. A binary search establishes the correct node, according to the keys.
     *     </li>
     *     <li>
     *         Finally, the SortedTableMap searches over the keys within the node to find the correct value.
     *     </li>
     * </ol>
     *
     */

    /**
     *
     */
    public void hashMapMemoryDbExample() {
        System.out.println("hashMapMemoryDbExample()");
        DB db = DBMaker.memoryDB().make();
        ConcurrentMap map = db.hashMap("map").createOrOpen();
        map.put("something", "here");
    }

    public void hashMapFileDbExample() {
        System.out.println("hashMapFileDbExample()");
        DB db = DBMaker.fileDB("file.db").make();
        ConcurrentMap map = db.hashMap("map").createOrOpen();
        map.put("something", "here");
        db.close();
    }

    public void hashMapFileDbSpecializedSerializersExample() {
        System.out.println("hashMapFileDbSpecializedSerializersExample()");
        DB db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .make();
        ConcurrentMap<String, String> mapUsers = db
                .hashMap("map", Serializer.STRING, Serializer.STRING)
                .createOrOpen();

        mapUsers.put("King David", "David Ben Yishai, father of Solomon, married Bat-Sheba, killed Goliath");
        mapUsers.put("King Solomon", "Solomon Ben David, they say he had 1000 wifes, build the first Temple in Jerusalem");

        db.close();
    }

    public static void main(String[] args) {
        MapDBExample example = new MapDBExample();
        example.simpleHashMapMemoryDBExample();
        example.simpleHashMapMemoryDBExample();
        example.transactionCommitAndRollbackExample();
        example.exampleHTreeMap();
        example.exampleSortedTableMap();

        example.hashMapMemoryDbExample();
        example.hashMapFileDbExample();
        example.hashMapFileDbSpecializedSerializersExample();
    }
}
