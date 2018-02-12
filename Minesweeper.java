package Minesweeper;

import java.util.ArrayList;
import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {
      int  size = AskFordifficult();
         int  [] [] minesfield = new int [size] [size];
         char [] []outputField = new char [size][size];
            
         init (minesfield, outputField);
         
         displayOutput(outputField);
      
         boolean gameOver = false;
         while (gameOver != true)
         {
            gameOver = playGame(minesfield, outputField);
            displayOutput(outputField);  
         }
       
      } 
   public static int AskFordifficult()
      {
         Scanner console = new Scanner(System.in);
         System.out.println("Welcome to the game of minesweeper!\n If you would like to play on a easy dificult press 5");
         System.out.println("If you want to play on a hard dificult press 10");
         int choice = console.nextInt();
         if (choice==5 || choice ==10)
         {
           return choice;
         }
         else
         {
           System.out.println("Error, please try again");
           choice=AskFordifficult();
         }
         return choice;
      }
 
       public static  void init (int [] [] mines, char [] [] output)
      {
         for (int r = 0; r < output.length; r++)
         {
            for (int c = 0; c < output[0].length; c++)
               output[r][c] = ' ';
         }
         
         for (int r = 0; r <  mines.length; r++)
         {
            for (int c = 0; c < mines[0].length; c++)
               mines[r][c] = (int)(Math.random() * 2);
         }
      } 
    public static void displayOutput (char [] [] output)
      {
         for (int r = 0; r < output.length; r++)
         {
            for (int c = 0; c < output[0].length; c++)
               System.out.print ("[" + (char)output[r][c] + "]");
            System.out.println();
         } 
      }
   public static int countMines (int [] [] mines, int r, int c)
      {
         int rMin = r-1;
         int rMax = r+1;
         int cMin = c-1;
         int cMax = c+1;
         if (r == 0)
         {rMin = 0;}
         if (r == mines.length-1)
         {rMax = mines.length-1;}
         if (c == 0)
         {cMin = 0;}
         if (c == mines.length-1)
         {cMax = mines.length-1;}
         
         int count = 0;
         for(int i = rMin; i<= rMax; i++)
         {
           for(int j = cMin; j<= cMax; j++)
           {
             
             if(mines[i][j] == 1 && i != r && j !=c)
               {
                 count++;
               }
           }
         }
         return count;
      }  
   private static boolean checkStatus(int [][] mines)
       {
         int count = 0;
         int target = mines.length*mines.length;
         for (int r = 0; r<mines.length; r++)
         {
           for(int c = 0; c<mines.length;c++)
             {
             if(mines[r][c]==1 || mines[r][c]==-1)
               {
                 count++;
               }
             if (count==target)
               {
                 return true;
               }
             }            
         }
         return false;
       }
               
   public static boolean playGame (int [][] mines, char [] [] outputBoard)
      {
         Scanner console = new Scanner(System.in);
         System.out.println("Enter row and column of the cell you want to open[row col]:");
         int row = console.nextInt();
         int col = console.nextInt();
         
         if (mines[row][col] == 1)
         {
           System.out.println("You stepped on a mine , you lose.");
           outputBoard[row][col]='X';
           return true;
         }
         
         else
         {
           outputBoard[row][col]=(countMines(mines,row,col)+"").charAt(0);
           mines[row][col]=-1;
           
           if (checkStatus(mines)==true)
           {
             System.out.println("Congratulations! You Win.");
             return true;
           }
           return false;
         }
      }  
   } 
      
    
    



