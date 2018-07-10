package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Frame {

    private List<Roll> rolls;

    public Frame() {
        this.rolls = new ArrayList();
    }

    public boolean isFinished() {
        return rolls.size() == 2;
    }

    public boolean isSpare(){
        return (rolls.size() == 2 && getTotalScore() == 10 && rolls.get(0).getScore() != 10);
    }

    public boolean isStrike(){
        Optional<Roll> maybeRoll = rolls.stream().findFirst();

        return maybeRoll.isPresent() ? maybeRoll.get().getScore() == 10 : false;
    }

    public void addScore(int newScore) {
        rolls.add(new Roll(newScore));
    }

    public Integer getTotalScore(){
        Integer totalScore = 0;

        for(Roll currentRoll : rolls){
            totalScore += currentRoll.getScore();
        }

        return totalScore;
    }

    public Roll getRoll(int index){
        return index < rolls.size() ? rolls.get(index) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frame frame = (Frame) o;

        return rolls != null ? rolls.equals(frame.rolls) : frame.rolls == null;
    }

    @Override
    public int hashCode() {
        return rolls != null ? rolls.hashCode() : 0;
    }

    List<Roll> getRolls() {
        return rolls;
    }
}
