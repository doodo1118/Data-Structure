//문제 : https://algospot.com/judge/problem/read/SNAIL
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class algospot_SNAIL {
	static final double RAINY = 0.75;
	static final double CLEAN = 0.25;
	
	static int HEIGHT;
	static int MAXDATE;
	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		for(int t=0; t<T; t++) {
			HEIGHT = s.nextInt();
			MAXDATE = s.nextInt();
			
			double[][] memo = new double[MAXDATE+1][HEIGHT+1];
			
			for(double[] el:memo) {
				Arrays.fill(el, -1);
			}
			//가장 빠르게 나갈경우
			int MINDATE = (int) Math.ceil(HEIGHT/2);
			
			double chance=0;
			
			chance = getChance(0, 0, memo);
			
			System.out.println(chance);
		}
	}
	
	public static double getChance(int currentHeight, int date, double[][] memo) {
		if(MAXDATE<date)
			return 0;
		if(HEIGHT<=currentHeight)
			return 1;
		
		double ret = memo[date][HEIGHT-currentHeight]; 
		if( ret != -1 )
			return ret;
		
		double c1 = RAINY*getChance(currentHeight+2, date+1, memo);
		double c2 = CLEAN*getChance(currentHeight+1, date+1, memo);
		
		ret = c1+c2;
		memo[date][HEIGHT-currentHeight] = ret;
		
		return ret;
	}
}