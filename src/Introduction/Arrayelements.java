package Introduction;
import java.util.Scanner;
public class Arrayelements {

	public static void main(String[] args) {
		Scanner myArr = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
        int arr_size = 0;
        if (myArr.hasNextInt()) {
            arr_size = myArr.nextInt();
	}
	
        int[] arr = new int[arr_size];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < arr_size; i++) {
            if (myArr.hasNextInt()) {
                arr[i] = myArr.nextInt();
            }
        }
                System.out.println("The elements of the array are: ");
                    for (int i = 0; i < arr_size; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    myArr.close();
	}
                   
}
