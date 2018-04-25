package arrays.assign;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * flatland is a country with cities, of which have space stations. Each city, ,
 * is numbered with a distinct index from to , and each city is connected to
 * city by a bidirectional road that is in length
 * 
 * URL ==> https://www.hackerrank.com/challenges/flatland-space-stations/problem
 *
 */
public class FlatAndSpaceStation {

	static int flatlandSpaceStations(int n, int[] c) {
		// Complete this function

		int maxDist = 0;
		if( n != c.length) {
		
			Arrays.sort(c);
			for(int i = 0; i < c.length-1; i++ ){
				int diff = c[i+1] - c[i]-1;
				int dist = ( diff/ 2)+ ( diff% 2) ;
				if(maxDist < dist) {
					maxDist = dist;
				}
			}
			
			if(maxDist < Math.abs((0-c[0]))) {
				maxDist = Math.abs((0-c[0]));
			}
			
			if(maxDist < (n-c[c.length-1])) {
				maxDist = n-c[c.length-1];
			}
		}
		
		return maxDist;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] c = new int[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextInt();
		}
		int result = flatlandSpaceStations(n, c);
		System.out.println(result);
		in.close();
	}

}
