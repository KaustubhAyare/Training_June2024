package Introduction;
import java.util.Scanner; 
class Add
{
	public int add(int num1,int num2)
	{
		int sum = num1 + num2;
		return sum;
	}
		
}
public class Addusingfunc {
	

	public static void main(String[] args) 
	{
		Scanner myNum = new Scanner(System.in);
		System.out.println("Enter the first number:");
		int num1 = myNum.nextInt();
		System.out.println("Enter the second number:");
		int num2 = myNum.nextInt();
		Add myObj = new Add();
		int sum = myObj.add(num1,num2);
		System.out.println(sum);
	}
	}

