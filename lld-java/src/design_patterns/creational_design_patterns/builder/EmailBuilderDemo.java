package design_patterns.creational_design_patterns.builder;

public class EmailBuilderDemo {
    public static void main(String[] args) {
        // Example 1: Minimal email (only required fields)
        EmailMessage minimalEmail = new EmailMessage.Builder("me@example.com")
                .addTo("friend@example.com")
                .addSubject("Hello!")
                .addBody("Just saying hi")
                .build();
        minimalEmail.send();

        // Example 2: Full email with CC, BCC, attachments, high priority
        EmailMessage fullEmail = new EmailMessage.Builder("admin@company.com")
                .addTo("user1@company.com")
                .addTo("user2@company.com")
                .addCc("manager@company.com")
                .addBcc("ceo@company.com")
                .addSubject("System Maintenance Tonight")
                .addBody("Servers will be down from 12AM to 2AM for maintenance.")
                .addAttachment("maintenance-plan.pdf")
                .addAttachment("faq.docx")
                .highPriority(true)
                .build();
        fullEmail.send();

        // Example 3: Invalid email (missing recipient)
        try {
            EmailMessage invalidEmail = new EmailMessage.Builder("sender@example.com")
                    .addSubject("No recipient")
                    .build();
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating email: " + e.getMessage());
        }
    }
}
