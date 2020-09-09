Question: Find sum of nodes in the path from root to all leaf of a tree.

example: ip: 6		output: 12(6+4+2),15(6+4+5),21,23
	    /  \
	   4	 8
	  / \	/ \
	 2   5 7   9
	 
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
public class Tree{
    static Node root=null;
    public static void main(String args[]){
        Tree t=new Tree();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            t.addNode(new Node(sc.nextInt()));
        }
       addPath(root,0);
    }
    //Function to get sum of all path from root of node to leaf.
    /*The mistake which i did was, in cases where we need to traverse both left and right child separtely with no relation amnong them,
        then function return type should not be int , it must be void.
        -------------------------------------------------------------------------------------------------------------------------------------------
    */
    static void addPath(Node root, int sum){
        if(root.left!=null)//if left of node is not null then add its value to sum.
            addPath(root.left,sum+root.key);
        if(root.right!=null)//if right of node is not null then add its value to sum.
            addPath(root.right,sum+root.key);
        if(root.left==null&&root.right==null)//if a leaf node is encountered then return the sum thus obtanied with current value of root since this was not added in above function call.
            System.out.println(sum+root.key);
    }
    /*
    ----------------------------------------------------------------------------------------------------------------------------------------------
    Below function is to add node to the tree*/
    void addNode(Node newNode){
        if(root==null){
            root=newNode;
        }
        else{
            Node x = root;
            if(x.key>=newNode.key){
                if(x.left==null){
                    x.left=newNode;
                }
                else{
                    x=x.left;
                    check(x,newNode);
                }
            }
            else{
                if(x.right==null){
                    x.right=newNode;
                }
                else{
                    x=x.right;
                    check(x,newNode);
                }
            }
        }
    }
    void check(Node x,Node newNode){
        while(x!=null){
            if(x.key>=newNode.key){
                if(x.left==null){
                    x.left=newNode;
                    break;
                }
                else
                    x=x.left;
            }
            else{
                if(x.right==null){
                    x.right=newNode;
                    break;
                }
                else
                    x=x.right;
            }
        }
    }
}
