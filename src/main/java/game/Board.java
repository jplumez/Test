package game;

import dehors.BoardNotifier;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Frame> frames;

    private INotifier notifier;

    public Board(INotifier boardNotifier) {
        frames = new ArrayList<Frame>();

        frames.add(new Frame());

        notifier = boardNotifier;
    }

    public void addScore(int newScore) {
        Frame currentFrame = getCurrentFrame();

        if(currentFrame.isFinished()){
            currentFrame = new Frame();
            frames.add(currentFrame);
        }

        currentFrame.addScore(newScore);

        // Mockito : notifyBoard();

       notifier.notifyBoard();
    }

    /*public void notifyBoard(){
        BoardNotifier.notifyBoard();
    }*/

    private Frame getCurrentFrame(){
        return frames.get(frames.size()-1);
    }

    public Integer getTotalScore() {
        Integer totalScore = 0;

        for(int i = 0; i < frames.size(); i++){
            Frame currentFrame = frames.get(i);

            // Si c'est un spare, on prend la partie d'après et
            if(currentFrame.isSpare() || currentFrame.isStrike()){
                Frame nextFrame = i + 1 < frames.size() ? frames.get(i+1) : null;

                if(nextFrame != null){
                    totalScore += currentFrame.isSpare() ? nextFrame.getRoll(0).getScore() : nextFrame.getTotalScore();
                }
            }

            totalScore += currentFrame.getTotalScore();
        }

        return totalScore;

    }
}
