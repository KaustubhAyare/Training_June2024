package Assignment4;

public class AgentDO {
    public String agentId;
    public String agentName;
   
   
    public AgentDO(String agentId, String agentName) {
        this.agentId = agentId;
        this.agentName = agentName;
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

    @Override
    public String toString() {
        return "Agent ID: " + agentId + ", Agent Name: " + agentName;
    }
}
