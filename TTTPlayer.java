import java.util.Scanner;


public class TTTPlayer {
    char symbol;
    Scanner scanner = new Scanner(System.in);

    public TTTPlayer(char symbol) {
        this.symbol = symbol;
    }

    public int getTurn() {
        System.out.println("Player " + symbol + " - du bist am Zug!");
        int input;
        try {
            input = scanner.nextInt();
            if(input >= 0 && input <= 8) {
                return input;
            } else {
            System.out.println("Ungültige Eingabe. Bitte wähle eine Zahl zwischen 0 und 8.");
            System.out.println("Bitte nochmal probieren.");
                return -1;
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Ungültige Eingabe. Bitte wähle eine Zahl zwischen 0 und 8.");
            System.out.println("Bitte nochmal probieren.");
            return -1;
        }
    }

    public boolean validateTurn(int[] board, int turn) {
        if(board[turn] == -1) {
            System.out.println("Ungültige Eingabe. Bitte wähle eine Zahl zwischen 0 und 8.");
            return true;
        } else {
            System.out.println("Das Feld " + turn + " ist bereits besetzt. Bitte wähle ein anderes Feld.");
        return false;
        }
    }
}