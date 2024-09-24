package io.gihub.jonasnascc.HealthClinic.entity.EnumTypes;

public enum ExamStatus {
    WAITING_SCHEDULE("waitingschedule"),
    SCHEDULED("scheduled"),
    CANCELED("canceled"),
    FINALIZED("finalized");

    private final String status;

    ExamStatus(String status) {this.status=status;}

    public String getStatus() {return this.status;}
}
