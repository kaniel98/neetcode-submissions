class Solution {
    public String largestNumber(int[] nums) {
        // Convert to string, sort by the first number largest to smallest 
        List<String> numStrings = new ArrayList<>();
        for (int num : nums) {
            numStrings.add( Integer.toString(num));
        }

        // Sort by concatenation order
        numStrings.sort((a, b) -> (b + a).compareTo(a + b));

        if (numStrings.get(0).equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : numStrings) {
            sb.append(str);
        }

        return sb.toString();
    }
}