// Great, Nice Jingles: Julia Kozak, Nafiz Labib, Gloria Lee (Flopsy, Martha, Flounder)
// APCS pd08
// HW65: How Many Queens Can a Thinker Place, If a Thinker Can Place Queens…
// 2022-02-17

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0);
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if (col >= _board.length) {
      printSolution();
      for (int i=0; i<_board.length; i++) {
        for (int j=0; j<_board.length; j++) {
          _board[i][j] = 0;
        }
      }
      return true;
    } else {
      int solCtr = 0;
      for (int i=0; i<_board.length; i++) {
        if (_board[i][col] == 0) {
          addQueen(i, col);
          if (solveH(col+1)) {
            removeQueen(i, col);
            return true;
          }
          removeQueen(i, col);

        }
      }
      return false;
    }
  }


  public void printSolution()
  {
    String ans = "";
    for (int i=0; i<_board.length; i++) {
      for (int j=0; j<_board.length; j++) {
        if (_board[i][j] != 1) {
          ans += "_\t";
        } else {
          ans += "Q\t";
        }
      }
      ans += "\n";
    }
    System.out.println(ans);
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Given that this square is not attacked and has no Queen on it, this method will add a Queen and mark the squares it attacks (only those in the columns to the right of it)
   * precondition: There are no other queens in the same row or column.
   * postcondition: If a square is not attacked, the queen is placed on inputted row and column.
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * Given that a Queen is on a square, this method will remove it and unmark all squares it attacked
   * precondition: There is a Queen at the given square.
   * postcondition: The queen is removed from inputted row and column.
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * toString for printing the values that show up in each slot of the _board 2D array
   * precondition: board[][] of the instance has defined values
   * postcondition: returns a String form of the board displaying rows, columns
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard two = new QueenBoard(2);
    QueenBoard three = new QueenBoard(3);
    QueenBoard four = new QueenBoard(4);
    QueenBoard five = new QueenBoard(5);

    QueenBoard f6 = new QueenBoard(8);
    QueenBoard f7 = new QueenBoard(13);
    QueenBoard f8 = new QueenBoard(21);
    //System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    //b.addQueen(3,0);
    //b.addQueen(0,1);
    //System.out.println(b);
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    //b.removeQueen(3,0);
    //System.out.println(b);
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */

    System.out.println(two.solve());
    System.out.println(three.solve());

    System.out.println(four.solve());
    System.out.println(five.solve());
    System.out.println(f6.solve());
    System.out.println(f7.solve());
    System.out.println(f8.solve());


  }

}//end class
