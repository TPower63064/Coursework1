package Model;

public class Quiz {
    private int quizID;
    private int quizNumber;

    public Quiz(int quizID, int quizNumber) {
        this.quizID = quizID;
        this.quizNumber = quizNumber;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getQuizNumber() {
        return quizNumber;
    }

    public void setQuizNumber(int quizNumber) {
        this.quizNumber = quizNumber;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                ", quizNumber=" + quizNumber +
                '}';
    }
}
