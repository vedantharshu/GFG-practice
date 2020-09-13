Question: Check if given tree is sumTree or not?
Sum Tree: a tree is sum tree if all root's sum = sum of all its child in left and right sub tree.\
example:
      	  26
        /   \
      10     3
    /    \     \
  4      6      3
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
class Node{
    Node left,right;
    int key;
    Node(int data){
        left=null;
        right=null;
        key=data;
    }
}
public class SumTree{
    static Node root=null;
    public static void main(String args[]){
        SumTree t=new SumTree();
        root=new Node(26);
        root.left=new Node(9);
        root.right=new Node(3);
        root.right.left=new Node(4);
        root.left.left=new Node(6);
        root.left.right=new Node(2);
        root.left.right.right=new Node(2);
        
        System.out.print(t.sumTree(root));
    }
    boolean sumTree(Node root){
        if(root==null||(root.left==null&&root.right==null))//first of all reach the end of the tree
            return true;
        if(sumTree(root.left)&&sumTree(root.right)){//if end is reached
            int sum=add(root.left,root.right);//calculate sum of left and right node of the tree.
            if(sum==0)//if root is leaf node then sum will be 0. Since all leaf node are Sum Tree so return true;
                return true;
            if(sum==root.key){//if sum of left and right is equal to root then then increment root data to its twice, so that higher level 					of the tree can use the calculated sum of the lower level
                root.key+=sum;
                return true;
            }
                return false;//if sum of left and right node is not equal to root then the property of sumTree is not satisfied so return 				false.
        }
        return false;
    }
    int add(Node a,Node b){
        int s=0;
        if(a!=null)
            s=s+a.key;
        if(b!=null)
            s=s+b.key;
        return s;
    }
}
