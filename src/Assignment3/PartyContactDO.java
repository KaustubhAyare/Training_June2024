package Assignment3;

public class PartyContactDO {
    public String contactSeq;
    public String contactType;
    public String contactNum;
    public PartyContactDO(String contactSeq, String contactType, String contactNum) {
        this.contactSeq = contactSeq;
        this.contactType = contactType;
        this.contactNum = contactNum;
    }
    public String toString()
	{
		return "Party Contact Seq: "+getContactSeq()+" Contact Type: "+getContactType()+" Contact Number: "+getContactNum()+"\n";
	}
    public PartyContactDO(String contactSeq) {
        this.contactSeq = contactSeq;
    }

    
    public String getContactSeq() {
        return contactSeq;
    }

    public void setContactSeq(String contactSeq) {
        this.contactSeq = contactSeq;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getContactDetails() {
        return contactType + ": " + contactNum;
    }
}
