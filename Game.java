import java.util.Scanner; 

public class Game{
    public Game(){

    }
    Scanner a = new Scanner(System.in);
    private int move = 0; 
    public Game(int s){
        startGame();
    }
    public void startGame(){
        // welcome message
       System.out.println("Welcome, say reset to reset at any time");
        askMove();
    }


    public void askMove(){
        int userInput;
        // System.out.println(currentPlayer)
        if(move % 2 == 0){
            
            System.out.print("Player 1's Move :" );
            userInput = a.nextInt();
            if( userInput <= .5 * Board.getPieces()){
                Board.subtractPieces(userInput);
                move += 1;
                askMove();
            }
            else{
                System.out.println("Not a valid input");
                askMove();
            }
           
            

        }
        else{
            System.out.print("Player 2's Move :" );
            userInput = a.nextInt();
            if( userInput <= .5 * Board.getPieces()){
                Board.subtractPieces(userInput);
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