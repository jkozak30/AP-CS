/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    if ( _root == null) { _root = newNode; }
    else {
      insert(_root, newNode);
    }
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if (stRoot.getValue() > newNode.getValue()) {
      if (stRoot.getLeft() == null) {
        stRoot.setLeft(newNode);
      } else {
        insert(stRoot.getLeft(), newNode);
      }
    } else {
      if (stRoot.getRight() == null) {
        stRoot.setRight(newNode);
      } else {
        insert(stRoot.getRight(), newNode);
      }
    }
  }//end insert()

  // REMOVE: void method that calls helper method that returns the tree with
  // the removed node, then sets the result back to _root.

  public void remove(int val) {
    TreeNode victim = this.search(val);
    if (victim == null) return;
    else _root = remove(val, _root);

  }

  /*
  REMOVE ALGO:
  1. check if the value is the current root, and if not, search again for it
     by recursing on the correct branch.
  2. (now it is the root) if the root's left and right subtrees are null, then
     return an empty tree (null) a your resulting tree.
  3. else if only one of the branches is null, set your resulting tree to the
     nonempty branch.
  4. else, find the minimum value in the right branch (helper method finds the
     leftmost element there). We know everything in the left branch remains BST,
     so now update the right branch to remove the new minimum value (until it's
     pushed to be a root/have one child).
  */
  public TreeNode remove(int val, TreeNode st) {
    //recursing
    if (val < st.getValue()) {
      st.setLeft(remove(val, st.getLeft()));
    } else if (val > st.getValue()) {
      st.setRight(remove(val, st.getRight()));
    } else { //until val is root

      if(st.getLeft() == null && st.getRight() == null) {
        return null;
      } else if (st.getLeft() == null) {
        return st.getRight();
      } else if(st.getRight() == null) {
        return st.getLeft();
      } else {

        TreeNode swap = min(st.getRight());
        st.setValue(swap.getValue());
        st.setRight(remove( st.getValue(), st.getRight()));


      }
    }
    return st;

  }

  public TreeNode min(TreeNode st) {
    if (st.getLeft() == null) return st;
    else {
      return min(st.getLeft());
    }
  }




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public String preOrderTrav()
  {
    return preOrderTrav( _root );
  }
  public String preOrderTrav( TreeNode currNode )
  {
    String ret = "";
    if (currNode != null) ret += currNode.getValue() + " ";
    if (currNode != null && currNode.getLeft() != null) ret += preOrderTrav(currNode.getLeft());
    if (currNode != null && currNode.getRight() != null) ret += preOrderTrav(currNode.getRight());
    return ret;
  }

  //recurse left, process root, recurse right
  public String inOrderTrav()
  {
    return inOrderTrav( _root );
  }
  public String inOrderTrav( TreeNode currNode )
  {
    String ret = "";
    if (currNode != null && currNode.getLeft() != null) ret += inOrderTrav(currNode.getLeft());
    if (currNode != null) ret += currNode.getValue() + " ";
    if (currNode != null && currNode.getRight() != null) ret += inOrderTrav(currNode.getRight());
    return ret;
  }

  //recurse left, recurse right, process root
  public String postOrderTrav()
  {
    return postOrderTrav( _root );
  }
  public String postOrderTrav( TreeNode currNode )
  {
    String ret = "";
    if (currNode != null && currNode.getLeft() != null) ret += postOrderTrav(currNode.getLeft());
    if (currNode != null && currNode.getRight() != null) ret += postOrderTrav(currNode.getRight());
    if (currNode != null) ret += currNode.getValue() + " ";
    return ret;
  }

  public String toString(){
    String ret = "pre: ";
    ret += this.preOrderTrav();
    ret += ", in: ";
    ret += this.inOrderTrav();
    ret += ", post: ";
    ret += this.postOrderTrav();
    return ret;
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
      return search(target, _root);
    }

    TreeNode search(int target, TreeNode st) {
      if (st == null) return null;
      else if (st.getValue() == target) { return st; }
      else {
        if (target < st.getValue()) {
          return search(target, st.getLeft());
        } else {
          return search(target, st.getRight());
        }
      }
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
      return height ( _root );
    }

    // helper bc helper
    public int height( TreeNode st ) {
      if (st == null) return -1;
      else {
        return Math.max(height(st.getLeft()), height(st.getRight())) + 1;
      }
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
    	return numLeaves(_root);
    }

    public int numLeaves(TreeNode st) {
      if (st == null) return 0;
      else if (st.getRight() == null && st.getLeft() == null) {
        return 1;
      } else {
        return numLeaves(st.getLeft()) + numLeaves(st.getRight());
      }
    }

    //main method for testing
      public static void main( String[] args ) {

  	BST arbol = new BST();

  	System.out.println( "tree init'd: " + arbol );

  	//inserting in this order will build a perfect tree
  	arbol.insert( 3 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	arbol.insert( 2 );
  	arbol.insert( 5 );
  	arbol.insert( 4 );
  	arbol.insert( 6 );
  	/*
  	*/

  	//insering in this order will build a linked list to left
  	/*
  	arbol.insert( 6 );
  	arbol.insert( 5 );
  	arbol.insert( 3 );
  	arbol.insert( 4 );
  	arbol.insert( 2 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	*/

  	System.out.println( "tree after insertions:\n" + arbol );
  	System.out.println();

  	System.out.println();
  	for( int i=-1; i<8; i++ ) {
  	    System.out.println(" searching for "+i+": " + arbol.search(i) );
  	}

  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(6);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(5);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(4);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(3);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(2);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(1);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(0);
  	System.out.println();
  	System.out.println( arbol );
  }

}//end class
