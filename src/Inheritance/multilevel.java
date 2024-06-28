package Inheritance;

public class multilevel 
{
	public static void main(String[] args) 
	{
		employeeData employee = new employeeData();
		employee.empname();
		employee.empaddress();
		employee.empposition();		
	}
}	
	class employeename
	{
		void empname(){
			System.out.println("Kaustubh Ayare");
		}
	}
	class employeeaddress extends employeename
	{
		void empaddress(){
			System.out.println("Bhayander");
		}
	}
	
	class employeeData extends employeeaddress
	{
		void empposition()
		{
			System.out.println("Trainee Software Developer");
		}
	}
	