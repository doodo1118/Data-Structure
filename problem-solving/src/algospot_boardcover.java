import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_boardcover{
	public static void main(String args[]) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = bf.read();
		
		for(int i=0; i<T; i++) {
			
			String HW = bf.readLine();
			int H = HW.charAt(0)-'0';
			int W = HW.charAt(0)-'2';
			
			boolean[][] board = new boolean[H][W];
			
			
			
			//set board
			for(int j=0; j<H; j++) {
				String row = bf.readLine();
				for(int k=0; k<W; k++) {
					board[j][k] = row.charAt(k)=='#'?false:true;
				}
			}
			
			
		}
		
		
	}
}
