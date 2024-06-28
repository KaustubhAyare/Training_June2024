package Introduction;
import java.util.Scanner;
public class Evenodd {

	public static void main(String[] args) 
	{
		Scanner myNum = new Scanner(System.in);
		System.out.println("Enter a number to check even or odd");
		int num = myNum.nextInt();
		if(num % 2 == 0)
		{
			System.out.println("Number is even");
		}
		else{
			System.out.println("Number is odd");
		}
	}
}
