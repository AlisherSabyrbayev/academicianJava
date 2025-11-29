package leavetracker;

public class SickLeaveRequest extends LeaveRequest {
    private final boolean medicalCertificateProvided;

    public SickLeaveRequest(int requestId, Employee employee, String startDate, String endDate, String reason, boolean certificate) {
        super(requestId, employee, startDate, endDate, reason);
        this.medicalCertificateProvided = certificate;
    }

    public boolean isMedicalCertificateProvided() {
        return medicalCertificateProvided;
    }
}
