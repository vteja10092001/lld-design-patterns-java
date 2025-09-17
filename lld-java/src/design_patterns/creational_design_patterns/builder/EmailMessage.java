package design_patterns.creational_design_patterns.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class EmailMessage {
    private final String from;
    private final List<String> to;
    private final List<String> cc;
    private final List<String> bcc;
    private final String subject;
    private final String body;
    private final List<String> attachments;
    private final boolean highPriority;

    private EmailMessage(Builder builder) {
        if (builder.from == null || builder.from.isBlank()) {
            throw new IllegalArgumentException("Sender from address is required.");
        }
        if (builder.to.isEmpty()) {
            throw new IllegalArgumentException("At least one receiver address is required.");
        }

        this.from = builder.from;
        this.to = builder.to;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.subject = builder.subject;
        this.body = builder.body;
        this.attachments = builder.attachments;
        this.highPriority = builder.highPriority;
    }

    public void send() {
        System.out.println("Sending Email...");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "EmailMessage{", "}")
                .add("from='" + from + "'")
                .add("to=" + to)
                .add("cc=" + cc)
                .add("bcc=" + bcc)
                .add("subject='" + subject + "'")
                .add("body='" + (body != null ? body : "") + "'")
                .add("attachments=" + attachments)
                .add("highPriority=" + highPriority)
                .toString();
    }

    // Nested class
    public static class Builder {
        private final String from;
        private final List<String> to = new ArrayList<>();
        private final List<String> cc = new ArrayList<>();
        private final List<String> bcc = new ArrayList<>();
        private String subject = "";
        private String body = "";
        private final List<String> attachments = new ArrayList<>();
        private boolean highPriority = false;

        public Builder(String from) {
            this.from = from;
        }

        public Builder addTo(String to) {
            this.to.add(to);
            return this;
        }

        public Builder addCc(String cc) {
            this.cc.add(cc);
            return this;
        }

        public Builder addBcc(String bcc) {
            this.bcc.add(bcc);
            return this;
        }

        public Builder addAttachment(String attachment) {
            this.attachments.add(attachment);
            return this;
        }

        public Builder addSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder addBody(String body) {
            this.body = body;
            return this;
        }

        public Builder highPriority(boolean highPriority) {
            this.highPriority = highPriority;
            return this;
        }

        public EmailMessage build() {
            return new EmailMessage(this);
        }
    }
}
