import java.io.IOException;

public class TikTakToe {

    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert der gerade am Zum ist
        int turn = 0;
        int  winner = -1;
        int[] board = new int [9];
        for(int i = 0; i < board.length; i++) {
            board[i] = -1;
        }
        TTTPlayer a = new TTTPlayer('O');
        TTTPlayer b = new TTTPlayer('X');
        TTTPlayer[] players = new TTTPlayer[2];
        players[0] = a;
        players[1] = b;

        
        String separator = "";

        while(winner == -1) {
            clearConsole();
            System.out.println(separator); 
            printGameBoard(); 
            System.out.println(separator);
            printBoard(board);

            int turnField = players[turn].getTurn();
            if(turnField != -1 && players[turn].validateTurn(board, turnField)) {
                board[turnField] = players[turn].symbol;
                turn = (turn + 1) % 2;
            } else {
                try{
                    if(turnField != -1) {
                        Thread.sleep(2000);
                    } else {
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                        System.out.println("Fehler beim Warten: " + e.getMessage());
                    }
                }
            winner = checkWinner(board);
        }

        clearConsole();
        System.out.println(separator);
        printGameBoard();
        System.out.println(separator);
        printBoard(board);

        if(winner == 2) {
            System.out.println("Unentschieden!");
        } else {
            System.out.println("Herzlichen Glückwunsch, Spieler " + (char) winner + " Du hast gewonnen!");
        }
    }

    public static void printGameBoard() {
        System.out.println("0 | 1 | 2");
        System.out.println("__________");
        System.out.println("3 | 4 | 5");
        System.out.println("__________");
        System.out.println("6 | 7 | 8");
        System.out.println("");
    }

    public static int checkWinner(int[] board) {
        int winner = -1;
        // Sieger überprüfen
        if(winner != -1) {
            return winner;
        }

        // Sieger überprüfen
        winner = -1;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1) {
            winner = board[0];
        } 
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != -1) {
            winner = board[3];
        }

        else if(board[6] == board[7] && board[6] == board[8] && board[6] != -1) {
            winner = board[6];
        }

        else if(board[0] == board[4] && board[0] == board[8] && board[0] != -1) {
            winner = board[0];
        }

        else if(board[2] == board[4] && board[2] == board[6] && board[2] != -1) {
            winner = board[2];
        }

        else if(board[0] == board[3] && board[0] == board[6] && board[0] != -1) {
            winner = board[0];
        }

        else if(board[1] == board[4] && board[1] == board[7] && board[1] != -1) {
            winner = board[1];
        }

        else if(board[2] == board[5] && board[2] == board[8] && board[2] != -1) {
            winner = board[2];
        }

        if(winner != -1) {
            return winner;
        }

        // Unentschieden überprüfen 
        boolean isDraw = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == -1) {
                isDraw = false;
                break;
            }
        }

        if (isDraw) {
            // Rückgabewert für Unentschieden
            return 2; 
        }

        return -1;
    }

    public static void printBoard(int[] meinBoard) {
        for (int i = 0; i < meinBoard.length; i++) {
            if (meinBoard[i] == -1) {
                // Platzhalter für leere Felder
                System.out.print(" "); 
                if(i != 2 && i != 5 && i != 8) { 
                    System.out.print(" | ");
                }
            } else if(i != 2 && i != 5 && i != 8) {
                System.out.print((char) meinBoard[i] + " | ");
            } else {
                System.out.print((char) meinBoard[i] + " ");
            }

            if ((i + 1) % 3 == 0) {
                System.out.println("");
                if (i != meinBoard.length - 1) {
                    System.out.println("___________");
                }
            }
        }
    }
    
        public static void clearConsole() {
            try {
                final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (final InterruptedException | IOException e) {
                System.out.println("Fehler beim Löschen des Konsolenbildschirms: " + e.getMessage());
            }
    }
}