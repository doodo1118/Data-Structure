import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_TRIANGLEPATH {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = bf.readLine().trim();
		int T = Integer.parseInt(input);
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt( bf.readLine().trim() );
			
			int[][] triangle = new int[N][N];
			int[][] sumTriangle = new int[N][N];
			
			//fill triangle
			for(int i=0; i<N; i++) {
				
				//testcase에서 구분자가 두가지..
				String[] stringChunks = bf.readLine().split("  ");
				if(stringChunks.length == 1)
					stringChunks = stringChunks[0].split(" ");
				
				int j = 0; 
				for(String stringChunk: stringChunks) {
					triangle[i][j] = Integer.parseInt(stringChunk);
					j++;
				}
			}
			
			//fill sumTriangle
			sumTriangle[0][0] = triangle[0][0];
			for(int i=0; i<N-1; i++) {
				for(int j=0; j<=i; j++) {
					int parentEl = sumTriangle[i][j];
					int leftChild = triangle[i+1][j];
					int rightChild = triangle[i+1][j+1];
					
					int prevSum = sumTriangle[i+1][j];
					int newSum = parentEl+leftChild;
					
					sumTriangle[i+1][j] = prevSum<newSum?newSum:prevSum;
					sumTriangle[i+1][j+1] = parentEl+rightChild;
				}
			}
			
			//search max;
			int max = sumTriangle[N-1][0];
			for(int i=0; i<N-1; i++) {
				max = Math.max(max, sumTriangle[N-1][i+1]);
			}
			
			System.out.println(max);
		}
	}
}
