import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_TRIPATHCNT {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = bf.readLine().trim();
		int T = Integer.parseInt(input);
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt( bf.readLine().trim() );
			
			int[][] triangle = new int[N][N];
			int[][] sumTriangle = new int[N][N];
			//root���� �ش����������� ��� ��
			int[][] pathCount = new int[N][N];
			
			//fill triangle
			for(int i=0; i<N; i++) {
				
				String[] stringChunks = bf.readLine().split(" ");
				
				int j = 0; 
				for(String stringChunk: stringChunks) {
					triangle[i][j] = Integer.parseInt(stringChunk);
					j++;
				}
			}
			//fill pathCount[0][0]
			pathCount[0][0] = 1;
			
			//fill sumTriangle
			sumTriangle[0][0] = triangle[0][0];
			for(int i=0; i<N-1; i++) {
				for(int j=0; j<=i; j++) {
					int parentEl = sumTriangle[i][j];
					int leftChild = triangle[i+1][j];
					int rightChild = triangle[i+1][j+1];
					
					//parentEl�� 
					//�ٷ� �Ʒ� update
					int prevSum = sumTriangle[i+1][j];
					int newSum = parentEl+leftChild;
					
					//������ ������ ũ��
					//sumTrianle update
					//leftChild������ pathCount = parentEl������ pathCount
					if(prevSum<newSum) {
						sumTriangle[i+1][j] = newSum;
						pathCount[i+1][j] = pathCount[i][j];
						
					//���� ���� �Ȱ�����
					//leftChild������ pathCount += parentEl������ pathCount
					}else if(prevSum == newSum) {
						pathCount[i+1][j] += pathCount[i][j];
					}
						
					
					//�Ʒ� ������ update
					sumTriangle[i+1][j+1] = parentEl+rightChild;
					pathCount[i+1][j+1] = pathCount[i][j];
				}
			}
			
			
			//search max;
			int maxVal = -1;
			int maxCount = 0;
			for(int i=0; i<N; i++) {
				if( maxVal<sumTriangle[N-1][i] ) {
					maxVal = sumTriangle[N-1][i];
					maxCount = pathCount[N-1][i];
				}else if(maxVal==sumTriangle[N-1][i])
					maxCount += pathCount[N-1][i];
			}
			
			System.out.println(maxCount);
		}
	}
	
}
