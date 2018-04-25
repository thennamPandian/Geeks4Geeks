package arrays.assign;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strange-code/problem
 * 
 * 
 *
 */
public class StrangeCounter {

	static long strangeCode(long t) {
        // Complete this function
		long x = (long)(t/3);
		long r = (x > 1) ? (long) (Math.log(x)/Math.log(2)) : x;
		long startPoint = (long)( 3*Math.pow(2, r));
		long previousEndPoint = 3*((long)Math.pow(2, r)-1);
		long difference = t - previousEndPoint ;
		return startPoint-difference+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        long result = strangeCode(t);
        System.out.println(result);
        in.close();
    }

}
