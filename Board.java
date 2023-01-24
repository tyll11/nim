public class Board{
    public static int remainingPieces;
    public static void populate(int p){
        remainingPieces = p;
    }
    public static void subtractPieces(int amount){
        remainingPieces -= amount;
    }
    public static int getPieces(){
        return remainingPieces;
    }
}