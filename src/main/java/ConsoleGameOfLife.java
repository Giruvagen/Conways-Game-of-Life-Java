import java.util.Random;

public class ConsoleGameOfLife {
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        GameOfLife game = new GameOfLife();

        for (int y = 0; y < 31; y++) {
            for (int x = 0 ; x < 31; x++) {
                Cell cell = random.nextBoolean() ? Cell.ALIVE : Cell.DEAD;
                game.set(x,y, cell);
            }
        }

        while(true) {
            System.out.println(game.toString());
            game.tick();
            Thread.sleep(100);
        }
    }
}
