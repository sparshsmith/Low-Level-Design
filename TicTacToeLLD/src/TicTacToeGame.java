import java.util.*;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;

    Map<Integer,Map<Piece, Integer>> rowMap;
    Map<Integer,Map<Piece, Integer>> colMap;
    Map<Piece, Integer> diagMap;
    Map<Piece, Integer> revDiagMap;

    public void initializeGame(){
        players = new LinkedList<>();

        PieceType crossPiece = new PieceTypeX();
        Player player1 = new Player("Player1", crossPiece);

        PieceType noughtsPiece = new PieceTypeO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        board = new Board(3);

        rowMap = new HashMap<>();
        colMap = new HashMap<>();
        diagMap = new HashMap<>();
        revDiagMap = new HashMap<>();

    }

    public String playGame(){
        boolean gameFinished = false;
        int totalPlayCount = 0;

        while(!gameFinished){
            Player playerTurn = players.removeFirst();
            board.printBoard();
//            List<Pair> freeSpaces =  board.getFreeCells();
            if(totalPlayCount == board.size * board.size){
                gameFinished = true;
                continue;
            }
            //read the user input
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully = board.addPiece(inputRow,inputColumn, playerTurn.pieceType);
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect position. Try again!!");
                players.addFirst(playerTurn);
                continue;
            }

            boolean isWinner = checkPlayerWon(inputRow, inputColumn, playerTurn.pieceType.piece);
            if(isWinner){
                board.printBoard();
                return playerTurn.name;
            }
            totalPlayCount++;
            players.addLast(playerTurn);
        }
        return null;
    }

    private boolean checkPlayerWon(int inputRow, int inputColumn, Piece piece) {
        if(rowMap.get(inputRow) == null)
            rowMap.put(inputRow, new HashMap<>());
        Map<Piece, Integer> row = rowMap.get(inputRow);
        row.put(piece, row.getOrDefault(piece,0)+1);
        if(row.get(piece) == board.size)
            return true;

        if(colMap.get(inputColumn) == null)
            colMap.put(inputColumn, new HashMap<>());
        Map<Piece, Integer> col = colMap.get(inputColumn);
        col.put(piece, col.getOrDefault(piece,0)+1);
        if(col.get(piece) == board.size)
            return true;

        if(inputRow == inputColumn) {
            diagMap.put(piece, diagMap.getOrDefault(piece, 0) + 1);
            if (diagMap.get(piece) == board.size)
                return true;
        }

        if(inputRow + inputColumn == board.size - 1) {
            revDiagMap.put(piece, revDiagMap.getOrDefault(piece, 0) + 1);
            if (revDiagMap.get(piece) == board.size)
                return true;
        }
        return false;
    }
}
