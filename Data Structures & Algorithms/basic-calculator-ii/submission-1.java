class Solution {
    public int calculate(String s) {
        Set<Character> priorityOperators = Set.of('*', '/');
        Set<Character> regularOperators = Set.of('-', '+');

        List<Character> operators = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        Integer val = 0;
        for (Character chr : s.toCharArray()) {
            if (chr == ' ') {
                continue;
            }

            // Prepare the val
            if (!priorityOperators.contains(chr) && !regularOperators.contains(chr)) {
                val *= 10;
                val += Character.getNumericValue(chr);
                continue;
            }

            // Handling if is a operator instead

            // 1. First entry
            if (values.isEmpty() || !priorityOperators.contains(operators.getLast())) {
                values.add(val);
                val = 0;
                // Add the operator as well
                operators.add(chr);
                continue;
            }

            // 2. Check if the last entry in the operator is either / or *
            if (priorityOperators.contains(operators.getLast())) {
                // Get the last operator
                // Get the last value
                Integer first = values.removeLast();
                Character operator = operators.removeLast();

                if (operator.equals('/')) {
                    values.add(first / val);
                } else {
                    values.add(first * val);
                }
                val = 0;
                operators.add(chr);
            }
        }

        if (operators.size() > 0 && priorityOperators.contains(operators.getLast())) {
            Integer first = values.removeLast();
            Character operator = operators.removeLast();
            if (operator.equals('/')) {
                values.add(first / val);
            } else {
                values.add(first * val);
            }
        } else {
            values.add(val);
        }

        // Handle the remaining values
        if (values.size() == 1) {
            return values.get(0);
        }
        int res = values.get(0);

        for (int i = 1; i < values.size(); i++) {
            Integer val2 = values.get(i);
            Character operator = operators.get(i - 1);

            if (operator == '+') {
                res += val2;
            } else {
                res -= val2;
            }
        }

        return res;
    }
}