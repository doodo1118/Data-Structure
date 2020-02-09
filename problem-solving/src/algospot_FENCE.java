import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_FENCE {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = bf.readLine();
		
		int T = Integer.parseInt(input);
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(bf.readLine());
			
			int[] array = new int[N];

			//set array
			String[] chunks = bf.readLine().split(" ");
			for(int i=0; i<N; i++) {			
				array[i] = Integer.parseInt( chunks[i] ); 
			}
			
			System.out.println( solve(array, 0, N-1) );
			
		}
	}
	
	//return broaderArea
	public static int solve(int[] array, int left, int right) {

		if(left == right)
			return array[left];
		
		int mid = (left+right)/2;
		
		int resultOfLeftSide = solve(array, left, mid);
		int resultOfRightSide = solve(array, mid+1, right);
		
		//mid에 걸쳐있는 경우
		int height = Math.min(array[mid], array[mid+1]);
		int width = 2;
		int area = height*width;
		
		int maxArea = Math.max( Math.max(resultOfLeftSide, resultOfRightSide), area );
		
		int i = mid; int j = mid+1;
		while(left<i || j<right) {
			if( (j==right&&left<i) || (j<right&&left<i&&array[i-1]>array[j+1])) {
				i--;
				height = Math.min( array[i], height );
			}else if( (i==left&&j<right) || (j<right&&left<i&&array[i-1]<=array[j+1]) ){
				j++;
				height = Math.min( array[j], height );
			}else {
				break;
			}
			
			width = j-i+1;
			
			maxArea = Math.max(maxArea, width*height);
		}

		return maxArea;
	}
}