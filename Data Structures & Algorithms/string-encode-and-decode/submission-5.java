class Solution {

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

        int index = 0;
        while (index < str.length()) {
            // First get length
            Character chr = str.charAt(index);
            int count = 0;
            while (index < str.length() && Character.isDigit(chr)) {
                count *= 10;
                count += Integer.parseInt(String.valueOf(chr));
                index ++;
                chr = str.charAt(index);
            }

            index ++; 
            StringBuilder sb = new StringBuilder();
            while (count > 0) {
                sb.append(str.charAt(index));
                index ++;
                count --;
            }
            result.add(sb.toString());
        }
        

        return result;
    }
}
