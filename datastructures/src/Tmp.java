import java.util.Scanner;

class Tmp{
	public static void tmp(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = s.nextInt();
		}
		

		int B = s.nextInt();
		int C = s.nextInt();
		
		int sum=0;
		int var;
		int var2;
		for(int i=0; i<N; i++) {
			if(arr[i] < B)
				arr[i]=0;
			else arr[i]-=B;
			var = arr[i]%C;
			var2 = arr[i]/C;
			sum += arr[i]%C==0? arr[i]/C : arr[i]/C+1;
		}
		
		System.out.println(sum);
		
	}
}