public class Participant extends Thread {
    private Riddler riddler;
    private NumberMemento guess;

    public Participant(Riddler riddler) {
        this.riddler = riddler;
    }

    public void joinGame() {
        guess = riddler.generateNumber();
    }

    @Override
    public void run() {
        while (!riddler.checkGuess(guess)) {
            System.out.println(Thread.currentThread().getName() + " guessed: " + guess.getNumber());
            guess = riddler.generateNumber();
        }
        System.out.println(Thread.currentThread().getName() + " guess correctly: "
        + guess.getNumber());
    }

}
