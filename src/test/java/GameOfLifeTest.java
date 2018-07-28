import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {

    @Test
    public void setGetAlive() {
        GameOfLife game = new GameOfLife();
        game.set(0,0, Cell.ALIVE);
        assertEquals(Cell.ALIVE, game.get(0,0));
    }

    @Test
    public void setGetDead() {
        GameOfLife game = new GameOfLife();
        game.set(0,0, Cell.DEAD);
        assertEquals(Cell.DEAD, game.get(0,0));
    }

    @Test
    public void setXAndY() {
        GameOfLife game = new GameOfLife();
        game.set(0,0, Cell.ALIVE);
        game.set(-1,-1, Cell.DEAD);
        game.set(35,29, Cell.ALIVE);
        game.set(291848234,96796453, Cell.DEAD);
        assertEquals(Cell.ALIVE, game.get(0,0));
        assertEquals(Cell.DEAD, game.get(-1,-1));
        assertEquals(Cell.ALIVE, game.get(35,29));
        assertEquals(Cell.DEAD, game.get(291848234,96796453));
    }

    @Test
    public void overCrowdDead() {
        GameOfLife game = new GameOfLife();
        game.set(1,1, Cell.ALIVE);
        game.set(0,0, Cell.ALIVE);
        game.set(0,1, Cell.ALIVE);
        game.set(0,2, Cell.ALIVE);
        game.set(1,0, Cell.ALIVE);
        game.set(1,2,  Cell.DEAD);
        game.set(2,0,  Cell.DEAD);
        game.set(2,1,  Cell.DEAD);
        game.set(2,2,  Cell.DEAD);
        game.tick();
        assertEquals(Cell.DEAD, game.get(1,1));
    }
    @Test
    public void friendDeadAlive() {
        GameOfLife game = new GameOfLife();
        game.set(1,1, Cell.DEAD);
        game.set(0,0, Cell.ALIVE);
        game.set(0,1, Cell.ALIVE);
        game.set(0,2, Cell.DEAD);
        game.set(1,0, Cell.ALIVE);
        game.set(1,2,  Cell.DEAD);
        game.set(2,0,  Cell.DEAD);
        game.set(2,1,  Cell.DEAD);
        game.set(2,2,  Cell.DEAD);
        game.tick();
        assertEquals(Cell.ALIVE, game.get(1,1));

    }
    @Test
    public void noFriendDead() {
        GameOfLife game = new GameOfLife();
        game.set(1,1, Cell.ALIVE);
        game.set(0,0, Cell.DEAD);
        game.set(0,1, Cell.DEAD);
        game.set(0,2, Cell.DEAD);
        game.set(1,0, Cell.ALIVE);
        game.set(1,2,  Cell.DEAD);
        game.set(2,0,  Cell.DEAD);
        game.set(2,1,  Cell.DEAD);
        game.set(2,2,  Cell.DEAD);
        game.tick();
        assertEquals(Cell.DEAD, game.get(1,1));
    }
    @Test
    public void stayingAlive() {
        GameOfLife game = new GameOfLife();
        game.set(1,1, Cell.ALIVE);
        game.set(0,0, Cell.DEAD);
        game.set(0,1, Cell.DEAD);
        game.set(0,2, Cell.ALIVE);
        game.set(1,0, Cell.ALIVE);
        game.set(1,2,  Cell.DEAD);
        game.set(2,0,  Cell.DEAD);
        game.set(2,1,  Cell.DEAD);
        game.set(2,2,  Cell.DEAD);
        game.tick();
        assertEquals(Cell.ALIVE, game.get(1,1));
    }
    @Test
    public void string() {
        GameOfLife game = new GameOfLife();
        game.set(0,0, Cell.ALIVE);
        assertEquals("X", game.toString());
    }
    @Test
    public void fullString() {
        GameOfLife game = new GameOfLife();
        game.set(0,0, Cell.ALIVE);
        game.set(0,1, Cell.ALIVE);
        game.set(0,2, Cell.DEAD);
        game.set(1,0, Cell.ALIVE);
        game.set(1,1, Cell.ALIVE);
        game.set(1,2,  Cell.ALIVE);
        game.set(2,0,  Cell.DEAD);
        game.set(2,1,  Cell.ALIVE);
        game.set(2,2,  Cell.ALIVE);
        assertEquals("XX \nXXX\n XX\n", game.toString());
    }
}
