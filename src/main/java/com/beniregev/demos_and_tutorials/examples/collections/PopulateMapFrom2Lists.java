package com.beniregev.demos_and_tutorials.examples.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PopulateMapFrom2Lists {
    /**
     * <div>
     *     Receiving 2 {@link List}s that will be used to populate
     *     a {@link Map}&gt;{@link Double}, {@link String}&lt;.
     * </div>
     * @param list1 {@link List} of {@link Double}s to use as the keys of the {@link Map}.
     * @param list2 {@link List} of {@link String}s to use as the keys of the {@link Map}.
     * @return
     */
    public Map populateMapDoubleStringFrom2Lists(List<Double> list1, List<String> list2) {;
        Map<Double, String> map = IntStream.range(0, list1.size())
                .boxed()
                .collect(Collectors.toMap(i -> list1.get(i), i -> list2.get(i)));
        return map;
    }


    /**
     * <div>
     *     Receiving 2 {@link List}s that will be used to populate
     *     a {@link Map}&gt;{@link String}, {@link String}&lt;.
     * </div>
     * @param listKeys {@link List} of {@link String}s to use as the keys of the {@link Map}.
     * @param listValues {@link List} of {@link String}s to use as the values of the {@link Map}.
     * @return {@link Map}&gt;{@link String}, {@link String}&lt;
     */
    public Map populateMapFrom2Lists(final List listKeys, final List listValues) {
        Map<String, String> map = new HashMap<>();
        listKeys.stream()
                .distinct()
                .forEach(k -> {
                    String value = listValues.stream()
                            .filter(
                                    v -> v.toString().contains(k.toString())
                            )
                            .findFirst()
                            .orElse("None found")
                            .toString();
                    map.put(k.toString(), value);
                });

        //Map<String, String> mapCodes = listKeys.stream()
        //        .distinct()
        //        .collect(
        //                HashMap::new,
        //                (m, k) -> m.put(k.toString(), listValues.stream()
        //                        .filter(val -> val.contains(k.toString()))
        //                        .findFirst()
        //                        .orElse(null)
        //                ),
        //                HashMap::putAll
        //        );
        //System.out.println(mapCodes);

        return map;
    }

    public static void main(String[] args) {
        PopulateMapFrom2Lists examples = new PopulateMapFrom2Lists();
        Map<Double, String> mapDoubleString = examples.populateMapDoubleStringFrom2Lists(
                Arrays.asList(1.0, 2.0, 3.0),
                Arrays.asList("one_point_zero", "two_point_zero", "three_point_zero"));
        Map<String, String> mapStringString = examples.populateMapFrom2Lists(
                Arrays.asList("AA", "BB", "CC", "ZZ"),
                Arrays.asList("X_14_AA_85", "X_14_BB_85", "X_14_ZZ_85"));
        System.out.println("-------------------------------------------------");
        System.out.println("Map<Double, String> data values:");
        mapDoubleString.entrySet().stream().forEach(e-> System.out.println(e));
        System.out.println("-------------------------------------------------");
        System.out.println("Map<String, String> data values:");
        mapStringString.entrySet().stream().forEach(e-> System.out.println(e));
    }
}
