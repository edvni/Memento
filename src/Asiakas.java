import java.util.Random;

// Pelaaja joka osallistuu peliin
class Asiakas implements Runnable {
    private Arvuuttaja arvuuttaja;
    private Memento memento;
    private int arvaus;

    public Asiakas(Arvuuttaja arvuuttaja) {
        this.arvuuttaja = arvuuttaja;
    }

    @Override
    public void run() {
        memento = arvuuttaja.liityPeliin(); // liity peliin ja saa memento-olio
        while (!arvuuttaja.tarkistaArvaus(memento, arvaus)) {
            arvaus = new Random().nextInt(100); // arvaa satunnainen numero
            System.out.println("Thread " + Thread.currentThread().getId() + ": Arvaus: " + arvaus);
        }
        System.out.println(Thread.currentThread().getId() + ": Voitin! Numeroni oli " + memento.getSecretNumber());
    }
}