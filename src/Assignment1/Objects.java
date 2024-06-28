package Assignment1;
public class Objects {

	public static void main(String[] args) {
		PartyDO user1 = new PartyDO();
		PartyDO user2 = new PartyDO();
		 
		registerUser  r=new registerUser();
		 
		r.registerNewUser(user1);
		r.registerNewUser(user2);
	}

}
