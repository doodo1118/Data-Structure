import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj1260 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] NMV= bf.readLine().split(" ");
		//num of nodes 
		int N = Integer.parseInt(NMV[0]);
		//num of edges
		int M = Integer.parseInt(NMV[1]);
		//starting node
		int V = Integer.parseInt(NMV[2]);
		
		boolean[][] graph = new boolean[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(graph[i], false);	
		}
		
		boolean[] visited = new boolean[N];
		Arrays.fill(visited, false);
		
		//fill matrix 
		for(int i=0; i<M; i++) {
			String[] v = bf.readLine().split(" ");
			int vertexFrom = Integer.parseInt(v[0])-1;
			int vertexTo = Integer.parseInt(v[1])-1;
			graph[vertexFrom][vertexTo] = true;
			graph[vertexTo][vertexFrom] = true;
		}
		
		//dfs
		dfs(graph, visited, V-1);
		
		System.out.println();
		//reset
		Arrays.fill(visited, false);
		
		//bfs
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] discovered = new boolean[N];
		
		queue.add(new Integer(V));
		discovered[V-1] = true;
		
		while(!queue.isEmpty()) {
			int here = queue.poll();
			
			System.out.print(here + " ");
			for(int i=0; i<N; i++) {
				if(graph[here-1][i] && !discovered[i]) {
					queue.add(new Integer(i+1));	
					discovered[i] = true;
				}
			}
		}
		
	}
	
		
	public static void dfs(boolean[][] graph, boolean[] visited, int V) {
		int N = graph[0].length;
		
		System.out.print(V+1 + " ");
		visited[V] = true;
		
		for(int i=0; i<N; i++) {
			if(graph[V][i] && !visited[i]) {
				dfs(graph, visited, i);
			}
		}
		
	}
	
}
