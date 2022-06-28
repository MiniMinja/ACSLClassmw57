import java.util.*;

/*
5, D, 2, D, 6, H, 9, D, 9, S, 6, H
4, C, 1, C, 6, C, 7, H, 5, S, 4, D
3, D, 4, H, 5, C, 6, S, 2, D, 1, D
9, S, 8, H, 7, C, 7, D, 9, H, 3, H
1, C, 1, D, 9, H, 8, S, 9, S, 7, C
4, S, 2, S, 5, S, 6, S, 8, S, 9, S
7, H, 3, S, 3, H, 3, D, 3, C, 2, H
9, D, 3, C, 5, H, 1, S, 7, D, 9, S
6, C, 1, S, 2, H, 7, S, 8, D, 9, H
1, D, 2, S, 3, D, 4, S, 2, H, 2, C

 */
public class _1617jrc1 {
	static Scanner in;
	
	static Card oppPlay;
	static Card[] hand;
	
	static Card output;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i = 0;i<10;i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		
		StringTokenizer st = new StringTokenizer(in.nextLine(), ", ");
		int oppNum = Integer.parseInt(st.nextToken());
		char oppChar = st.nextToken().charAt(0);
		oppPlay = new Card(oppNum, oppChar);
		
		hand = new Card[5];
		for(int i = 0;i<5;i++) {
			int num = Integer.parseInt(st.nextToken());
			char suit = st.nextToken().charAt(0);
			hand[i] = new Card(num, suit);
		}
		
		output = null;
	}
	
	public static void solve() {
		//find the lowest card that is higher rank
		for(int i =0;i<5;i++) {
			//System.out.println();
			if(hand[i].suit == oppPlay.suit && hand[i].num > oppPlay.num) {
				if(output == null) {
					output = hand[i];
				}
				else if(output.num > hand[i].num){
					output = hand[i];
				}
			}
			//System.out.println();
		}
		
		//find the lowest card that is same suit
		if(output == null) {
			for(int i = 0;i<5;i++) {
				//System.out.println();
				if(hand[i].suit == oppPlay.suit) {
					if(output == null) {
						output = hand[i];
					}
					else if(output.num > hand[i].num){
						output = hand[i];
					}
				}
				//System.out.println();
			}
		}
		
		//otherwise play none
	}
	
	public static void output() {
		if(output==null) {
			System.out.println("NONE");
		}
		else {
			System.out.println(output.num + " " + output.suit);
		}
	}
}

class Card{
	int num;
	char suit;
	
	public Card(int n, char s) { //constructor
		this.num = n;
		this.suit = s;
	}
}
