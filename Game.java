import java.util.Scanner; 
import java.util.Random;

public class Game{
    public Game(){

    }
    Scanner a = new Scanner(System.in);
    Random rand = new Random();

    private int move = rand.nextInt(1,2); 
    private int player1Score = 0;
    private int player2Score = 0;
    public Game(int s){
        startGame();
    }
    public void startGame(){
     
  
       System.out.println("How many pieces do you want the game to start with? Must be between 10 - 50");
        int number = a.nextInt();
        while(number > 50 || number < 10){
            System.out.println("Not a valid number, try again.");
            number = a.nextInt();
        }
            Board.populate(number);
            askMove();
      
       
    }

    public void playAgain(){
        String answer = "";
        System.out.println("Would you like to play again? yes or no");
        answer = a.next();
        // System.out.println(answer);
        if(answer.equals("yes")){

            startGame();
        }
    }
    public void askMove(){
        int userInput;
        // System.out.println(currentPlayer)
        if(Board.remainingPieces == 1){
            if(move % 2 == 0){
                player2Score++;
                System.out.println("Player 2 Wins.");
                System.out.println("Player 1: " + player1Score);
                System.out.println("Player 2: " + player2Score);
                playAgain();
            }
            else{
                player1Score++;
                System.out.println("Player 1 Wins.");
                System.out.println("Player 1: " + player1Score);
                System.out.println("Player 2: " + player2Score);
                playAgain();

            }
        }
        else{
            if(move % 2 == 0){
                
                System.out.print("Player 1's Move: " );
                userInput = a.nextInt();
                if( userInput <= .5 * Board.getPieces()){
                    Board.subtractPieces(userInput);
                    System.out.println("Remaining: " + Board.remainingPieces);
                    move += 1;
                    askMove();
                }
                else{
                    System.out.println("Not a valid input");
                    askMove();
                }
            
                

            }
            else{
                System.out.print("Player 2's Move: " );
                userInput = a.nextInt();
                if( userInput <= .5 * Board.getPieces()){
                    Board.subtractPieces(userInput);
                    System.out.println("Remaining: " + Board.remainingPieces);
                    move += 1;
                    askMove();
                }
                else{
                    System.out.println("Not a valid input");
                    askMove();
                }
            }
    }
    }

}