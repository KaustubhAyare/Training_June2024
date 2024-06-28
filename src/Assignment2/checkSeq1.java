package Assignment2;

public class checkSeq1 {

	public static void main(String[] args)
	{
		System.out.println("inside checkSeq1:"+SequenceGenerator.getInstance().currentPartySequence);
		SequenceGenerator.getInstance().currentPartySequence++;
		System.out.println("Address inside checkSeq1:"+SequenceGenerator.getInstance().currentAddressSequence);
		
		System.out.println("checkSeq2 from another file : "+checkSeq2.getSeq2().currentPartySequence);
		System.out.println("Address inside checkSeq2 from another file :"+SequenceGenerator.getInstance().currentAddressSequence);

	}

}
