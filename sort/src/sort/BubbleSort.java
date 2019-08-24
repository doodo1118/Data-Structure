package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {7,5,2,1,3,4};
		bubbleSort(array);
		
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public static void bubbleSort(int[] array) {
		int tmp;
		
		for(int i=1; i<array.length; i++) {
			for(int j=0; j<array.length-i; j++) {
				
				if(array[j] > array[j+1]) {
					tmp = array[j+1];
					array[j+1] = array[j];
					array[j] = tmp;
				}
				
			}
		}
		
	}
}
