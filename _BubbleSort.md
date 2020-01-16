public class IA_BubbleSort{

	public void bubbleSort(int[] arr){
		int n = arr.length;
		for (int i = n;i > 0;i--){
			for (int j = 0; j < i - 1; j++){
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	
	}
	
	static void printArray(int[] arr){
		int n = arr.length;
		
		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] arr = {5,1,4,2,8,9};
		IA_BubbleSort ob = new IA_BubbleSort();
		System.out.println("Given the Array:");
		printArray(arr);
		ob.bubbleSort(arr);
		System.out.println("Sorted Array is");
		printArray(arr);
		
	}





}