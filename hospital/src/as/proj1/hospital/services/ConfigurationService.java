package as.proj1.hospital.services;

public class ConfigurationService {
    private int numberOfAdultPatients = 10;
    private int numberOfChildrenPatients = 10;
    private int numberOfSeats = 4;
    private int evaluationTime = 100;
    private int medicalTime = 100;
    private int paymentTime = 100;
    private int timeToMove = 100;

    public int getNumberOfAdultPatients() {
        return numberOfAdultPatients;
    }

    public void setNumberOfAdultPatients(int numberOfAdultPatients) {
        if (numberOfAdultPatients < 1 || numberOfAdultPatients > 50) {
            throw new IllegalArgumentException("Number of adults patients must be in interval [1,50]");
        }

        this.numberOfAdultPatients = numberOfAdultPatients;
    }

    public int getNumberOfChildrenPatients() {
        return numberOfChildrenPatients;
    }

    public void setNumberOfChildrenPatients(int numberOfChildrenPatients) {
        if (numberOfChildrenPatients < 1 || numberOfChildrenPatients > 50) {
            throw new IllegalArgumentException("Number of children patients must be in interval [1,50]");
        }

        this.numberOfChildrenPatients = numberOfChildrenPatients;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats != 2 && numberOfSeats != 4 && numberOfSeats != 6 && numberOfSeats != 8 && numberOfSeats != 10) {
            throw new IllegalArgumentException("Number of seats must be 2, 4, 6, 8 or 10");
        }

        this.numberOfSeats = numberOfSeats;
    }

    public int getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(int evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public int getMedicalTime() {
        return medicalTime;
    }

    public void setMedicalTime(int medicalTime) {
        this.medicalTime = medicalTime;
    }

    public int getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(int paymentTime) {
        this.paymentTime = paymentTime;
    }

    public int getTimeToMove() {
        return timeToMove;
    }

    public void setTimeToMove(int timeToMove) {
        this.timeToMove = timeToMove;
    }
}
