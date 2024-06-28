package InstanceofExample;

public class loanEMI {

	public static void main(String[] args) {
		double loanAmount=500000;
		loanCalculation loan1=new loanCalculation();
		
		RBI loanbank=new SBI();
		loan1.EMIamount(loanbank);
		
		loanbank=new BOI();
		loan1.EMIamount(loanbank);
		

	}

}
