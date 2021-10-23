import java.time.LocalDate;

public class Ticket {
    private String description;
    private Integer severity;
    private String createdByEmail;
    private LocalDate createdDate;
    private String ownerEmail;
    private LocalDate resolvedDate;
    private TicketStatus status;

    public Ticket(String description, Integer severity, String createdByEmail, String ownerEmail, LocalDate date) {
        this.description = description;
        this.severity = severity;
        this.createdByEmail = createdByEmail;
        this.ownerEmail = ownerEmail;
        this.createdDate = date;
        this.status = TicketStatus.OPEN;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getSeverity() {
        return this.severity;
    }

    public String getSeverityString() {
        if (this.severity == 1) {
            return "HIGH";
        }
        else if (this.severity == 2) {
            return "MEDIUM";
        }
        else {
            return "LOW";
        }
    }

    public String getCreatedByEmail() {
        return this.createdByEmail;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public String getOwnerEmail() {
        return this.ownerEmail;
    }

    public LocalDate getResolvedDate() {
        return this.resolvedDate;
    }

    public TicketStatus getStatus() {
        return this.status;
    }

    public void setStatus(TicketStatus status) {
        if (status == TicketStatus.CLOSED_RESOLVED || status == TicketStatus.CLOSED_UNRESOLVED) {
            this.resolvedDate = LocalDate.now();
        } else if (status == TicketStatus.OPEN) {
            this.resolvedDate = null;
        }

        this.status = status;
    }
}
