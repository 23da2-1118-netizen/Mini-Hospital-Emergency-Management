package hospital;

public class TreatmentRecord {
    private int treatmentId;
    private String patientName;
    private String treatmentStatus;
    private String treatmentSummary;

    public TreatmentRecord(int treatmentId, String patientName, String treatmentStatus, String treatmentSummary) {
        this.treatmentId = treatmentId;
        this.patientName = patientName;
        this.treatmentStatus = treatmentStatus;
        this.treatmentSummary = treatmentSummary;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentStatus() {
        return treatmentStatus;
    }

    public String getTreatmentSummary() {
        return treatmentSummary;
    }

    @Override
    public String toString() {
        return "TreatmentRecord{" +
                "treatmentId=" + treatmentId +
                ", patientName='" + patientName + '\'' +
                ", treatmentStatus='" + treatmentStatus + '\'' +
                ", treatmentSummary='" + treatmentSummary + '\'' +
                '}';
    }
}
