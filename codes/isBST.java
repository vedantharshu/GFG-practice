Question:
Given a binary tree. Check whether it is a BST or not.

Example 1:

Input:
    2
 /    \
1      3
Output: 1
Example 2:

Input:
  2
   \
    7
     \
      6
       \
        5
         \
          9
           \
            2
             \
              6
Output: 0
Your Task:
You don't need to read input or print anything. Your task is to complete the function isBST() which takes the root of the tree as a parameter and returns true if the given binary tree is BST, else returns false. The printing is done by the driver's code.

main code:-
The idea is to check the inorder traversal of the binary search tree and then it should be in increasing order.

public class Tree
{
    ArrayList<Integer> a =new ArrayList<>();
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)
        {
            // code here.
            check(root);
            if(a.size()==1)
                return true;
            for(int i=1;i<a.size();i++){
                if(a.get(i)<=a.get(i-1))
                    return false;
            }
            return true;
        }
    void check(Node root){
        if(root!=null){
            check(root.left);
            a.add(root.data);
            check(root.right);
        }
    }
}
