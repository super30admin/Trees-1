https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Given preorder and inorder traversal of a tree, construct the binary tree.



Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7

Approach 1:
// In this we are creating an 4 subarrays and then calling the same recursive function again by passing an subarrays 
// because it is a repeated sub problem
// In this we are first finding an root index based on the preorder's first element and based on that we are dividing the array into subarrays and calling the function again
// Time Complexity : O(n2) -> we are iterating to find a root index 
// Space Complexity : O(h2) -> Stack space and subarrays
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base condition
        if(preorder==null || preorder.length==0 || inorder.length == 0){
            return null;
        }
        //Finding an rootindex in inorder array
        int rootIndex=-1;
        int rootValue=preorder[0];
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootValue){
                rootIndex=i;
                break;
            } 
        }
        //once we have the rootindex we are dividing an array into subarray based on that rootindex
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder,1,rootIndex+1);
        int[] preorderRight = Arrays.copyOfRange(preorder,rootIndex+1,preorder.length);
        //Calling the recursive function for left and right subtree
        root.left=buildTree(preorderLeft,inorderLeft);
        root.right=buildTree(preorderRight,inorderRight);
        //returning root
        return root;
    }
}

//Approach 2: Optimal approach
// In this instead of traversing an array with for loop we are storing it in an Hashmap
// In this if the unique elements will not be there then it would not work as hashmap value may be overwritten
// Time Complexity : O(n)
// Space Complexity : O(n) for hashmap +O(h) for stackspace but if it's a skewed tree then it would be O(n) only
//                     O(n)+O(n) =O(2n) =O(n)
class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Best condition
        if(preorder==null || preorder.length==0 || inorder.length == 0){
            return null;
        }
        idx=0;
        map=new HashMap<>();
        //Hashmap insertion
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return constructTree(preorder,0,preorder.length-1);
    }
    public TreeNode constructTree(int[] preorder, int start, int end) {
        //base case
        if(start>end){
            return null;
        }
        int rootVal=preorder[idx];
        idx++;
        int rootIdx=map.get(rootVal);
        //Creating a node by passing it to Treenode (int val) constructor
        TreeNode root=new TreeNode(rootVal);
        //The start and end are refering to a inorder tree
        //Left call
        root.left = constructTree(preorder,start,rootIdx-1);
        //Right call
        root.right = constructTree(preorder,rootIdx+1,end);
        //Return root
        return root;
    }
}