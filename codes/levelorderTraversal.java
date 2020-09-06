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
        t.inorder(root);
        System.out.println();
        t.levelorder(root);
    }
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
    void inorder(Node r){
        if(r==null)
            return;
            inorder(r.left);
            
            System.out.print(r.key+",");
            inorder(r.right);
    }
    void levelorder(Node r){
        Queue<Node> queue = new LinkedList<>();
        queue.add(r);
        Node y=r;
        while(!queue.isEmpty()){
            Node s=queue.remove();
            System.out.print(s.key+" ");
            if(s.left!=null){
                queue.add(s.left);
            }
            if(s.right!=null)
                queue.add(s.right);
        }
    }
}
