package Assignment2;

public class termHealthInsuranceDO extends basePolicyDO 
{
	String policySeq;
	Double premiumAmt;
	Double sumAssured;
	Double healthCover;
	
	public termHealthInsuranceDO(String partySeq, String policySeq,
			Double premiumAmt, Double sumAssured, Double healthCover) {
		super(partySeq);
		this.policySeq = policySeq;
		this.premiumAmt = premiumCalculationDO.premiumCalTermHealthIns(sumAssured);
		this.sumAssured = sumAssured;
		this.healthCover = healthCover;
	}
	public String getPolicySeq() {
		return policySeq;
	}
	public void setPolicySeq(String policySeq) {
		this.policySeq = policySeq;
	}
	public Double getPremiumAmt() {
		return premiumAmt;
	}
	public void setPremiumAmt(Double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}
	public Double getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(Double sumAssured) {
		this.sumAssured = sumAssured;
	}
	public Double getHealthCover() {
		return healthCover;
	}
	public void setHealthCover(Double healthCover) {
		this.healthCover = healthCover;
	}
	@Override
	public String toString() {
        return "termHealthInsuranceDO [policySeq=" + policySeq + ", premiumAmt=" + premiumAmt + ", sumAssured=" + sumAssured + ", healthCover=" + healthCover + "]";
    }	
}
