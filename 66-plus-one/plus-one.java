class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null) return digits;
        int length = digits.length, carry = 1;
        int[] result = new int[length + 1];
        for(int i = length-1; i>=0;i--){
            int sum = carry + digits[i];
            carry = sum / 10;
            sum = sum % 10;
            result[i + 1] = sum;
        }
        if(carry > 0){
            result[0] = carry;
        }else{
            int[] temp = new int[length];
            for(int i = 1; i < result.length;i++) temp[i-1] = result[i];
            result = temp;
        }
        return result;

    }
}