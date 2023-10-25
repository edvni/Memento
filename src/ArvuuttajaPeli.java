public class ArvuuttajaPeli {
    public static void main(String[] args) {
        int asiakasMaara = 5;
        Arvuuttaja arvuuttaja = new Arvuuttaja(asiakasMaara);

        for (int i = 0; i < asiakasMaara; i++) {
            Thread asiakasThread = new Thread(new Asiakas(arvuuttaja)); // luo ja käynnistä pelaajat (säikeet)
            asiakasThread.start();
        }
    }
}