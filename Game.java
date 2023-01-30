import java.util.Scanner;
// import java.util.InputMismatchException;
import java.util.Random;

public class Game{
    public Game(){

    }
    Scanner a = new Scanner(System.in);
    Random rand = new Random();

    private int move = rand.nextInt(1,11); 
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private int bestOf;
    private int number;
    public Game(int s){
        startGame();
    }
    public void startGame(){
     
  
       System.out.println("How many pieces do you want the game to start with? Must be between 10 - 50");
        number = a.nextInt();
        System.out.print("Best of: ");
        bestOf = a.nextInt();
        while(number > 50 || number < 10){
            System.out.println("Not a valid number, try again.");
            number = a.nextInt();
            
        }
            Board.populate(number);
            System.out.println("Enter player 1 name: ");
            player1Name = a.next();
            System.out.println("Enter player 2 name: ");
            player2Name = a.next();
        
            askMove();
      
       
    }

    public void playAgain(){
       
        if(player1Score > (.5 * bestOf) || player2Score > (.5 * bestOf)){
            String answer = "";
            System.out.println("Would you like to play again? yes or no");
            answer = a.next();
            // System.out.println(answer);
            if(answer.equals("yes")){

                startGame();
            }
        }
        
        else{
       System.out.println("Next round starting with "+ number + " pieces.");
        Board.populate(number);
        askMove();
    }
    
    }
    public void askMove(){
        int userInput;
        // System.out.println(currentPlayer)
        if(Board.remainingPieces == 1){
            if(move % 2 == 0){
                player2Score++;
                System.out.println(player1Name + " Wins.");
                System.out.println(player1Name + "'s Score: " + player1Score);
                System.out.println(player2Name + "'s Score: " + player2Score);
                playAgain();
            }
            else{
                player1Score++;
                System.out.println(player2Name + " Wins.");
                System.out.println(player1Name + "'s Score: " + player1Score);
                System.out.println(player2Name + "'s Score: " + player2Score);
                playAgain();

            }
        }
        else{
        
            if(move % 2 == 0){
                
                System.out.print(player1Name+ "'s Move: " );
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
                
                System.out.print(player2Name+ "'s Move: " );
        
                userInput = a.nextInt();   
                if(userInput <= .5 * Board.getPieces()){
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