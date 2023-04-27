package com.only4play.common.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamUtils {

    private StreamUtils() {

    }

    /**
     * Collection转换List
     */
    public static <T, R> List<R> toList(Collection<T> collection, Function<T, R> mapper) {
        return isEmpty(collection) ? Collections.emptyList() : collection.stream()
                .filter(Objects::nonNull)
                .map(mapper)
                .collect(Collectors.toList());
    }

    /**
     * Collection过滤
     */
    public static <T> List<T> listFilter(Collection<T> collection, Predicate<T> predicates) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().filter(Objects::nonNull).filter(predicates).collect(Collectors.toList());
    }

    /**
     * Collection转Map(聚合)
     */
    public static <T, R> Map<R, List<T>> toGroupMap(Collection<T> collection, Function<T, R> classifier) {
        return isEmpty(collection) ? Collections.emptyMap() : collection.stream().filter(Objects::nonNull).collect(
                Collectors.groupingBy(classifier));
    }

    /**
     * Collection转Map(覆盖，key能冲突)
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<T, K> key, Function<T, V> value) {
        return isEmpty(collection) ? Collections.emptyMap() : collection.stream().filter(Objects::nonNull).collect(
                Collectors.toMap(key, value, (key1, key2) -> key2));
    }

    /**
     * Collection转聚合map，value也是一个list
     */
    public static <T, R1, R2> Map<R1, List<R2>> totoGroupListMap(Collection<T> collection, Function<T, R1> classifier,
                                                                 Function<T, R2> classifier2) {
        if (isEmpty(collection)) {
            return Collections.emptyMap();
        }
        Map<R1, List<T>> map = collection.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(classifier));
        Map<R1, List<R2>> result = new HashMap<>(Collections.emptyMap());
        map.forEach((key, value) -> {
            result.put(key, toList(value, classifier2));
        });
        return result;
    }

    /**
     * collection转聚合map，value也是一个map
     */
    public static <T, R1, R2> Map<R1, Map<R2, T>> toGroupMap(Collection<T> collection, Function<T, R1> classifier,
                                                             Function<T, R2> classifier2) {
        if (isEmpty(collection)) {
            return Collections.emptyMap();
        }
        Map<R1, List<T>> map = collection.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(classifier));
        Map<R1, Map<R2, T>> result = new HashMap<>(Collections.emptyMap());
        // value的list对象转map
        map.forEach((key, value) -> {
            result.put(key, toMap(value, classifier2, v -> v));
        });
        return result;
    }

    /**
     * 连续2次分组
     */
    public static <T, R, R2> Map<R, Map<R2, List<T>>> toGroupMapTwice(List<T> list, Function<T, R> classifier,
                                                                      Function<T, R2> classifier2) {
        if (isEmpty(list)) {
            return Collections.emptyMap();
        }
        Map<R, List<T>> map = list.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(classifier));
        Map<R, Map<R2, List<T>>> result = new HashMap<>(Collections.emptyMap());
        map.forEach((key, value) -> {
            // value的list对象转map
            result.put(key, toGroupMap(value, classifier2));
        });
        return result;
    }

    /**
     * Collection转换Set
     */
    public static <T, R> Set<R> toSet(Collection<T> collection, Function<T, R> mapper) {
        return isEmpty(collection) ? Collections.emptySet() : collection.stream()
                .filter(Objects::nonNull)
                .map(mapper)
                .collect(Collectors.toSet());
    }

    private static <T> boolean isEmpty(Collection<T> collection) {
        return null == collection || collection.isEmpty();
    }
}