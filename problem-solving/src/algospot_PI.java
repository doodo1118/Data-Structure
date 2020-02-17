import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algospot_PI {
	static int[] difficulty = new int[10001];
	static String input;
	static int[] diff = new int[4];
	static final int IMPOSSIBLE = 99999;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt( bf.readLine().trim() );
		for(int t=0; t<T; t++) {
			input = bf.readLine().trim();
			Arrays.fill(difficulty, -1);
			
			difficulty[input.length()] = 0;
			difficulty[input.length()-1] = IMPOSSIBLE;
			difficulty[input.length()-2] = IMPOSSIBLE;
			
			int asnwer = getDiffic(0);
			System.out.println(asnwer);
			
		}
	}
	//index���� input�������� ���̵����ϱ�
	public static int getDiffic(int index) {

		//�̹� ���� �ִ� ���
		if(difficulty[index]!=-1) 
			return difficulty[index];
		
		//input ���� �����
		if(input.length()<index)
			return IMPOSSIBLE;
		
		int a = getDiffic(index+3);
		int b = getDiffic(index+4);
		int c = getDiffic(index+5);

		//������ ��� ���� ¥���� ������ ���� ��
		if(a==IMPOSSIBLE && b==IMPOSSIBLE && c==IMPOSSIBLE) {
			difficulty[index] = IMPOSSIBLE;
			return IMPOSSIBLE;
		}else {
			difficulty[index] = 
					Math.min( getPieceDiffic(index, index+2) + a,
					Math.min( getPieceDiffic(index, index+3) + b,
							getPieceDiffic(index, index+4) + c) );
			
			return difficulty[index];
		}
			

		
		
	}
	public static int getPieceDiffic(int headIndex, int tailIndex) {
		if(input.length()-1<tailIndex) 
			return 0;
		
		int pieceSize = tailIndex - headIndex + 1;
		
		for(int i=headIndex; i<tailIndex; i++)
			diff[i-headIndex] = input.charAt(i+1)-input.charAt(i);

		if(isCaseOne(pieceSize)) 
			return 1;			
		else if(isCaseTwo(pieceSize)) 
			return 2;
		else if(isCaseThree(pieceSize))	
			return 4;
		else if(isCaseFour(pieceSize))
			return 5;
		else
			return 10;
		
	}
	//��ΰ��� ��?
	public static boolean isCaseOne(int pieceSize) {
		int i=0;
		while(i<pieceSize-1) {
			if(diff[i]==0) {
				i++;
			}else
				break;
		}
		if(i==pieceSize-1)
			return true;
		else 
			return false;
	}
	//�������� or ��������?
	public static boolean isCaseTwo(int pieceSize) {
		int i=1;
		while(i<pieceSize-1) {
			if(diff[i]==diff[i-1]) {
				i++;
			}else
				break;
		}
		
		if(i==pieceSize-1 && (diff[0]==1||diff[0]==-1) )
			return true;
		else 
			return false;
	}
	//�ΰ��� ���� �����ư��鼭?
	public static boolean isCaseThree(int pieceSize) {
		int i=1;
		while(i<pieceSize-1) {
			if(diff[i]==(-1)*diff[i-1]) {
				i++;
			}else
				break;
		}
		
		if(i==pieceSize-1)
			return true;
		else 
			return false;
	}
	//��������?
	public static boolean isCaseFour(int pieceSize) {
		int i=1;
		while(i<pieceSize-1) {
			if(diff[i]==diff[i-1]) {
				i++;
			}else
				break;
		}
		
		if(i==pieceSize-1)
			return true;
		else 
			return false;
	}
}
