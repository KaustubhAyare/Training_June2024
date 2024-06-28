package Assignment2;

public class basePolicyDO implements termsAndConditionINTF
 {
	public String partySeq;
	
	public basePolicyDO(String partySeq) 
	{
		this.partySeq = partySeq;
	}
	public void disclaimerMessage()
	{
		// TODO Auto-generated method stub
		System.out.println("These are the terms and conditions for the policy");
	}
	public String getPartySeq() 
	{
		return partySeq;
	}
	public void setPartySeq(String partySeq) 
	{
		this.partySeq = partySeq;
	}
	@Override
	public String toString() {
		return "basePolicyDO [partySeq=" + partySeq + "]";
	}
	
	
}
