import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestListComparator {
    @Before
    public List<String> fillFirstList() {
        List<String> firstList = new ArrayList<>() {{
            add("shovel");
            add("iron");
            add("ground");
            add("water");
        }};
        return firstList;
    }
    @Before
    public List<String> fillSecondList() {
        List<String> secondList = new ArrayList<>() {{
            add("new shovel");
            add("iron mug");
            add("air");
        }};
        return secondList;
    }
    @Before
    public Map<String, String> fillMap() {
       Map<String, String> map = new LinkedHashMap<>();
       map.put("shovel", "new shovel");
       map.put("iron", "iron mug");
       map.put("ground", "?");
       map.put("water", "?");
       return map;
    }
    @Test
    public void compareListsTest() {
        Assertions.assertEquals(fillMap(), ListComparator.compareLists(fillFirstList(), fillSecondList()));
    }
}