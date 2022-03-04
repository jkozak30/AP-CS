// Red Lobsters: Julia Kozak, Kevin Xiao, Faiyaz Rafee
// APCS pd08
// HW69 -- maze solving (blind, depth-first)
// 2022-03-03r
// time spent: hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 *  - From your starting square, check if there is an open path to each of your four possible moves (up, right, left, down).
 *  - Once you find a move, move there, marking the square you were previously at as part of your path, and repeat the process.
 *  - If you reach a point where you find no possible moves, return to the square you were at (marking it as visited), then return to the square before that, etc. until you reach the last square for which you had other possible moves, and try its next possible move.
 *  - If you reach the exit (or you have tried all possible paths), the program will terminate.
 *
 * DISCO:
 *  - Code written after the recursion step will be executed once all four recursive calls run and return (meaning that trying that path was unsuccessful).
 *  - Another ANSI prefix for escape is \u001b
 *  - text files can have extensions like .maze and their contents can still be processed as text.
 *
 * QCC:
 *  - Are there any ways to optimize the solution (ex. pick the move that is closest to the goal, which might not always work)?
 *  - Can recursive backtracking also be used to randomly generate mazes?
 *
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  private int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "\u001b[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
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
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY );
    System.out.println( this );  //slow it down enough to be followable

    //primary base case
    if ( _maze[x][y] == '$' ) {
      System.exit(0);
    }
    //other base cases
    else if ( _maze[x][y] != '#') {
      return;
    }
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
      _maze[x][y] = '@';
      solve(x, y-1);
      solve(x+1, y);
      solve(x-1, y);
      solve(x, y+1);
      System.out.println( this ); //refresh screen
      delay(FRAME_DELAY);
      _maze[x][y] = '.';
      System.out.println( this ); //refresh screen
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
    return _maze[x][y] == '#';
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "\u001b[2J" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)
    // ThinkerTODO: comment next line out when ready to randomize startpos
    //ms.solve( 4, 3 );

    //drop our hero into maze at random location on path
    // YOUR RANDOM-POSITION-GENERATOR CODE HERE
    int startX = (int)(Math.random() * 80);
    int startY = (int)(Math.random() * 25);
    while (!ms.onPath(startX, startY)) {
      startX = (int)(Math.random() * 80);
      startY = (int)(Math.random() * 25);
    }
    ms.solve( startX, startY );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze
