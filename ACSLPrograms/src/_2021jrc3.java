import java.util.*;

/*
6 8 1 5 2 3 5 3 7 9 
7 6 2 9
9 3 4 6 1 8 6 4 2 8 4
1 3 5 7 9 2 4 6 8 10
5 2 6 4 8 7 9 11 14 12
4 2 6 4 7 1 9 22 21 9
5 6 7 8 9 1 2 
9 8 7 6 5 0 1 2 3 4
8 6 4 2 1 3 5 7
1 
1 2
1 2 3
31 41 59 26 53 58 97 93 23 84 62 64 33 83 27        
56 89 23 14 26 37 48 59 61 72 83 94
42 35 68 79 82 91 20 51 64 97 86
3 1 4 1 5 9 2 6 5 3 5 8 9 7
9 3 2 3 8 4 6 2 7 9 8 5 3 5 6 2 9 5 1 4 1 3
6 2 8 3 1 8 5 3 0 6
31 41 59 26 53 58 97 93 23 84 62 64 33 83 27
21 32 43 54 65 76 87 98 90 70 50 30 10
20 40 60 80 12 23 34 45 56 67 78 89
8765 4321 9012 3456 7890 321 654 987
9123 5326 8975 345 789
7654 6235 5798 6543 4567 32 54 1024 2048 4096
-5 -6 -7 -8 -9 -10 -11
-1 -2 -3 -4 -12 -8 -10 -16 -14 -12 -10 -5
-6 -9 -1 -2 -10 -7 -9 -21 -15 -10
1
1
1

*/

public class _2021jrc3 {
	
	//input
	static Scanner in;
	
	//problem-related
	static ArrayList<Integer> list1, list2, list3;
	
	//output
	static int sOL; // sum of all largests
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		for(int i = 0;i<10;i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		list1 = new ArrayList<Integer>();
		list2 = new ArrayList<Integer>();
		list3 = new ArrayList<Integer>();
		
		String line1 = in.nextLine();
		StringTokenizer st = new StringTokenizer(line1);
		while(st.hasMoreTokens()) {
			list1.add(Integer.parseInt(st.nextToken()));
		}
		
		String line2 = in.nextLine();
		st = new StringTokenizer(line2);
		while(st.hasMoreTokens()) {
			list2.add(Integer.parseInt(st.nextToken()));
		}
		
		String line3 = in.nextLine();
		st = new StringTokenizer(line3);
		while(st.hasMoreTokens()) {
			list3.add(Integer.parseInt(st.nextToken()));
		}
		
		sOL = 0;
	}
	
	public static void solve() {
		int l = Math.max(list1.size(), Math.max(list2.size(), list3.size()));
		for(int i = 0;i<l;i++) {
			//grab the largest of the 3
			int largest = Integer.MIN_VALUE;
			if(i < list1.size()) {
				if(list1.get(i) > largest) {
					largest = list1.get(i);
				}
			}
			if(i < list2.size()) {
				if(list2.get(i) > largest) {
					largest = list2.get(i);
				}
			}
			if(i < list3.size()) {
				if(list3.get(i) > largest) {
					largest = list3.get(i);
				}
			}
			
			//add that largest to sOL
			sOL += largest;
		}
	}
	
	public static void output() {
		System.out.println(sOL);
	}
}
