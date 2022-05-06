Rin-Sensei: Julia Kozak, Rin Fukuoka, John Gupta-She
APCS pd08
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent: 0.5hrs


DISCO
------------------------------------------------
* A connected acyclic graph is the same as a tree.
* Checking if a graph is balanced/perfect/complete might rely on the fact that
  those properties will hold for its left/right subtrees.
================================================


QCC
------------------------------------------------
* Why is "complete" used to describe a graph that doesn't' have each level full
  (when that seems analogous to what a complete graph is)?
* When would you have to rely on these properties being true for a tree?
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
* It grows down.

Provide as many alternate definitions as you can for "tree," using graph
terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity,
succinctness.
* A(n undirected) tree is a graph that contains a unique path between every
  pair of distinct vertices.
* A tree contains no cycles. A connected graph with no cycles is a tree.
* Since a tree has no cycles, it has no closed tour. It has an open tour only
  if it is degenerate.

Why is a balanced tree allowed a difference of 1 in height between right and
left subtrees?
* Maybe because you don't' want to exclude the possibility of having only one
  child in nodes in your second to last layer.

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
* (couldn't' think of a better one but this is potentially recursive) A tree
  where its left and right subtrees have height difference at most 1, and are
  both balanced.

Is a perfect tree complete?
* Yes. All its levels are full, except possibly the last one (which is).

Is a complete tree balanced?
* Yes. If it is complete, then the left and right subtrees are also complete,
  and those two subtrees have height difference <=1.

Is the Man Who Is Tall Happy?
* He is 92% happy.

What must be true of perfect trees but not others?
* Perfect trees must have all full levels.
================================================


C'EST POSSIBLE?
------------------------------------------------
< your explanation of whether the tree reconstruction challenge given in class
is achievable or not >
Yes. Here's the tree:
             E
              \
               G
              /
             D
            / \
           K   I
              / \
             N   L
                / \
               O   W
Explanation: From the pre-order list we can determine which vertex is at the
top in almost every case. We know E is the root, and we see E has no left
subtree from the in-order case. Then, we look at the next vertex in the pre-
order list, and we can determine that everything in between the last placed
vertex and its position in the in-order list is in the left subtree, and the
rest is in the right subtree. And we can repeat that until we go through every
vertex.
================================================

