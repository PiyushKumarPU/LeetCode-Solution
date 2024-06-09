class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        
        double pow = 1;
        
        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            } 
                
            x *= x;
            n >>>= 1;
            
        }
        
        return pow;
    }

    private static java.math.BigDecimal power(java.math.BigDecimal x, long n) {
        if (n == 0) {
            return java.math.BigDecimal.valueOf(1);
        }
        
        java.math.BigDecimal temp = power(x, n / 2);
        
        if (n % 2 == 0) {
            return temp.multiply(temp);
        } else {
            return x.multiply(temp).multiply(temp);
        }
    }
}