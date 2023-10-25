// Memento-luokka tallentaa pelaajan tilan, eli salaisen numeron
class Memento {
    private final int secretNumber;

    public Memento(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getSecretNumber() {
        return secretNumber;
    }
}