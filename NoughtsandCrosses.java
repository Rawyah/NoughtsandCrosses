import java.util.Scanner; 
public class NoughtsandCrosses {
    
    // cell content 
    public static final int Empty=0; 
    public static final int Cross=1;
    public static final int Nought=2;
    
    // state 
     public static final int Playing=0;
     public static final int Draw =1; 
     public static final int CrossWin=2;
     public static final int NoughtWin=3;
     
     // arry for board 
      public static final int Row=3;
      public static final int Col=3; 
      public static int[][] board = new int[Row][Col]; 
      
     public static int CurrentState;
     public static int CurrentPlayer;
     public static int CurrentRow;
     public static int CurrentCol;
     public static Scanner rm= new Scanner(System.in);
     
     public static void main(String[]args)
     {
         intiGame();
         Printboard();
         do{ 
             PlayerMove(CurrentPlayer);
             UpdateGame(CurrentPlayer,CurrentRow,CurrentCol);
             Printboard();
             if(CurrentState==CrossWin)
                 System.out.println("X has won !");
             else if(CurrentState==NoughtWin)
                 System.out.println("O has won !");
             else if (CurrentState==Draw)
                 System.out.println("It's  draw !!"); 
             
             if(CurrentPlayer==Cross) // player switch 
                 CurrentPlayer=Nought;
             else 
                 CurrentPlayer=Cross; 
                     
         }while(CurrentState==Playing);
     }
         public static void intiGame()
         {
             for(int row=0;row<Row;row++){
                 for(int col=0;col<Col;col++){
                     board[row][col]=Empty;
                 }
             }
             CurrentState=Playing;
             CurrentPlayer=Cross;
                 
         }
      public static void PlayerMove(int seed)
      {
          boolean validInpute=false;
          do{
              if(seed==Cross)
              {
                  System.out.print("Player 'X', enter your move (row[1-3] column[1-3])");
              }
              else
              {
                  System.out.print("Player 'O', enter your move (row[1-3] column[1-3])");
              }
              int row= rm.nextInt()-1;
              int col= rm.nextInt()-1;
              if(row>=0&& row<Row&& col>=0&& col<Col&& board[row][col]==Empty)
              {
                  CurrentRow=row;
                  CurrentCol=col;
                  board[CurrentRow][CurrentCol]=seed;
                  validInpute=true;
              }
              else 
              {
                  System.out.println("This move at ("+(row+1)+","+(col+1)+") is not valid, try again");
              }
              
          }while(!validInpute);
      }
     public static void UpdateGame(int seed, int CurrentRow,int CurrentCol)
     {
         if(haswon(seed,CurrentRow,CurrentCol))
         {
             if(seed==Cross)
                 CurrentState=CrossWin;
             else 
                 CurrentState=NoughtWin;
         }
         else if (isDraw())
         {
            CurrentState=Draw;  
         }
     }
         
    public static boolean isDraw()
    {
        for(int row=0; row<Row;row++) {
            for(int col=0; col<Col;col++){
                if(board[row][col]==Empty)
                    return false; 
            }
         
        }
             
        return true;          
    }
    public static boolean haswon(int seed, int CurrentRow,int CurrentCol )
    {
        return (board[CurrentRow][0]==seed&&board[CurrentRow][1]==seed&&board[CurrentRow][2]==seed // 3- in row
                ||board[0][CurrentCol]==seed&&board[1][CurrentCol]==seed&&board[2][CurrentCol]==seed // 3- in col
                ||CurrentRow==CurrentCol&& board[0][0]==seed&& board[1][1]==seed&& board[2][2]==seed // 3 in diaginal 
                ||CurrentRow+CurrentCol==2&& board[0][2]==seed&& board[1][1]==seed&& board[2][0]==seed); // 3 in opisit diagial 
    }
         // method to print board
       public static void Printboard()
       {
           for(int row=0; row<Row;row++)
             {
                 for(int col=0; col<Col;col++)
                 {
                     Printcell(board[row][col]);
                     if(col!=Col-1)
                      System.out.print("|");   
                 }
                 System.out.println();
                 if(row!=Row-1)
                    System.out.print("-----------");
                 System.out.println();
             }
             //System.out.println();
       }
                 
         
    
    public static void Printcell(int contant)
    {
        switch(contant) {
            case Empty:System.out.print("  ");
            break; 
            case Cross: System.out.print(" X ");
            break; 
            case Nought: System.out.print(" O ");
            break; 
        }
    }

     
              
     
        
    
    

}
