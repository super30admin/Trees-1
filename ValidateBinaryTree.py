  ---------------------- Validate Binary Search Tree------------------------------------------------   
# Time Complexity : O(N) N is the number of nodes.
# Space Complexity : O(N) N is the number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I took a left and right minimum and maximum number and comparing it with the elements. The base condition would be if the  node is none, then return True
# Then we will compare the left minimum  with root node and right too. As per the BST properties, the left node should be on the less than the root and right node should be greater than the root.
# So we will check this conditions if these are False the directly return False, Else we are recurring this for all the nodes. 


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        def dfs(root, l, r):
            if not root:
                return True
            
            if l>=root.val or r<=root.val:
                return False
            
            
            return dfs(root.left, l, root.val) and dfs(root.right, root.val, r)
        
        return dfs(root, float('-inf'), float('inf'))
                