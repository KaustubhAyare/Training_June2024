package Inheritance;

public class singleLevel {

	public static void main(String[] args) {
		c2l employee = new c2l();
		System.out.println(employee.employeename);
	}
}	
	class employeeDetails
	{
		String employeename="Kaustubh Ayare";
	}
	class c2l extends employeeDetails
	{		
	}
	

