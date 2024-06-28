package Assignment5;

public class AgentDO {
    private String agentId;
    private String agentName;
    private String agentContactNumber;
    private String agentEmail;

   
    public AgentDO(String agentId, String agentName, String agentContactNumber, String agentEmail) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.agentContactNumber = agentContactNumber;
        this.agentEmail = agentEmail;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentContactNumber() {
        return agentContactNumber;
    }

    public void setAgentContactNumber(String agentContactNumber) {
        this.agentContactNumber = agentContactNumber;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    @Override
    public String toString() {
        return "Agent ID: " + agentId + ", Agent Name: " + agentName;
    }
}
