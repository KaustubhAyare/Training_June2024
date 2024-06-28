package Debugging;

public class Add2numdebug {

	public static void main(String[] args) 
	{
		int num1=10,num2=20,addition;
		addition=sum(num1,num2);
		System.out.println("Sum is "+addition);
	}
	
	static int sum(int input1,int input2)
	{
		int solution=0;
		solution=input1+input2;
		inform();
		return solution;
	}
	static void inform()
	{
		System.out.println("Addition completed!!!!!!!!!!!!");
	}
}
