package Model;

public class Score {
    private int scoreID;
    private int quizID;
    private int score;

    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Score(int scoreID, int quizID, int score) {
        this.scoreID = scoreID;
        this.quizID = quizID;
        this.score = score;

    }

    @Override
    public String toString() {
        return "Score{" +
                ", score=" + score +
                '}';
    }
}
