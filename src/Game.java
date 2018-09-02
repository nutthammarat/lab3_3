import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col,row;
    public static void main(String[] args) {
       ox = new OX();
        while(true){
            printTable();
            input();
            if(ox.checkWin(col,row)){
                printTable();
                printWin();
                printScore();
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                printTable();
                printScore();
                printDraws("Draw" );
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }

    private static void printDraws(String draw) {
        System.out.println(draw);
    }

    private static void printWin() {
        System.out.println(ox.getCurrentPlayer() + " " + "Win");
    }

    private static void printScore() {
        printDraws("X win : " + ox.getScoreX());
        printDraws("O win : " + ox.getScoreO());
        printDraws("Draw : " + ox.getScoreDraw());
    }

    private static void input() {
        boolean canPut = true;
        do{
        System.out.print(ox.getCurrentPlayer()+" Col : ");
        col = sc.nextInt();
        System.out.print(ox.getCurrentPlayer()+" Row : ");
        row = sc.nextInt();
        canPut = ox.put(col,row);
            if(!canPut){
                printDraws("Please input number between 0-2");
            }
        }while (!canPut);


    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }
}
