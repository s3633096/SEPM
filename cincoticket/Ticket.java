public class Ticket {
    private String description;
    private Integer severity;
    private String ownerEmail;

    public Ticket(String description, Integer severity, String ownerEmail) {
        this.description = description;
        this.severity = severity;
        this.ownerEmail = ownerEmail;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getSeverity() {
        return this.severity;
    }

    public String getOwnerEmail() {
        return this.ownerEmail;
    }
}
