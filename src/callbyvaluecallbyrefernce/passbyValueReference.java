package callbyvaluecallbyrefernce;

public class passbyValueReference {

	public static void main(String[] args) {
		PartyDOpbr client=new PartyDOpbr(1);
		System.out.println("before: "+client.getPartySeq());
		operation o=new operation();
		o.increment(client);
		System.out.println("after:" + client.getPartySeq());
		o.decrement(client.getPartySeq());
		System.out.println("after decrement call:"+ client.getPartySeq() );
	}
}
class operation
{
	void increment(PartyDOpbr obj)
	{
		obj.partySeq++;
	}
	void decrement(int partySeq)
	{
		partySeq--;
		System.out.println("inside decrement method:"+partySeq);
	}
}
