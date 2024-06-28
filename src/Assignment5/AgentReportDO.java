package Assignment5;

public class AgentReportDO {
    private String agentId;
    private int policyCount;
    private double totalSumAssured;

    public AgentReportDO(String agentId, int policyCount, double totalSumAssured) {
        this.agentId = agentId;
        this.policyCount = policyCount;
        this.totalSumAssured = totalSumAssured;
    }

    public String getAgentId() {
        return agentId;
    }

    public int getPolicyCount() {
        return policyCount;
    }

    public void incrementPolicyCount() {
        this.policyCount++;
    }

    public double getTotalSumAssured() {
        return totalSumAssured;
    }

    public void addToTotalSumAssured(double sumAssured) {
        this.totalSumAssured += sumAssured;
    }
}
