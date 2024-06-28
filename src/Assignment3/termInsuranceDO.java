package Assignment3;

public class termInsuranceDO extends basePolicyDO
 {
	String policySeq;
	Double premiumAmt;
	Double sumAssured;
	
	public termInsuranceDO(String partySeq, String policySeq,
			Double premiumAmt, Double sumAssured) {
		super(partySeq);
		this.policySeq = policySeq;
		this.premiumAmt = premiumAmt;
		this.sumAssured = sumAssured;
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
	

	@Override
	public String toString() {
		return "termInsuranceDO [policySeq=" + policySeq + ", premiumAmt="
				+ premiumAmt + ", sumAssured=" + sumAssured + "]";
	}
	

}
