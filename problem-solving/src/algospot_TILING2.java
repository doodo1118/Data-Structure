import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_TILING2 {
	static int[] memo = new int[101];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt( bf.readLine() );
		for(int t=0; t<T; t++) {
			int width = Integer.parseInt( bf.readLine() );
			System.out.println( tiling(width) );
		}
		
	}
	
	public static int tiling(int width) {
		//�������
		if(width==1)
			return 1;
		else if(width==2)
			return 2;

		//���� ���� �̹� �����ϸ�
		if(memo[width] != 0)
			return memo[width];
		//������ ��� �� memo
		else 
			memo[width] = ( tiling(width-1)+tiling(width-2) )%1000000007;
			
		return memo[width];
	}
}
