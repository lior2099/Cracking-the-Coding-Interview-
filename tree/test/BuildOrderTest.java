package il.co.ilrd.book.tree.test;

import il.co.ilrd.book.tree.BuildOrder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildOrderTest {

    @Test
    void testValidBuildOrder() {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}
        };

        List<String> buildOrder = BuildOrder.findBuildOrder(projects, dependencies);

        // Verify the order
        assertTrue(buildOrder.indexOf("f") < buildOrder.indexOf("a"));
        assertTrue(buildOrder.indexOf("f") < buildOrder.indexOf("b"));
        assertTrue(buildOrder.indexOf("a") < buildOrder.indexOf("d"));
        assertTrue(buildOrder.indexOf("b") < buildOrder.indexOf("d"));
        assertTrue(buildOrder.indexOf("d") < buildOrder.indexOf("c"));
    }

    @Test
    void testNoDependencies() {
        String[] projects = {"a", "b", "c"};
        String[][] dependencies = {};

        List<String> buildOrder = BuildOrder.findBuildOrder(projects, dependencies);

        assertEquals(3, buildOrder.size());
        assertTrue(buildOrder.contains("a"));
        assertTrue(buildOrder.contains("b"));
        assertTrue(buildOrder.contains("c"));
    }

    @Test
    void testSingleProject() {
        String[] projects = {"a"};
        String[][] dependencies = {};

        List<String> buildOrder = BuildOrder.findBuildOrder(projects, dependencies);

        assertEquals(1, buildOrder.size());
        assertEquals("a", buildOrder.get(0));
    }

    @Test
    void testCircularDependency() {
        String[] projects = {"a", "b", "c"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"c", "a"}
        };

        Exception exception = assertThrows(RuntimeException.class, () -> {
            BuildOrder.findBuildOrder(projects, dependencies);
        });

        assertEquals("Circular dependency detected!", exception.getMessage());
    }

    @Test
    void testDisconnectedProjects() {
        String[] projects = {"a", "b", "c", "d"};
        String[][] dependencies = {
                {"a", "b"},
                {"c", "d"}
        };

        List<String> buildOrder = BuildOrder.findBuildOrder(projects, dependencies);

        // Verify no specific order between disconnected groups
        assertTrue(buildOrder.indexOf("a") < buildOrder.indexOf("b"));
        assertTrue(buildOrder.indexOf("c") < buildOrder.indexOf("d"));
    }
}
