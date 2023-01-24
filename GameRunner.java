import java.util.Scanner; 
public class GameRunner {
    public static void main(String[] args){
        Scanner b = new Scanner(System.in);
        System.out.println("How many pieces do you want the game to start with?");
        Board.populate(b.nextInt());
        Game game = new Game();
        game.startGame();
    }
}
