package sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] array = {3,8,2,0,9,5,4,6};
		insertionSort(array);
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]);
		}
	}
	public static void insertionSort(int[] array) {
		int tmp, j;
		
		for(int i=1; i<array.length; i++) {
			tmp = array[i];
			j = i-1;
				
			while(j>=0 && array[j]>tmp) {
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = tmp;
		}
	}
}
