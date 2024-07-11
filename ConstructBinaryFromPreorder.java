import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryFromPreorder {
    static int index; //index covering all values in preorder array
    static HashMap<Integer, Integer> map; //store inorder values
    public static TreeNode buildTreeHashMap(int[] preorder, int[] inorder) { //O(n) S.C
        if(preorder.length == 0) return null;

        map = new HashMap<>();
        for(int i=0; i<preorder.length; i++) {
            map.put(inorder[i], i); //insert inorder values and their indices
        }

        return buildTreeRecursion(preorder, 0, preorder.length-1);
    }

    static TreeNode buildTreeRecursion(int[] preorder, int start, int end) { //O(n) T.C

        if(start > end) return null; //if start pointer crosses end pointer

        int root = preorder[index]; //find root each time at incremented index
        index++;

        TreeNode tree = new TreeNode(root);

        int rootIndex = map.get(root); //find the root index from inorder array

        tree.left = buildTreeRecursion(preorder, start, rootIndex-1); //perform recursion on left side of root
        tree.right = buildTreeRecursion(preorder, rootIndex+1, end); //perform recursion on right side of root

        return tree;
    }

    public static TreeNode buildTreeArrays(int[] preorder, int[] inorder) { //O(n*n) T.C, O(1) S.C
        if(preorder.length == 0) return null;

        int rootIndex = -1;
        int root = preorder[0]; //first element in preorder array is always root value
        int length = inorder.length;
        TreeNode tree = new TreeNode(root); //root node

        for(int i=0; i<length; i++) {
            if(inorder[i] == root) {
                rootIndex = i; //find root index in inorder array
                break;
            }
        }

        //In inorder array, from 0 to root-index is the left side of tree
        int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        //From root+1 to end is the right side of tree
        int[] inOrderRight = Arrays.copyOfRange(inorder, rootIndex+1, length);
        //In preorder array, from second element to length of root-index value is left side of tree
        //Root-index value is nothing but length of inOrder calculated above
        int[] preOrderLeft = Arrays.copyOfRange(preorder, 1, inOrderLeft.length+1);
        //Similarly, from root-indexed value in inorder + 1 to end is right side of tree
        int[] preOrderRight = Arrays.copyOfRange(preorder, inOrderLeft.length+1, length);

        tree.left = buildTreeArrays(preOrderLeft, inOrderLeft); //recurse to find all left children
        tree.right = buildTreeArrays(preOrderRight, inOrderRight); //find all right children

        return tree;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};

        TreeNode resultHashmap = buildTreeHashMap(preorder, inorder);
        assert resultHashmap != null;
        System.out.println("The binary tree from using hashmap and pointers is: ");
        printTreeAsArray(resultHashmap);

        TreeNode resultArray = buildTreeArrays(preorder, inorder);
        System.out.println("The binary tree from using arrays deep copy is: ");
        printTreeAsArray(resultArray);
    }

    // Method to print the tree as an array representation
    static void printTreeAsArray(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls to match the array representation
        while (result.getLast() == null) {
            result.removeLast();
        }

        System.out.println(result);
    }
}