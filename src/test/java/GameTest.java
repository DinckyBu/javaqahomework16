import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenWinPlayer1() {
        Player vasya = new Player(1, "Vasya", 124);
        Player alex = new Player(5, "Alex", 102);
        Game game = new Game();

        game.register(vasya);
        game.register(alex);

        int expected = 1;
        int actual = game.round("Vasya", "Alex");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenWinPlayer2() {
        Player vasya = new Player(1, "Vasya", 124);
        Player alex = new Player(5, "Alex", 132);
        Game game = new Game();

        game.register(vasya);
        game.register(alex);

        int expected = 2;
        int actual = game.round("Vasya", "Alex");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDrawGame() {
        Player vasya = new Player(1, "Vasya", 124);
        Player alex = new Player(5, "Alex", 124);
        Game game = new Game();

        game.register(vasya);
        game.register(alex);

        int expected = 0;
        int actual = game.round("Vasya", "Alex");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayer1IsNotRegister() {
        Player vasya = new Player(1, "Vasya", 124);
        Player max = new Player(5, "Max", 102);
        Game game = new Game();

        game.register(max);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Vasya", "Max"));
    }

    @Test
    public void testPlayer2IsNotRegister() {
        Player vasya = new Player(1, "Vasya", 124);
        Player max = new Player(5, "Max", 102);
        Game game = new Game();

        game.register(vasya);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Vasya", "Max"));
    }
}
