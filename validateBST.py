#Time Complexity : O(n) where n is number of nodes in the tree
#Space Complexity : O(n) where n in the number of nodes in the tree

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: At each node, we check whether it falls between the lower and higher bound. Starting with root and lower as -infinity and higher as +infinity, we keep passing values down the tree, so when going to the left of the tree we pass node.val as higher bound because all elements on the left of the node must be smaller and when going to the right of the tree we pass node.val as lower bound because all elements on the right of that node must be greater. When we reach null nodes (i.e. children of leaf nodes) we pass True.

#Your code here along with comments explaining your approach


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        def check(node, l, h):
            #base case
            if not node:
                return True

            #check whether current node value lies between lower and upper bound.
            if l >= node.val or node.val >= h:
                return False

            #check left nodes of the tree
            if not check(node.left, l, node.val):
                return False
            #check right nodes
            if not check(node.right, node.val, h):
                return False

            return True

        if not root:
            return True
            
        return check(root, float("-inf"), float("inf"))
