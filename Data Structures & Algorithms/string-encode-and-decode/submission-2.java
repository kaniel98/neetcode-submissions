class Solution {
    // 1. There is any possible number of string / characters 
    // 2. Key consideration - Creating a set of delimiters that is used to define the start and end of the string

    // 3. It would be easy by keeping track the number of characters per string 
    // 4. Considering the string might have character, we can add a delimiter after each integer 

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            result.add(str.substring(j + 1, i));
        }

        return result;
    }
}
