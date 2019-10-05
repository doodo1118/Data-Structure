import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[][] graph = new int[N][N];
		boolean[][] result = new boolean[N][N];
		
		//initiate graph
		for(int i=0; i<N; i++) {
			String[] s = bf.readLine().split(" ");
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i=0; i<N; i++)
			for(int j=0; j<i; j++) {
				
			}
		
		
		
	}
}
