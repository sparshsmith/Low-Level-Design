import java.util.ArrayList;
import java.util.List;


public class Board {
    int size;
    PieceType[][] board;

    public Board(int size){
        this.size = size;
        board = new PieceType[size][size];
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].piece.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                if(j != size -1)
                    System.out.print(" | ");
            }
            System.out.println();

        }
    }

    public List<Pair> getFreeCells() {
        List<Pair> freeCells = new ArrayList<>();
        for(int i = 0; i< size; i++){
            for (int j = 0; j< size; j++){
                if(board[i][j] == null){
                    freeCells.add(new Pair(i,j));
                }
            }
        }
        return freeCells;
    }

    public boolean addPiece(int row, int column, PieceType playingPiece) {

        if(row >= size || column >= size || board[row][column] != null) {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

}
