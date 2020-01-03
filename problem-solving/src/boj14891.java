import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//set cogwheels
		String[] cogwheels_str = new String[4];
		boolean[][] cogwheels = new boolean[4][8];

		//N�� : false, S��: true
		for(int i=0; i<4; i++) {
			cogwheels_str[i] = bf.readLine();
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				cogwheels[i][j] = cogwheels_str[i].charAt(j)-'0'==1?true:false;
			}
		}
		//~set cogwheels
		
		//set manipulatation
		int T = Integer.parseInt(bf.readLine());
		for(int i=0; i<T; i++) {
			String[] cogNumAndDir = bf.readLine().split(" ");
			int cogNum = Integer.parseInt(cogNumAndDir[0]);
			int Dir = Integer.parseInt(cogNumAndDir[1]);
			
			int[] pivot = new int[] {0,0,0,0};
			int[] left = new int[] {6, 6, 6, 6};
			int[] right = new int[] {2, 2, 2, 2};
			
			//��Ϲ��� ȸ��
			pivot[cogNum-1] = Dir==1?(pivot[cogNum-1]+1)%7:pivot[cogNum-1]>0?pivot[cogNum-1]-1:7;
			left[cogNum-1] =  (pivot[cogNum-1]+6)%8;
			right[cogNum-1] =  (pivot[cogNum-1]+2)%8;
			
			//������ ������
			for(int n=cogNum; n<4; n++) {
				if(cogwheels[n-1][right[n-1]] == cogwheels[n][left[n]]) {
					pivot[n] += Dir;pivot[n]
					//enum Ȱ��? �ֳ��ϸ� 0���� -1�̸� �� �ڵ尡 �����. 
				}else {
					
				}
					 
			}
			
			//���� ������
			for(int n=cogNum-2; 0<=n; n--) {
				
			}
		}
	}
}
