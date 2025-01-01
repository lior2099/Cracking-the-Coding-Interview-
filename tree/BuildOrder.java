package il.co.ilrd.book.tree;

import java.util.*;

public class BuildOrder {
    /*
    Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
    projects, where the second project is dependent on the first project). All of a project's dependencies
    must be built before the project is. Find a build order that will allow the projects to be built. If there
    is no valid build order, return an error.

    EXAMPLE
    Input:
    projects: a, b, c, d, e, f
    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    Output: f, e, a, b, d, c
     */

    public static List<String> findBuildOrder(String[] projects, String[][] dependencies) {
        Set<String> hasDependencies = new HashSet<>();

        Map<String, Set<String>> dependencyMap = new HashMap<>();

        for (String project : projects) {
            dependencyMap.put(project, new HashSet<>());
        }

        for (String[] dep : dependencies) {
            String prerequisite = dep[0];  //  built first
            String dependent = dep[1];     //  depends on prerequisite
            dependencyMap.get(dependent).add(prerequisite);
            hasDependencies.add(dependent);
        }

        List<String> buildOrder = new ArrayList<>();
        Set<String> built = new HashSet<>();

        // add all projects that have no dependencies
        for (String project : projects) {
            if (!hasDependencies.contains(project)) {
                buildOrder.add(project);
                built.add(project);
            }
        }

        // detect cycles
        int prevSize = -1;

        // Continue until all projects are built or we can't make progress
        while (built.size() < projects.length) {

            if (prevSize == built.size()) {
                throw new RuntimeException("Circular dependency detected!");
            }
            prevSize = built.size();

            // Try to add projects whose dependencies are all built
            for (String project : projects) {
                if (!built.contains(project)) {
                    Set<String> projectDependencies = dependencyMap.get(project);
                    if (built.containsAll(projectDependencies)) {
                        buildOrder.add(project);
                        built.add(project);
                    }
                }
            }
        }

        return buildOrder;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}
        };

        try {
            List<String> buildOrder = findBuildOrder(projects, dependencies);
            System.out.println("Build Order: " + String.join(", ", buildOrder));
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
