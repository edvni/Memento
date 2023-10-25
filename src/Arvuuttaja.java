import java.util.Random;

// Arvuuttaja huolehtii pelistä ja pelaajien liittymisestä
class Arvuuttaja {
    private int[] secretNumbers; // kaikkien salaiset numerot
    private int nextIndex; // seuraavan liittyvän pelaajan indeksi

    public Arvuuttaja(int playerCount) {
        secretNumbers = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            secretNumbers[i] = new Random().nextInt(100); // numero jokaiselle pelaajalle
        }
        nextIndex = 0; // aloita ensimmäisestä pelaajasta
    }

    // Pelaaja liittyy peliin ja saa memento-olion, jossa on hänen salainen numero
    public Memento liityPeliin() {
        if (nextIndex < secretNumbers.length) {
            int secretNumber = secretNumbers[nextIndex]; // pelaajan salainen numero
            nextIndex++;
            return new Memento(secretNumber);
        }
        return null; // Kaikki pelaajat ovat jo liittyneet peliin
    }

    // Onko pelaajan arvaus oikeien verrattuna hänen memento-olioonsa
    public boolean tarkistaArvaus(Memento memento, int arvaus) {
        return memento.getSecretNumber() == arvaus;
    }
}