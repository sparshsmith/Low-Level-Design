public class Main {
    public static void main(String[] args) {

        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();

        String result = game.playGame();
        if(result != null){
            System.out.println("Winner of game is : "+ result);
        } else {
            System.out.println("Game is tie!!!!");
        }
    }
}