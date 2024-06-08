class Solution {
    int[] fiboanacis;
    public int fib(int input) {
        if(input == 0 || input == 1) return input;
        fiboanacis = new int[input + 1];
        Arrays.fill(fiboanacis, -1);
        fiboanacis[0] = 0;
        fiboanacis[1] = 1;
        return calculateFibonacciNumber(input);
    }

    private int calculateFibonacciNumber(int input) {
        if (input < 0) return 0;
        if (fiboanacis[input] != -1) return fiboanacis[input];
        fiboanacis[input] = calculateFibonacciNumber(input - 1) + calculateFibonacciNumber(input - 2);
        return fiboanacis[input];
    }
}