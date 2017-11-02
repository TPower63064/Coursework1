package Model;

public class Feedback {
    private int feedbackID;
    private String feedback;
    private int studentID;

    public Feedback(int feedbackID, String feedback, int studentID) {
        this.feedbackID = feedbackID;
        this.feedback = feedback;
        this.studentID = studentID;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                ", feedback='" + feedback + '\'' +
                ", studentID=" + studentID +
                '}';
    }
}
