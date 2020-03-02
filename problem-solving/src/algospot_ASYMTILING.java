import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_ASYMTILING {
	static int[] memo = new int[101];
	static int[] dividedTimes = new int[101];
	static final int BIGNUM = 1000000007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt( bf.readLine() );
		for(int t=0; t<T; t++) {
			int width = Integer.parseInt( bf.readLine() );
			
			if(width==1 || width==2) {
				System.out.println(0);
				continue;
			}
				
			
			//대칭인 경우 허용해서 memo; original
			tiling(width);
			
			int result;
			//짝수인 경우 original에서 - (가운데 경계선에 두개 누워있는경우 + 아닌경우)
			if(width%2 == 0)
				result = (memo[width] - memo[width/2] - memo[(width/2)-1]);
			//홀수면 original에서 가운데 하나 서있는경우 빼줌
			else
				result = (memo[width] - memo[width/2]);
			
			while(result<0)
				result += BIGNUM;
			
			System.out.println( result );
				
		}
		
	}
	
	public static int tiling(int width) {
		//기저사례
		if(width==1) {
			memo[width] = 1;
			return 1;
		}else if(width==2) {
			memo[width] = 2;
			return 2;
		}
			

		//계산된 값이 이미 존재하면
		if(memo[width] != 0)
			return memo[width];
		//없으면 계산 후 memo
		else
			memo[width] = (tiling(width-1)+tiling(width-2))%BIGNUM;
		
			
			
		return memo[width];
	}
}
