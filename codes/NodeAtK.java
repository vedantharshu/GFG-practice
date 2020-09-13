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
public class NodeAtK{
    static Node root=null;
    public static void main(String args[]){
        NodeAtK t=new NodeAtK();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            t.addNode(new Node(sc.nextInt()));
        }
        int k=sc.nextInt();
        nodeAtk(root,k);
    }
    /*
    Function to find the nodes at k distance from the root
    */
    static void nodeAtk(Node root, int k){
        if(k==0)
            System.out.println(root.key);
        if(root.left!=null)
            nodeAtk(root.left,k-1);
        if(root.right!=null)
            nodeAtk(root.right,k-1);
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
