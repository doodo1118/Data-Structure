import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algospot_CLOCKSYNC {
	static int[] time = new int[] {12, 3, 6, 9};
	static int[][] combinationOfClocks = new int[][] {
		{0, 1, 2},
		{3, 7, 9, 11},
		{4, 10, 14, 15},
		{0, 4, 5, 6, 7},
		{6, 7, 8, 10, 12},
		{0, 2, 14, 15},
		{3, 14, 15},
		{4, 5, 7, 14, 15},
		{1, 2, 3, 4, 5},
		{3, 4, 5, 9, 13},
	};
	static int[] stateOfClocks = new int[16];
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=0; t<T; t++) {
			
			//set stateOfClocks;
			String[] inputString = bf.readLine().split(" ");
			for(int i=0; i<16; i++)
				stateOfClocks[i] = Integer.parseInt(inputString[i]);
			
			
			min = 9999999;
			int depth = 0;
			int clickTimes = 0;
			solution(depth, clickTimes);	
			System.out.println(min==9999999?-1:min);
		}
		
	} 
	
	public static void solution(int depth, int clickTimes) {
		if( hasAllClocksBeenSet() ) {
			updateMin(clickTimes); return;
		}
		
		if( depth==10 ) {
			min = min==9999999? 9999999: min; return;
		}
		
		int[] clocksToWind = combinationOfClocks[depth];
		
		for(int j=0; j<4; j++) {
			windClocks(j, clocksToWind);
			solution(depth+1, clickTimes+j);
			rewindClocks(j, clocksToWind);
		}
	}
	public static void windClocks(int howManyTimes, int[] clocksToWind) {	
		if(howManyTimes == 0)
			return;
		for(int i=0; i<clocksToWind.length; i++)
			wind(howManyTimes, clocksToWind[i], 1);
	}
	public static void rewindClocks(int howManyTimes, int[] clocksToWind) {
		if(howManyTimes == 0)
			return;
		for(int i=0; i<clocksToWind.length; i++)
			wind(howManyTimes, clocksToWind[i], -1);
	}
	public static void updateMin(int clickTimes) {
		min = min<clickTimes?min:clickTimes;
	}
	
	public static void wind(int howManyTimes, int whichClock, int direction) {
		stateOfClocks[whichClock] = (stateOfClocks[whichClock]+3*direction*howManyTimes)%12;
		
		stateOfClocks[whichClock] = stateOfClocks[whichClock]>0? stateOfClocks[whichClock]:(stateOfClocks[whichClock]+12);
		stateOfClocks[whichClock] = stateOfClocks[whichClock]==0? 12: stateOfClocks[whichClock];
	}
	public static boolean hasAllClocksBeenSet() {
		for(int i=0; i<stateOfClocks.length; i++)
			if(stateOfClocks[i] != 12)
				return false;
		
		return true;
	}
}
