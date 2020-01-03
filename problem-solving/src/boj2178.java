import java.io.*;
import java.util.*;

public class boj2178 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = bf.readLine().split(" ");
	
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[][] map = new int[N][M];
				
		for(int i=0; i<N; i++) {
			String line = bf.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] discovered = new boolean[N][M];
		
		for(boolean[] el : discovered) {
			Arrays.fill(el, false);	
		}
		
		//corX, corY, depth
		queue.add(new int[] {0,0,1});
		int[][] adj = new int[][] {{1, 0},{0, 1},{-1, 0},{0, -1}};
		
		while(!queue.isEmpty()) {
			int[] here = queue.poll();
			
			if(here[0]==N-1 && here[1]==M-1) {
				System.out.print(here[2]);
			}
			
			//corX, corY, depth
			int[] there = new int[3];
			there[2] = here[2]+1;
			
			for(int i=0; i<adj.length; i++) {
				there[0] = here[0] + adj[i][0];
				there[1] = here[1] + adj[i][1];
				
				if(-1<there[0] && there[0]<N && -1<there[1] && there[1]<M && !discovered[there[0]][there[1]] && map[there[0]][there[1]]!=0) {
					queue.add(new int[] {there[0], there[1], there[2]});
					discovered[there[0]][there[1]] = true;
				
				}
			}
		
		}
		
		
		
	}
}
