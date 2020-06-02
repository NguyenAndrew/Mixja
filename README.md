# Mixja

![GitHub](https://img.shields.io/github/license/NguyenAndrew/Mixja)  
![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fandyln%2Fmixja%2Fmaven-metadata.xml)  
[![javadoc](https://javadoc.io/badge2/com.andyln/mixja/javadoc.svg)](https://javadoc.io/doc/com.andyln/mixja)

Java library implementing Mixtures (also known as IIFE or Immediately-Invoked Function Expressions) - Setup objects without needing private methods or using [double brace initialization anti-pattern](https://www.baeldung.com/java-double-brace-initialization#disadvantages-of-using-double-braces). Readable, efficient and safe way to construct ArrayLists, HashMaps, your own Objects, and more!

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

## FAQ - Readings

Q: When should I use a Mixture or Immediately-Invoked Function Expression (IIFE)?

A: Avoids needing to create named functions. Cleaner code by encapsulating variables. IIFE are

* Anonymous - You don't have to make a name for your function.
* Brief - Code is easy to read due to its "one-time-use" nature.
* Inline - Code is viewed exactly where it is used. No need to jump around code base to see functionalty.

Q: Are there any more resources where I can learn about IIFE?

A: Here are some of my recommended reading links (Note: These reading links are JavaScript specific, Java examples are in FAQ - Usages below):

* https://developer.mozilla.org/en-US/docs/Glossary/IIFE
* https://www.youtube.com/watch?v=3cbiZV4H22c (Video)
* http://adripofjavascript.com/blog/drips/an-introduction-to-iffes-immediately-invoked-function-expressions.html

## FAQ - Usages

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

Q: Can't I just use a [Builder](https://www.baeldung.com/java-builder-pattern-freebuilder)?

A: This library can deliver similar results to a Builder, but will also provide the following additional benefits:

1. API delivers on use cases that a Builder may not inherently provide.
```
Toaster usedToaster = mix(() -> {
  Toaster toaster = new Toaster();
  toaster.add(new Bread());
  toaster.add(new Bagel());
  toaster.toast();
  toaster.removeAll();
  return toaster;
});
```
2. Allows you to maintain fewer Builder classes and annotations
