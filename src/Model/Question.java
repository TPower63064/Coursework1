package Model;

public class Question {
    private int questionID;
    private String question;
    private int quizID;
    private int studentID;

    public Question(int questionID, String question, int quizID, int studentID) {
        this.questionID = questionID;
        this.question = question;
        this.quizID = quizID;
        this.studentID = studentID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Question{" +
                ", question='" + question + '\'' +
                ", studentID=" + studentID +
                '}';
    }
}
