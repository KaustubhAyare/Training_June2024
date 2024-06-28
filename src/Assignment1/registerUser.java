package Assignment1;
import java.util.Scanner;
public class registerUser {
	public void registerNewUser(PartyDO userObj)
	{
		Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter partyTypeCd: ");		
		 userObj.partyTypeCd= sc.nextLine();
		 
		 System.out.println("Enter partySeq: ");	
		 userObj.partySeq = sc.nextLine();
		 
		 System.out.println("Enter title: ");	
		 userObj.title = sc.nextLine();
		 
		 System.out.println("Enter First Name: ");	
		 userObj.firstName = sc.nextLine();
		 
		 System.out.println("Enter Last Name: ");	
		 userObj.lastName = sc.nextLine();
		 
		 System.out.println("Enter GenderCd: ");	
		 userObj.genderCd = sc.nextLine();
		 
		 System.out.println("Enter Age: ");	
		 userObj.age = sc.nextInt();
		 
		 System.out.println("User details are : " + "\n" + userObj.partyTypeCd + "\n" + userObj.partySeq+"\n"+userObj.title+"\n"+userObj.firstName+"\n"+userObj.lastName+"\n"+userObj.genderCd+"\n"+userObj.age);

	}
	}

