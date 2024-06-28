package exceptionExample;

public class normalCode {
	{
		
	}

	public static void main(String[] args) 
	{
		try
		{
			int a=9,b=0;
			System.out.println(a/b);
			System.out.println("after exception causing line");	
		}
		catch(Exception e)
		{
		
		System.out.println("catch stsatement: "+e);
		}
		System.out.println("part after exception");
		
		try
		{
			int a[] = new int[4];
			System.out.println("Access third element: "+ a[5]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Exception thrown :"+e);
		}
		catch(ArithmeticException e)
		{
			System.out.println("catch stsatement: "+e);
		}
		catch(Exception e)
		{
			System.out.println("catch stsatement: "+e);
		}
		System.out.println("Everything fine");
	}
}
