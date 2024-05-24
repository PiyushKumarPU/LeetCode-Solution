class Solution {
    public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        int start = 0, end = input.length()-1;
        while(start < end){
            if(input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}