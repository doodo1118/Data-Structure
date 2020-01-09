import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class algospot_PICNIC {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//T = testcase
		int T = Integer.parseInt( bf.readLine() );
		for(int i=0; i<T; i++) {
			String[] chunks = bf.readLine().split(" ");
			int numOfChildren = Integer.parseInt( chunks[0] );
			int numOfRelationInformation = Integer.parseInt( chunks[1] );
			
			boolean[][] relationMap = new boolean[numOfChildren][numOfChildren];
		
			String[] relationInformation = bf.readLine().split(" ");
			
			//initiate relationMap
			for(int j=0; 2*j<numOfRelationInformation; j++) {
				int child1 = Integer.parseInt( relationInformation[j] );
				int child2 = Integer.parseInt( relationInformation[j+1] );
				
				recordRelation(relationMap, child1, child2);
			}
			

			//CurrentState contains hasPartner and currentLocation
			Stack<CurrentState> stack = new Stack<CurrentState>();
			
			boolean[] hasPartner = new boolean[numOfChildren];
			stack.push(new CurrentState( Arrays.copyOf(hasPartner, numOfChildren), new int[] {0,0}));
			
			while( !stack.isEmpty() ) {
				CurrentState cs = stack.pop();
				
				for(int child1=cs.currentLocation[0]; child1<numOfChildren; child1++) {
					if ( cs.hasPartner[child1] ) continue;
					
					for(int child2=cs.currentLocation[1]; child2<numOfChildren; child2++) {
						if( theyAreFriends(relationMap, child1, child2) ) {
							
							//pair child1 and child2
							cs.hasPartner[child1] = true;
							cs.hasPartner[child2] = true;
							
							stack.push( new CurrentState(Arrays.copyOf(cs.hasPartner, numOfChildren), new int[] {child1, child2}) );
						}
					}
				}
			}
		}
	}
	public static void recordRelation(boolean[][] relationMap, int child1, int child2) {
		relationMap[child1][child2] = true;
		relationMap[child2][child1] = true;
	}
	public static boolean theyAreFriends(boolean[][] relationMap, int child1, int child2) {
		if(child1 == child2) return false;
		else if(relationMap[child1][child2]) return true;
		else return false;
	}
	
	static class CurrentState {
		boolean[] hasPartner;
		int[] currentLocation;
		
		CurrentState(boolean[] hasPartner2, int[] currentLocation) {
			this.hasPartner = hasPartner2;
			this.currentLocation = currentLocation;
		}
	}
	
}