package game;

import game.Frame;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void addScore_GivenNineAnd0_ShouldHave1RollAndBeFinished(){
        Frame frame = new Frame();

        frame.addScore(9);
        frame.addScore(0);

        assertThat(frame.getRolls().size(), equalTo(2));
        assertThat(frame.isFinished(), is(true));
    }

    @Test
    public void equals_GivenFrameWith9AndOtherFrameWith9_ShouldBeEquals(){
        Frame frame = new Frame();
        frame.addScore(9);
        frame.addScore(0);

        Frame frame2 = new Frame();
        frame2.addScore(9);
        frame2.addScore(0);

        assertThat(frame, equalTo(frame2));
    }

    @Test
    public void isSpare_GivenRolls9And1_ShouldBeSpare(){
        Frame frame = new Frame();
        frame.addScore(9);
        frame.addScore(1);

        assertThat(frame.isSpare(), is(true));
    }

    @Test
    public void isSpare_GivenRolls8And1_ShouldNotBeSpare(){
        Frame frame = new Frame();
        frame.addScore(8);
        frame.addScore(1);

        assertThat(frame.isSpare(), is(false));
    }

    @Test
    public void isStrike_GivenRoll10And0_ShouldBeStrike(){
        Frame frame = new Frame();
        frame.addScore(10);
        frame.addScore(0);

        assertThat(frame.isStrike(), is(true));
    }

}
