class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x; 
        int reversed = 0; 

        while (temp != 0) {
            int lastDigit = temp % 10;
            reversed *= 10;
            reversed = reversed + lastDigit; 
            temp /= 10;
        }
        System.out.println(reversed);

        return reversed == x;
    }
}