class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int prevAsteroid = stack.peek();
                if (prevAsteroid < -asteroid) {
                    stack.pop();
                    continue;
                } else if (prevAsteroid == -asteroid) {
                    stack.pop();
                }
                destroyed = true;
                break;
            }
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[idx] = stack.pop();
            idx--;
        }

        return result;
    }
}