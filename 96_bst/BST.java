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




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
    System.out.println();
  }
  public void preOrderTrav( TreeNode currNode )
  {
    System.out.print(currNode.getValue() + " ");
    if (currNode.getLeft() != null) preOrderTrav(currNode.getLeft());
    if (currNode.getRight() != null) preOrderTrav(currNode.getRight());
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
    System.out.println();
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) inOrderTrav(currNode.getLeft());
    System.out.print(currNode.getValue() + " ");
    if (currNode.getRight() != null) inOrderTrav(currNode.getRight());
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
    System.out.println();
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) postOrderTrav(currNode.getLeft());
    if (currNode.getRight() != null) postOrderTrav(currNode.getRight());
    System.out.print(currNode.getValue() + " ");
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
      if (st == null) return 0;
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
  public static void main( String[] args )
  {


      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );
      //arbol.insert( 20 );
      //arbol.insert( 10 );
      //arbol.insert( 23 );


      /*
        tree look like

                 4
               /  \
              2    5
             / \    \
            1  3     6

        height: 3
        #leaves: 3
      */

      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");

      System.out.println("num leaves: ");
      System.out.println(arbol.numLeaves());

      System.out.println( "\n-----------------------------");

      System.out.println("height: ");
      System.out.println(arbol.height());

      System.out.println( "\n-----------------------------");

      int rand = (int)(Math.random() * 7) + 1;
      System.out.println("searching for " + rand + ": ");
      System.out.println("found: " + arbol.search(rand));

      System.out.println( "\n-----------------------------");
      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
