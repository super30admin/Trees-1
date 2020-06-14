import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int value;
    Node left;
    Node right;

    Node(int value)
    {
        this.value=value;
        this.left=null;
        this.right=null;
    }

    Node(int value,Node left, Node right)
    {
        this.value=value;
        this.left=left;
        this.right=right;
    }
}

public class validBST
{
    public static void main(String args[]) {
        // Assume -1 -1 to be null
        //int[] arr={5,1,2,-1,-1,4,5};
        int[] arr={5,1,4,-1,-1,3,6};
        validBST obj=new validBST();
        Node node=obj.makeTree(arr);
        //obj.traceTree(node);
        System.out.println(obj.checkBST(node));
    }

    public boolean checkBST(Node head)
    {
        Node traverse=head;
        Queue<Node> queue = new LinkedList<>();
        queue.add(traverse);

        while(!queue.isEmpty())
        {
            traverse=queue.poll();
            int rootV=traverse.value;
            if(traverse.left != null && traverse.right!=null)
            {
                int leftV=traverse.left.value;
                int rightV=traverse.right.value;

                if(leftV>rootV || rightV<rootV)
                    return false;

                queue.add(traverse.left);
                queue.add(traverse.right);
            }
        }

        return true;
    }

    public void traceTree(Node head)
    {
        Node traverse=head;
        Queue<Node> queue = new LinkedList<>();
        queue.add(traverse);
        while(!queue.isEmpty())
        {
            traverse=queue.poll();
            if(traverse!=null)
            {
            System.out.println(traverse.value);
            if(traverse.left!=null && traverse.right!=null)
            {
                queue.add(traverse.left);
                queue.add(traverse.right);
            }
           }
    }
    }

    public Node makeTree(int arr[])
    {
        Node head=new Node(arr[0]);
        Node traverse=head;
        int i=1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(traverse);
        while(i<arr.length)
        {
                traverse=queue.poll();
                traverse.left=new Node(arr[i]);
                if(i+1>=arr.length)
                    traverse.right=null;
                else
                    traverse.right=new Node(arr[i+1]);

                queue.add(traverse.left);
                queue.add(traverse.right);
                i+=2;
        }

        return head;
    }
}