import java.util.Random;

public class Riddler {
    private int number;

    public NumberMemento generateNumber() {
        number = new Random().nextInt(1000);
        return new NumberMemento(number);
    }

    public boolean checkGuess(NumberMemento guess) {
        return guess.getNumber() == number;
    }
}
