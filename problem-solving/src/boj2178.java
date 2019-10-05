import java.io.*;
import java.util.*;

public class boj2178 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		int[][] map = new int[N][M];
		
				
		for(int i=0; i<N; i++) {
			String line = bf.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		
	}

}
