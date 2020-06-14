import java.util.LinkedList;
import java.util.Queue;
// THe funciton is named checkBST , please give me feedback for my approach
// I chose a recursive min max approach which uses a helper function.
// It checks left and right subtree recursively while maintaining min and max values
// Time Complexity : O(n) where n= all values in the array 

// Space Complexity : O(n) where at any given time there might be N total functions in the Stack

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
        int[] arr={5,1,7,-1,3,6,8};
        validBST obj=new validBST();
        Node node=obj.makeTree(arr);
       // obj.traceTree(node);
        System.out.println(obj.checkBST(node));
    }

    public boolean checkBST(Node head)
    {
        Node traverse=head;
        return checkBST_helper(traverse,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST_helper(Node traverse, int min, int max)
    {
        if(traverse==null)
            return true;
        
        int value=traverse.value;
        if(value<min || value>max)
        {
            System.out.println("Returning false for value "+value+ " min "+min+" max "+max);
            return false;
        }
        return checkBST_helper(traverse.left, min, value-1) && checkBST_helper(traverse.right, value+1, max);
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