import game.Board;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import game.INotifier;
import org.junit.Test;
import org.mockito.Mockito;

public class Scenarios {

    public void Given10RollsAt9_WhenGameIsFinished_NumberOfFramesMustBe10(){

    }

    @Test
    public void Given10RollsAt9_WhenTotalIsCalculated_TotalMustBe90(){
        /* INotifier notifier = () -> {

        };*/

        INotifier notifier = Mockito.mock(INotifier.class);

        Mockito.doNothing().when(notifier).notifyBoard();

        Board board = new Board(notifier);

        for(int i = 1; i <= 20; i++){
            board.addScore(i % 2 == 0 ? 0 : 9);
        }

        Mockito.verify(notifier, Mockito.times(20)).notifyBoard();

        assertThat(board.getTotalScore(), equalTo(90));
    }

    /*@Test
    public void Given10RollsAt9_WhenTotalIsCalculated_TotalMustBe90(){
        Board board = Mockito.spy(new Board());

        Mockito.doNothing().when(board).notifyBoard();

        for(int i = 1; i <= 20; i++){
            board.addScore(i % 2 == 0 ? 0 : 9);
        }

        Mockito.verify(board, Mockito.times(20)).notifyBoard();

        assertThat(board.getTotalScore(), equalTo(90));
    }*/

    /*@Test
    public void Given1SpareAnd9RollsAt9_WhenTotalIsCalculated_TotalMustBe100(){
        Board board = new Board();

        board.addScore(9);
        board.addScore(1);

        for(int i = 3; i <= 20; i++) {
            board.addScore(i%2 == 0 ? 0 : 9);
        }

        assertThat(board.getTotalScore(), is(100));
    }

    @Test
    public void Given1StrikeAnd5And4And8At9_WhenTotalIsCalculated_TotalMustBe100(){
        Board board = new Board();

        board.addScore(10);
        board.addScore(0);
        board.addScore(5);
        board.addScore(4);
        for(int i = 5; i <= 20; i++) {
            board.addScore(i%2 == 0 ? 0 : 9);
        }

        assertThat(board.getTotalScore(), is(100));
    }**/


}
