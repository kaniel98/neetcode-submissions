class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Construct adjacency list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prereq : prerequisites) {
            map.putIfAbsent(prereq[0], new ArrayList<>());
            map.putIfAbsent(prereq[1], new ArrayList<>());
            map.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < numCourses; i ++) {
            if (!checkCourse(map, i, visiting)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCourse(
        Map<Integer, List<Integer>> map, Integer course, Set<Integer> visiting) {
        if (visiting.contains(course)) {
            return false;
        }

        if (!map.containsKey(course) || map.get(course).isEmpty()) {
            return true;
        }

        visiting.add(course);
        for (int sub : map.get(course)) {
            if (!checkCourse(map, sub, visiting)){
                return false; 
            }
        }

        visiting.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
