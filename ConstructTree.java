 // inorder - left - root - right
 // preorder - root - left - right 
 //Time Complexity : O(n)
//Space Complexity : O(n)


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructTree {
    static class Node {
        int key;
        Node left, right;
 
        // constructor
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;
    static Node prev;

    public static void main(String[] args)
    {
        int[] inorder = {3,9,20,15,7};
        int preorder[] = {9,3,15,20,7};
        Node temp = buildTree(inorder, preorder);


    }
    
    public static Node buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        map.put(inorder[i],i);
        return splitTree(preorder,map,0,0,inorder.length-1);
    }

    public static Node splitTree(int [] preorder,Map<Integer,Integer> map,int pix,int ileft,int iright)
    {
         int rval = preorder[pix];
        int mid = map.get(rval);
        Node root = new Node(rval);
        if(ileft < mid)
            root.left = splitTree(preorder,map,pix+1,ileft,mid-1);
        if(iright > mid)
            root.right = splitTree(preorder,map,pix+1+mid-ileft,mid+1,iright);
            return root;
    }
}
