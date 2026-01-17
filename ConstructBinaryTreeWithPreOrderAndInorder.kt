// In this problem, we are using inorder to store the index of elements in a map.
// Then we are using preorder to pick the root element and using the map to find the index of that element in inorder array to divide left and right subtrees.
//Time Complexity: O(N) where N is the number of nodes in the tree  
//Space Complexity: O(N) where N is the number of nodes in the tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    var idx = 0
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = HashMap<Int, Int>()

        for(i in 0..inorder.size - 1) {
            map.put(inorder[i], i)
        }
        this.idx = 0
        return helper(preorder, 0, preorder.size -1, map)
    }

    fun helper(preorder: IntArray, start: Int, end: Int, map: HashMap<Int, Int>) : TreeNode? {

        //base case
        if(start > end) return null;

        //logic
        val rootVal = preorder[idx] 
        idx++

        val rootIndx : Int = map.get(rootVal)!!

        val root = TreeNode(rootVal)

        root.left = helper(preorder, start, rootIndx - 1, map)
        root.right = helper(preorder, rootIndx + 1, end, map)

        return root
    }
}