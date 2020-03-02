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
				
			
			//��Ī�� ��� ����ؼ� memo; original
			tiling(width);
			
			int result;
			//¦���� ��� original���� - (��� ��輱�� �ΰ� �����ִ°�� + �ƴѰ��)
			if(width%2 == 0)
				result = (memo[width] - memo[width/2] - memo[(width/2)-1]);
			//Ȧ���� original���� ��� �ϳ� ���ִ°�� ����
			else
				result = (memo[width] - memo[width/2]);
			
			while(result<0)
				result += BIGNUM;
			
			System.out.println( result );
				
		}
		
	}
	
	public static int tiling(int width) {
		//�������
		if(width==1) {
			memo[width] = 1;
			return 1;
		}else if(width==2) {
			memo[width] = 2;
			return 2;
		}
			

		//���� ���� �̹� �����ϸ�
		if(memo[width] != 0)
			return memo[width];
		//������ ��� �� memo
		else
			memo[width] = (tiling(width-1)+tiling(width-2))%BIGNUM;
		
			
			
		return memo[width];
	}
}
