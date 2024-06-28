package Assignment3;

public class PartyAddressDO {
    public String addressSeq;
    public String partySeq;
    public String addressType;
    public String countryCd;
    public String stateCd;
    public String addressDetails;
    public String pinCode;
    public String primaryAddress;
    public String toString()
	{
		return "Party Address Seq: "+getAddressSeq()+" Party Seq:"+getPartySeq()+" Address Type: "+getAddressType()+" Country Code: "+getCountryCd()+" State Code: "+getStateCd()+" Address Details: "+getAddressDetails()+" Pincode: "+ getPinCode()+ " Primary Address: "+getPrimaryAddress()+"\n";
	}
    public PartyAddressDO(String addressSeq, String addressType, String countryCd, String stateCd, String addressDetails, String pinCode, String primaryAddress) {
        this.addressSeq = addressSeq;
        this.addressType = addressType;
        this.countryCd = countryCd;
        this.stateCd = stateCd;
        this.addressDetails = addressDetails;
        this.pinCode = pinCode;
        this.primaryAddress = primaryAddress;
    }
   
    public PartyAddressDO(String addressSeq) {
        this.addressSeq = addressSeq;
    }


	public String getAddressSeq() {
        return addressSeq;
    }

    public void setAddressSeq(String addressSeq) {
        this.addressSeq = addressSeq;
    }

    public String getPartySeq() {
        return partySeq;
    }

    public void setPartySeq(String partySeq) {
        this.partySeq = partySeq;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public String getStateCd() {
        return stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
}
