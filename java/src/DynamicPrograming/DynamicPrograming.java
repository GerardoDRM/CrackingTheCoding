package DynamicPrograming;

/**
 * Created by gerardo on 4/08/17.
 */
public class DynamicPrograming {

    // Fibonacci with memoization
    public int fib(int n, int[] mem) {
        if(n<=0) return 0;
        if(n == 1) return 1;
        else if(mem[n] == 0) {
            mem[n] = fib(n-1, mem) + fib(n-2, mem);
        }
        return mem[n];
    }
}
