package Jarfile;

import com.c2lbiz.symbiosys.systemcommon.util.DateUtil;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class dobAge {

	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        
		        System.out.println("Enter your date of birth (yyyy-MM-dd): ");
		        String dobInput = scanner.nextLine();
		        
		        System.out.println("Enter age calculation basis (LASTBIRTHDAY, NEXTBIRTHDAY, NEARESTBIRTHDAY): ");
		        String ageCalculationBasis = scanner.nextLine();
		        
		        try {
		            
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            Date dob = sdf.parse(dobInput);
		            
		            
		            Date referenceDt = new Date();
		            
		           
		            int age = DateUtil.getAge(dob, ageCalculationBasis, referenceDt);
		            
		            
		            System.out.println("Calculated Age: " + age);
		            
		        } catch (Exception e) {
		            System.out.println("Error parsing dates or calculating age: " + e.getMessage());
		        } finally {
		            scanner.close();
		        }
		    }
		
	}
