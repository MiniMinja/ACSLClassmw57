import java.util.*;
public class _2021jrc1 {

/*
2 3 5 
221 2 4 
184 231 35
71 5 27 
1 24 100 
599 23 43
4326 1234 80
704 1776 200
6283 185 31
3141 59 26

 */
	static Scanner in;
	
	static int s, d, r;
	
	static int sum;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i =0;i<10;i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		s = in.nextInt();
		d = in.nextInt();
		r = in.nextInt();
		sum = 0;
	}
	
	public static void solve() {
		int[] row = new int[r];
		int val = s;
		for(int limit = 1;limit <= r;limit++) {
			for(int i = 0;i<limit;i++) {
				row[i] = transform(val);
				val += d;
			}
			//System.out.println(Arrays.toString(row));
		}
		
		for(int i = 0;i<r;i++) {
			sum += row[i];
		}
	}
	
	public static void output() {
		System.out.println(sum);
	}
	
	public static int transform(int num) {
		while(num > 9) {
			int sum = 0;
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			num = sum;
		}
		return num;
	}
}
