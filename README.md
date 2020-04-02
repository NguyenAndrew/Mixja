# Mixja

![GitHub](https://img.shields.io/github/license/NguyenAndrew/Mixja)  
![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fandyln%2Fmixja%2Fmaven-metadata.xml)  
[![javadoc](https://javadoc.io/badge2/com.andyln/mixja/javadoc.svg)](https://javadoc.io/doc/com.andyln/mixja)

Java library implementing Mixtures - Setup objects without needing private methods or using [double brace initialization anti-pattern](https://www.baeldung.com/java-double-brace-initialization#disadvantages-of-using-double-braces). Readable, efficient and safe way to construct ArrayLists, HashMaps, your own Objects, and more!

## How to Install

Add the following line to your pom.xml

```
<dependency>
  <groupId>com.andyln</groupId>
  <artifactId>mixja</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Examples

### mix - Creates an object that may require additional put/add/setters/etc. Java Lambda used to setup and return this object.

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
private Set<String> brokenSet = eix(() -> {
    Set<String> set = mock(Set.class);
    when(set.add(anyString())).thenThrow(new UnsupportedOperationException());
    return set;
});
```

## FAQ

Q: Why use this library instead of just using `Map.of(...)`?

A: You should use `Of(...)` when possible! This library helps solves several problems not covered by that syntax.

1. Can setup objects that are not part of Collections. Usable with your own classes or classes from your dependencies.
```
CustomObject customObject = mix(() -> {
    CustomObject customObject = new CustomObject();
    customObject.setName("Awesome");
    customObject.setFeature(new Feature());
    customObject.setDate("March 31, 2020");
    return customObject;
});
```
2. `Of(...)` syntax is only available on Java 9+. Can use this library on Java 8.
3. Setup either your own objects or objects provided by dependencies without needing to maintain Builder classes or annotation code.
