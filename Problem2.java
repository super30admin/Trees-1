import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    public TreeNode() {
    }

    // Constructor that initializes the node with a value
    public TreeNode(int val) {
        this.val = val;
    }

    // Constructor that initializes the node with a value, left child, and right child
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    class Problem2 {
        Map<Integer,Integer> inOrderMap ;
        int indx = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inOrderMap = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                inOrderMap.put(inorder[i],i);
            }
            //return buildTreeHelper(preorder,inorder);
            return buildTreeOptimized(preorder,0,inorder.length-1);
        }

        // SC : O(2N^2) = O(N^2) making 2n copies of array n times
        // TC : O(N^2)
        public TreeNode buildTreeHelper(int[] preorder, int[] inorder) {
            // base condition
            if(preorder.length==0 || inorder.length==0 ){
                return null;
            }

            int rootVal = preorder[0];
            int rootIndex = -1;
            //finding index of root in inorder array
            //O(N) to find the root
            for(int i=0;i<inorder.length;i++){
                if( inorder[i] == rootVal){
                    rootIndex= i;
                    break;
                }
            }
            TreeNode root = new TreeNode(rootVal);
            //left of root in inorder is left child
            // 0 to rootIndex-1

            // each of getting copy of this array takes O(2N) time complexity
            // SC : O(2N^2) = O(N^2) making 2n copies of array n times
            int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
            //right of root in inorder is right child
            //rootIndex +1 to inorder.length-1

            int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
            int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length+1);
            int[] preorderRight = Arrays.copyOfRange(preorder, inorderLeft.length+1, preorder.length);

            root.left = buildTreeHelper(preorderLeft,inorderLeft);
            root.right = buildTreeHelper(preorderRight,inorderRight);

            return root;

        }

        //TC: O(N)
        //SC : O(N)
        public TreeNode buildTreeOptimized(int[] preorder,int st,int end) {
            // base condition
            if(end<st ){
                return null;
            }

            int rootVal = preorder[indx];

            int rootIndex = inOrderMap.get(rootVal);

            TreeNode root = new TreeNode(rootVal);
            this.indx ++;
            root.left = buildTreeOptimized(preorder,st,rootIndex-1);
            root.right = buildTreeOptimized(preorder,rootIndex+1,end);

            return root;

        }

    }