public class RiddlerGame {
    public static void main(String[] args) {
        int numParticipants = 5;
        Riddler riddler = new Riddler();
        Participant[] participants = new Participant[numParticipants];

        for (int i = 0; i < numParticipants; i++) {
            participants[i] = new Participant(riddler);
            participants[i].joinGame();
            participants[i].start();
        }

        for (int i = 0; i < numParticipants; i++) {
            try {
                participants[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game over. All participants guess correctly.");
    }
}
