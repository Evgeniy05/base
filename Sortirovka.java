import java.util.Arrays;

public class Sortirovka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int []a={5,6,1,3,4,5,44,4,4};
		sort(a);
		System.out.println(Arrays.toString(a));
	}

public static void sort (int[] arr) {
	  	for (int min=0;min<arr.length-1;min++) {
	  		int least = min;
	  		for (int j=min+1;j<arr.length;j++) {
	  		    if(arr[j] < arr[least]) {
	  				least = j;
	  			}
	  		}
	 		int tmp = arr[min];
	 		arr[min] = arr[least];
	 		arr[least] = tmp;
	 	}
	 }
}