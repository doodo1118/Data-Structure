package jungsuk;

import java.util.*;

class Practice{
	public static void
	main(String[] args) {
		int[][] bingo = new int[5][5];
		
		Set set = new HashSet();
		
		while(set.size()<25) {
			set.add((int)Math.random()*50+1);
		}
		
		
		Iterator it = set.iterator();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(it.hasNext())
					bingo[i][j] = (int)it.next();
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(bingo[i][j]);
			}
		}
		
		
	}
}