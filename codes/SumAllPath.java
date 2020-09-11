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
public class SumAllPath{
    static Node root=null;
    public static void main(String args[]){
        SumAllPath t=new SumAllPath();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            t.addNode(new Node(sc.nextInt()));
        }
       System.out.println(addPath(root,0));
    }
    /*
    Function to find sum of all path from root to leaf
    */
    static int addPath(Node root, int sum){
        if(root==null)
            return 0;
        sum+=root.key;
        if(root.left==null&&root.right==null)
            return sum;
        return addPath(root.left,sum)+addPath(root.right, sum);
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
