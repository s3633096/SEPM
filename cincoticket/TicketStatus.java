public enum TicketStatus {
    OPEN("Open"),
    CLOSED_RESOLVED("Closed and Resolved"),
    CLOSED_UNRESOLVED("Closed and Unresolved");
    
	
	private String string;
	
	private TicketStatus(String name) {
		string = name;
	}
	
    @Override
    public String toString() {
    	return string;
    }
    
}
