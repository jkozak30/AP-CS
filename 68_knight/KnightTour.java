// Great, Nice Jingles: Julia Kozak, Gloria Lee, Nafiz Labib (Flopsy, Flounder, Martha)
// APCS pd08
// HW68 -- recursively probing for a closed cycle
// 2022-02-28m
// time spent:  0.5hrs (except for ... time trials)

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO: Set the default board to one filled with 0s that is of your desired size, but surrounded by a border of -1s that is 2 wide.
 *       Start with move 1, and set your first square to the starting square of value 1. For each of the 8 possible moves, check if the landing square is of value 0 (meaning it's a potential move). If so, move there and repeat the steps for that square, incrementing your move number by 1.
 *       If at any point you have no potential moves, reset the current square's value to 0 and try the next possible move on the same branch.
 *       Once your move counter reaches an integer beyond the number of potential moves (N^2 + 1), you know every move has been made, so set _solved to true (the board has been solved).
 *
 * DISCO: ANSI control code can clear the screen, change cursor position, etc.
 *        It's fine to have your several classes in one file.
 *        "time" can be used in the command line to record the runtime of your program.
 *
 * QCC:   Is there a way to track time using currentTimeMillis() in this case?
 *        Is it more optimal to have the same sequence of tested moves for each branch, or should it be randomized/based on the previous move in any way to improve efficiency?
 *        Instead of using System.exit() and "return," is there a way to do this with a non-void method that returns a boolean (like with n Queens)?
 *
 * Mean execution times for boards of size n*n (random starting sq):
 * n=5   7.77s    across 10 executions
 * n=6   47.23s    across 3 executions (13.74, 12.88, 115.07)
 * n=7   1931.13s    across 1 executions ( -_- )
 * n=8   654.92s    across 1 executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    //System.out.println("why no print");
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    //System.out.println("\033c");
    tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:

    /*for (int i=0; i<1; i++) {
      int startX = (int)(Math.random() * n) + 2;
      int startY = (int)(Math.random() * n) + 2;
      tf.findTour( startX, startY, 1 );
    }*/

    //int startX = (int)(Math.random() * n) + 2;
    //int startY = (int)(Math.random() * n) + 2;
    //tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  // ADDED: two arrays for x moves, y moves (matching indices correspond)
  private static final int[] moveX = {1, 2, 2, 1, -1, -2, -2, -1};
  private static final int[] moveY = {-2, -1, 1, 2, 2, 1, -1, -2};

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[_sideLength+4][_sideLength+4];

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
    for (int i=0; i<_sideLength+4; i++) {
      for (int j=0; j<_sideLength+4; j++) {
        _board[i][j] = -1;
      }
    }

    for (int i=2; i<_sideLength+2; i++) {
      for (int j=2; j<_sideLength+2; j++) {
        _board[i][j] = 0;
      }
    }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if ( _solved ) System.exit(0);

    //primary base case: tour completed
    if ( moves == (_sideLength)*(_sideLength)+1 ) {
      _solved = true;
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
    if ( _board[x][y] != 0 ) {
      return;
    }
    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;
      delay(500);

      System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      //???
      for (int i=0; i<8; i++) {
        int newX = x + moveX[i];
        int newY = y + moveY[i];
        findTour(newX, newY, moves+1);
      }


      //

      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
      _board[x][y] = 0;
      delay(125);
      //return;

      System.out.println( this ); //refresh screen
    }
  }//end findTour()

}//end class TourFinder
