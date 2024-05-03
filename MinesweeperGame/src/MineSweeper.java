import java.util.Random;
import java.util.Scanner;
public class MineSweeper
{
    Scanner  input=new Scanner(System.in);
    private boolean gameOver=false;
    private boolean[][] opened;
    private int safeCellCount;
    public void GameStart() {
        int row, column, inputRow = 0, inputColumn = 0;
        System.out.println("How large will the game area be (in squares):");
        row = input.nextInt();
        column = row;
        String[][] minesweepMap = new String[row][column];
        String[][] minesweepGameMap = new String[row][column];
        opened=new boolean[row][column];
        createTestMap(minesweepMap, row, column);
        createGameMap(minesweepGameMap);
        while (gameOver != true) {

            while (true) {
                System.out.printf("Enter a row (between 1-%d) :", row);
                System.out.println();
                while (!input.hasNextInt()) {
                    System.out.println("Please enter a valid integer value!");
                    System.out.printf("Enter a row (between 1-%d) :", row);
                    System.out.println();
                    input.next();
                }
                inputRow = input.nextInt();
                if (inputRow < 1 || inputRow > row) {
                    System.out.println("You entered a row outside the game area, please try again! ");
                } else {
                    break;
                }
            }
            while (true)
            {
                System.out.printf("Enter a column (between 1-%d) :", column);
                System.out.println();
                while (!input.hasNextInt()) {
                    System.out.println("Please enter a valid integer value!");
                    System.out.printf("Enter a column (between 1-%d):", column);
                    System.out.println();
                    input.next();
                }
                inputColumn = input.nextInt();
                if (inputColumn < 1 || inputColumn > column ) {
                    System.out.println("\"You entered a column outside the game area." +
                            "Please enter a different column and try again!\" ");
                } else {
                    break;
                }
            }
            userInput(minesweepGameMap,minesweepMap,inputRow-1,inputColumn-1);
        }
    }
    public void createTestMap(String[][] testMap,int row,int column)
    {
        //Developer map that appears if activated within the "createTestMap" method, unseen by the user.
        int mine=(row+column)/2;
        //Half the number of mines as the row and column values are added.
        // In future developments, the minefield can be determined according to the difficulty level.;
        safeCellCount=(row*column)-mine;
        Random rnd=new Random();
        System.out.println("==============MineSwapDeveloperMap==============");
        for (int i = 0; i < testMap.length; i++) {
            for (int j = 0; j < testMap[0].length; j++) {
                testMap[i][j] = "-";
            }
        }

        for (int i=1;i<=mine;i++)
        {
            testMap[rnd.nextInt(row)][rnd.nextInt(column)]="*";
        }
        //getTestMap(testMap);
    }
    public void createGameMap(String[][] gameMap)
    {
        //Game map where mines are not visible to the player.
        System.out.println("==============MineSwap==============");
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[0].length; j++) {
                gameMap[i][j] = "-";

            }
        }
        getGameMap(gameMap);
    }
    public void getTestMap(String[][] testMap)
    {

        for(int j = 0; j< testMap[0].length; j++)
            System.out.print("\t."+(j+1));
        System.out.println();
        for (int i = 0; i < testMap.length; i++) {
            System.out.print((i+1)+".\t");
            for (int j = 0; j < testMap[0].length; j++)
            {
                System.out.print(testMap[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void getGameMap(String[][] gameMap)
    {
        //Player map where mines are not visible to the user.
        for(int j = 0; j< gameMap[0].length; j++)
            System.out.print("\t."+(j+1));
        System.out.println();
        for (int i = 0; i < gameMap.length; i++) {
            System.out.print((i+1)+".\t");
            for (int j = 0; j < gameMap[0].length; j++)
            {
                System.out.print(gameMap[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void userInput(String[][] gameMap,String[][] testMap,int row,int column)
    {
        int checkColumn,checkRow;
        opened[row][column]=true;
        if (testMap[row][column].equals("*"))
        {
            System.out.println("Game Over!");
            System.out.println("Mine Map : ");
            gameOver=true;
            getTestMap(testMap);
        }
        else
        {
            safeCellCount--;
            if (safeCellCount==0)
            {
                System.out.println("Congratulations! You Won!");
                return;
            }
            mineCount(testMap,gameMap,row,column);
            getGameMap(gameMap);
        }
            //getTestMap(testMap); //If activated, the developer map opens.
    }
    public void mineCount(String[][] testMap,String[][] gameMap,int row,int column)
    {
        int mineCount=0;
        int maxRow=testMap.length;
        int maxColumn=testMap[0].length;
        for (int i=Math.max(0,row-1);i<=Math.min(row+1,maxRow-1);i++)
        {
            for (int j=Math.max(0,column-1);j<=Math.min(column+1,maxColumn-1);j++)
            {
                if(i==row&&j==column)
                {
                    continue;
                }
                if (testMap[i][j].equals("*"))
                {
                    mineCount++;
                }
            }
        }
        gameMap[row][column]=Integer.toString((mineCount));
    }

}
