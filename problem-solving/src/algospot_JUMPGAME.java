import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_JUMPGAME {
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//T = testcase
		String input = bf.readLine().trim();
		int T = Integer.parseInt(input);
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(bf.readLine());
			
			int[][] map = new int[N][N];

			//set map
			for(int i=0; i<N; i++) {
				String[] chunks = bf.readLine().split(" ");				
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt( chunks[j] ); 
				}
			}
			
			if( canBeReached(map, new int[] {N-1, N-1}) ) {
				System.out.println("YES");
			}else{
				System.out.println("NO");
			};
			
		}
	}
	public static boolean canBeReached(int[][] map, int[] here) {
		int hereRow = here[0];
		int hereCol = here[1];
		
		//기저사례 //이미 체크된 경우도 가지치기하면 더 빠를듯
		if(hereRow == 0 && hereCol == 0) 
			return true;
		
		int thereRow = hereRow-1;
		int thereCol = hereCol-1;
		
		while(0<=thereCol) {
			int[] there = new int[] {hereRow, thereCol};
			
			if(isConnected(map, here, there))
				if( canBeReached(map, there) )
					return true;
			
			thereCol--;
		}
		
		thereCol = hereCol-1;
		while(0<=thereRow) {
			int[] there = new int[] {thereRow, hereCol};
			
			if(isConnected(map, here, there))
				if( canBeReached(map, there) )
					return true;
			
			
			thereRow--;
		}
		return false;
	}
	public static boolean isConnected(int[][] map, int[] to, int[] from) {
		if( map[from[0]][from[1]] == to[0]-from[0]+to[1]-from[1]) {
			return true;
		}
		return false;
	}
}
