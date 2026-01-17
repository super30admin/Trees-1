// In this problem, we are traversing the tree in in-order manner and checking if the previous node's value is less than the current node's value. If we find a breach we return false. 
//Time Complexity: O(N) where N is the number of nodes in the tree
//Space Complexity: O(H) where H is the height of the tree


class Solution {
    var prev : TreeNode? = null
    fun isValidBST(root: TreeNode?): Boolean {
        return helper(root)
    }

    fun helper(root: TreeNode?) : Boolean {

        //base
        if(root == null) return true

        if (!helper(root.left)) return false

        if(prev != null && prev!!.`val` >= root.`val`) return false
        
        prev = root
        return helper(root.right)
    }
}