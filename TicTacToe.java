/**
 * Created by Sutriptim Nath on 9th;August;2020
 */
package TicTacToe;

import java.util.Scanner;
public class TicTacToe {
    char board[][];
    char playermark;

    public TicTacToe() {
        board = new char[3][3];
        playermark = 'x';
        initializeBoard();
    }

    public void initializeBoard() {
        int c = '1';
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                board[row][col] = (char)c;
                c++;
            }
            System.out.println();
        }
    }

    public void printBoard() {
        System.out.println("-------------------");
        for(int row=0; row<3; row++) {
            System.out.print("|  ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + "  |  ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public boolean isBoardFull() {
        boolean f = true;
        for(int row=0; row<3; row++) {
            for (int col = 0; col < 3; col++) {
                if(board[row][col] != 'x' || board[row][col] != 'o') {
                    f = false;
                }
            }
        }
        return f;
    }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    // Hiding method from user access.
    private boolean checkRowsForWin() {
        for(int row = 0; row < 3; row++) {
            if (checkRowCol(board[row][0], board[row][1], board[row][2]) == true)
                return true;
        }
        return false;
    }

    // Hiding method from user access.
    private boolean checkColumnsForWin() {
        for(int col = 0; col < 3; col++) {
            if (checkRowCol(board[0][col], board[1][col], board[2][col]) == true)
                return true;
        }
        return false;
    }

    // Hiding method from user access.
    private boolean checkDiagonalsForWin() {
        if(checkRowCol(board[0][0], board[1][1],board[2][2]) == true)
            return true;
        else if(checkRowCol(board[0][2], board[1][1],board[2][0]) == true)
            return true;
        else return false;
    }

    // Hiding method from user access.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return((isNotEmpty(c1)) && (c1==c2) && (c2==c3));

        // Checking if the c1 is not empty and if c1 is equal to c2 and c3.
    }

    // Hiding method from user access.
    private boolean isNotEmpty(char c) {
        return (c=='x' || c=='o');
    }

    public void nextMove() {
        if(playermark == 'x')
            playermark = 'o';
        else
            playermark = 'x';
    }

    public boolean playerMove(char move) {

        if((move>0 && move<10) && !isNotEmpty((char)singledArray(move))) {
            setMark(move);
            return true;
        }
        return false;
    }

    private char singledArray(char move) {
        switch(move) {
            case '1' : return board[0][0];
            case '2' : return board[0][1];
            case '3' : return board[0][2];
            case '4' : return board[1][0];
            case '5' : return board[1][1];
            case '6' : return board[1][2];
            case '7' : return board[2][0];
            case '8' : return board[2][1];
            case '9' : return board[2][2];
        }
        return (char)-1;
    }

    private void setMark(int set) {
        switch(set) {
            case 1 : board[0][0] = playermark; break;
            case 2 : board[0][1] = playermark; break;
            case 3 : board[0][2] = playermark; break;
            case 4 : board[1][0] = playermark; break;
            case 5 : board[1][1] = playermark; break;
            case 6 : board[1][2] = playermark; break;
            case 7 : board[2][0] = playermark; break;
            case 8 : board[2][1] = playermark; break;
            case 9 : board[2][2] = playermark; break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicTacToe ttt = new TicTacToe();
        ttt.initializeBoard();
        System.out.println("--------- Tic Tac Toe ---------");

        do {
            ttt.printBoard();
            int mark;
            char markconvrttochar;
            do {
                System.out.print("Player -  " + ttt.playermark + " Enter your move - ");
                mark = sc.nextInt();
                markconvrttochar =(char)mark;
            } while(!ttt.playerMove(markconvrttochar));
            ttt.nextMove();
        }while(!ttt.checkForWin() && !ttt.isBoardFull());
        if(ttt.isBoardFull() && !ttt.checkForWin()) {
            System.out.println("Draw Match");
        }
        else {
            ttt.printBoard();
            ttt.nextMove();
            System.out.println(ttt.playermark + "     Wins the game :)  Congo");
        }
    }
}
