import java.io.IOException;
import java.util.Scanner;

public class algospot_QUADTREE {
	static String original;
	static int index;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		
		int T = Integer.parseInt(s.nextLine());
		for(int t=0; t<T; t++) {
			original = s.nextLine();
			index = 0;
			
			if(original.length()==1)
				System.out.println(original);
			else System.out.println(getSorted());
		}
	}
	public static String getSorted() {
		//chldnjsrnr ehdlf dkssorus
		String[] childrens = new String[4];
		childrens = getChildrens();
		
		return sortChildrens(childrens);
	}
	public static String sortChildrens(String[] childrens) {
		String TL = childrens[0]==null?"":childrens[0];
		String TR = childrens[1]==null?"":childrens[1];
		String BL = childrens[2]==null?"":childrens[2];
		String BR = childrens[3]==null?"":childrens[3];
		
		return BL+BR+TL+TR;
	}
	
	public static String[] getChildrens() {
		String[] childrens = new String[4];
		int numOfFoundedChildren = 0;
		
		while(numOfFoundedChildren < 4 && index<original.length()) {
			if(original.charAt(index) == 'x') {
				index++;
				childrens[numOfFoundedChildren] = 'x'+getSorted();
			}else {
				childrens[numOfFoundedChildren] = Character.toString( original.charAt(index) );
			}
			index++;
			numOfFoundedChildren++;
		}
		//44번째 줄의 재귀 끝날때. 다시 안빼주면 while루프 한번 내에서 index++가 두번 되는 꼴.
		index--;
		return childrens;
	}
	
}