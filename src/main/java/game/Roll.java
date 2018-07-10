package game;

public class Roll {

    private final int score;

    public Roll(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roll roll = (Roll) o;

        return score == roll.score;
    }

    @Override
    public int hashCode() {
        return score;
    }
}
