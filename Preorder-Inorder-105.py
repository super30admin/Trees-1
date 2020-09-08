
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        def helper(preS, inS, inEnd, inorder, preorder):
            if preS > len(preorder) - 1 or inS > inEnd:
                return None
            
            index_root = TreeNode(preorder[preS])
            idx = 0
            for i in range(inS, inEnd+1):
                if inorder[i] == index_root.val:
                    idx = i
            
            index_root.left = helper(preS + 1, inS, idx - 1, inorder, preorder)
            index_root.right = helper(preS + idx -inS + 1, idx + 1, inEnd, inorder, preorder)
            return index_root
                    
                    
        return helper(0, 0, len(inorder)-1, inorder,preorder)
        