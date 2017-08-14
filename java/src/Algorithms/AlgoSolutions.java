package Algorithms;

/**
 * Created by gerardo on 7/08/17.
 */
public class AlgoSolutions {

    // Hacker Rank Between Two Sets
    static int gcd(int a, int b) {
        if(a == 0 || b == 0) return a+b;
        return gcd(b, a%b);
    }

    static int lcm(int a, int b) {
        return (Math.abs(a)/gcd(a,b)) * Math.abs(b);
    }

    static int getTotalX(int[] a, int[] b) {
        // get GCD
        int resGCD = b[0];
        for(Integer v:b) {
            resGCD = gcd(v, resGCD);
        }

        // get LCM
        int resLCM = 1;
        for(Integer v:a) {
            resLCM = lcm(v, resLCM);
        }

        // Complete this function
        int tmpLCM = resLCM;
        int counter = 0;
        while(resLCM <= resGCD) {
            if(resGCD % resLCM == 0) {
                counter++;
            }
            resLCM += tmpLCM;
        }
        return counter;
    }

}
