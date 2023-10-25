import java.util.Random;
import java.util.concurrent.CountDownLatch;

class Asiakas implements Runnable {
    private Arvuuttaja arvuuttaja;
    private int arvaus;
    private CountDownLatch latch;

    public Asiakas(Arvuuttaja arvuuttaja, CountDownLatch latch) {
        this.arvuuttaja = arvuuttaja;
        this.latch = latch;
    }

    @Override
    public void run() {
        Memento memento = arvuuttaja.liityPeliin();
        System.out.println("For thread " + Thread.currentThread().getId() + ": Arvuuttaja arpoo numeron: " + memento.getNumber());
        while (!arvuuttaja.tarkistaArvaus(memento, arvaus)) {
            arvaus = new Random().nextInt(100);
            System.out.println("Thread " + Thread.currentThread().getId() + ": Arvaus: " + arvaus);
        }
        System.out.println("Thread " + Thread.currentThread().getId() + ": Voitin! Numeroni oli " + memento.getNumber());
        latch.countDown();
    }
}