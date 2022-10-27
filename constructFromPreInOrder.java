package s30.trees.trees1;

import s30.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;


//Time Complexity O(n): n being the size of preOrder or inOrder array or the number of nodes
//Space Complexity O(h) height of the resultant tree, logn <= h <= n;

public class constructFromPreInOrder {
    private int preOrderIndex;
    private int[] preOrder, inOrder;
    private Map<Integer, Integer> numToIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex=0;
        this.preOrder = preorder;
        this.inOrder = inorder;

        numToIndex = new HashMap();

        for(int i=0; i< inOrder.length; i++){
            numToIndex.put(inOrder[i],i);
        }

        return buildTree(0,inorder.length-1);
    }

    private TreeNode buildTree(int  start, int end){
        //base
        if(end < start){
            return null;
        }

        //process
        int inOrderIndex = getIndex(inOrder,start, end, preOrder[preOrderIndex++]);


        TreeNode node = new TreeNode(inOrder[inOrderIndex]);
        // recurse
        node.left = buildTree(start, inOrderIndex-1);
        node.right = buildTree(inOrderIndex+1, end);

        return node;

    }

    private int getIndex(int[] inOrder,int start, int end, int ele){
        return numToIndex.get(ele);
    }
    public static void main(String[] args) {

    }
}
