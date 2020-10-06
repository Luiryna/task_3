package generation;

public class Game {
    public static int getGameResult(int computersMove, int playersMove, String[] args) {
        if (playersMove == computersMove) {
            return 0;
        }
        for (int i = 1; i <= (args.length / 2) ; i++) {
            if (((playersMove + i) % args.length == computersMove) || (((playersMove + i) % args.length == 0))) {
                return -1;
            }
        }
        return 1;
    }
}
