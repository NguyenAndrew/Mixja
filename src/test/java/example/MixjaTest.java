package example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.andyln.Mixja.eix;
import static com.andyln.Mixja.mix;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MixjaTest {

    private static final List<String> LIST = mix(() -> {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("how");
        list.add("are");
        list.add("you");
        return list;
    });

    // Should be static in regular code, making non-static for testing purposes.
    private final Map<String, String> MAP = mix(() -> {
        Map<String, String> map = new HashMap<>();
        map.put("Grace", "Hopper");
        map.put("Ada", "Lovelace");
        map.put("Alan", "Turing");
        return map;
    });

    // Should be static final in regular code, making non-static non-final for testing purposes.
    private Set<String> set = mix(() -> {
        Set<String> set = new HashSet<>();
        set.add("My");
        set.add("Oh");
        // Duplicate set element added for testing purposes.
        set.add("My");
        return set;
    });

    private static final Set<String> BROKEN_MOCK_SET = eix(() -> {
        // Note: Warning cannot be avoided for mocks with generic parameters
        Set<String> brokenMockSet = mock(Set.class);
        when(brokenMockSet.add(anyString())).thenThrow(new UnsupportedOperationException());
        return brokenMockSet;
    });

    @Test
    void test_List() {
        // Constants not used, for easier readability and less code to maintain.
        assertEquals("Hi", LIST.get(0));
        assertEquals("how", LIST.get(1));
        assertEquals("are", LIST.get(2));
        assertEquals("you", LIST.get(3));
    }

    @Test
    void test_Map() {
        // Constants not used, for easier readability and less code to maintain.
        assertEquals("Hopper", MAP.get("Grace"));
        assertEquals("Lovelace", MAP.get("Ada"));
        assertEquals("Turing", MAP.get("Alan"));
    }

    @Test
    void test_Set() {
        // Constants not used, for easier readability and less code to maintain.
        assertEquals(2, set.size());
        assertTrue(set.contains("My"));
        assertTrue(set.contains("Oh"));
    }

    @Test
    void test_Broken_Mock_Set() {
        assertThrows(UnsupportedOperationException.class, () -> BROKEN_MOCK_SET.add("Any string will thrown exception here"));
    }
}