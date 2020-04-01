# Mixja

![GitHub](https://img.shields.io/github/license/NguyenAndrew/Mixja)
[![Maven metadata URL](TODO)
[![javadoc](TODO)](TODO)

Java library implementing Mixtures - Setup objects without needing private methods or using [double brace initialization anti-pattern](https://www.baeldung.com/java-double-brace-initialization#disadvantages-of-using-double-braces). Readable, efficient and safe way to construct ArrayLists, HashMaps, your own Objects, and more!

## How to Install

Maven Central Dependency Coming Soon!

## Example Usages

### mix - Creates an object that may require additional put/add/set/etc. Java Lambda used to setup and return this object.

```
import static com.andyln.Mixja.mix;
...
private Map<String, String> map = mix(() -> {
    Map<String, String> map = new HashMap<>();
    map.put("Grace", "Hopper");
    map.put("Ada", "Lovelace");
    map.put("Alan", "Turing");
    return map;
});
```

### eix - checked (e)xception may be thrown (m)ix. The performance of try-catch is why this method is standalone.
```
import static com.andyln.Mixja.eix;
...
private static final Set<String> broken_set = eix(() -> {
    Set<String> set = mock(Set.class);
    when(set.add(anyString())).thenThrow(new UnsupportedOperationException());
    return set;
});
```