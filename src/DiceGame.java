import java.util.Random;

public class DiceGame extends Game {
    private int[] pisteet;
    Random rand;
    private boolean isEnd = false;
    private String voittaja = "";

    @Override
    void initializeGame() {
        pisteet = new int[playersCount];
        rand = new Random();
    }

    @Override
    void makePlay(int player) {
        int heitto = rand.nextInt(6) + 1;
        pisteet[player] += heitto;
        System.out.println("Pelaaja " + (player + 1) + " heitti " + heitto + ", pisteet: " + pisteet[player]);
        if (pisteet[player] >= 30) {
            voittaja = "Voittaja: Pelaaja " + (player + 1)  + ", pisteillä: " + pisteet[player];
            setEnd();
        }
    }

    @Override
    boolean endOfGame() {
        return isEnd;
    }

    @Override
    void printWinner() {
        System.out.println();
        System.out.println(voittaja);
    }

    private void setEnd() {
        this.isEnd = true;
    }
}
