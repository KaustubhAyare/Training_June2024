package Assignment4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartyDO {
    public String partySeq;
    public String partyTypeCd;
    public String title;
    public String firstName;
    public String lastName;
    public Date birthDate;
    public int age;
    public String genderCd;
    public List<PartyAddressDO> partyAddresses;
    public List<PartyContactDO> partyContacts;
    public String toString()
	{
		return "Party Type CD: "+getPartyTypeCd()+"Party Seq:"+getPartySeq()+"Title: "+getTitle()+"First Name: "+getFirstName()+"BirthDate: "+getBirthDate()+"Gender: "+getGenderCd()+"Age: "+ getAge();
	}
    public PartyDO() {
        this.partyAddresses = new ArrayList<PartyAddressDO>();
        this.partyContacts = new ArrayList<PartyContactDO>();
    }
    public String getPartySeq() {
        return partySeq;
    }

    public void setPartySeq(String partySeq) {
        this.partySeq = partySeq;
    }

    public String getPartyTypeCd() {
        return partyTypeCd;
    }

    public void setPartyTypeCd(String partyTypeCd) {
        this.partyTypeCd = partyTypeCd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(String genderCd) {
        this.genderCd = genderCd;
    }

    public List<PartyAddressDO> getPartyAddressDOs() {
        return partyAddresses;
    }

    public List<PartyContactDO> getPartyContactDOs() {
        return partyContacts;
    }

    public void addPartyAddress(PartyAddressDO address) {
        this.partyAddresses.add(address);
    }

    public void addPartyContact(PartyContactDO contact) {
        this.partyContacts.add(contact);
    }
}
