import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Arvuuttaja {
    private List<Memento> mementos = new ArrayList<>();

    public Memento liityPeliin() {
        // Arvotaan luku ja tallennetaan se Mementoon
        int secretNumber = new Random().nextInt(100);
        Memento memento = new Memento(secretNumber);
        mementos.add(memento);
        return memento;
    }

    public boolean tarkistaArvaus(Memento memento, int arvaus) {
        // Tarkistetaan arvaus Mementon avulla
        return memento.getNumber() == arvaus;
    }

    public boolean onkoPeliPaattynyt() {
        // Peli päättyy, kun kaikki ovat arvanneet oikein
        return mementos.stream().allMatch(m -> m.getNumber() == mementos.get(0).getNumber());
    }
}