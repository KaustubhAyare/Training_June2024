package InstanceofExample;

public class loanCalculation 
{
	void EMIamount(RBI childbank)
	{
		if(childbank instanceof SBI)
		{
			System.out.println("hi its SBI with "+childbank.interest+"% interest");
		}
		else if(childbank instanceof BOI)
		{
			System.out.println("hi its BOI with "+((RBI) childbank).getInterest()+"% interest");
		}		
	}
}
