class Solution {
    public String simplifyPath(String path) {
        // First split by "/" , this will leave the weird weird slash
        String[] directories = path.split("/");

        Stack<String> stack = new Stack<>(); 

        for (int i = 0; i < directories.length; i ++) {
            String sub = directories[i];

            if (sub.isEmpty()) {
                continue;
            }

            if (sub.equals(".")) {
                continue; // No need to do anything
            }

            if (sub.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(sub);
        }

        return "/" + String.join("/", stack);
    }
}