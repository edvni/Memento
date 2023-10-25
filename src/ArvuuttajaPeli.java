import java.util.concurrent.CountDownLatch;

public class ArvuuttajaPeli {
    public static void main(String[] args) {
        Arvuuttaja arvuuttaja = new Arvuuttaja();
        int asiakasMaara = 5;

        CountDownLatch latch = new CountDownLatch(asiakasMaara);

        for (int i = 0; i < asiakasMaara; i++) {
            Thread asiakasThread = new Thread(new Asiakas(arvuuttaja, latch));
            asiakasThread.start();
        }

        // Odota, kunnes peli päättyy
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Peli päättyi!");
    }
}