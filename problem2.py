'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        idx = 0
        inorderMap = {}
        for i in range(len(inorder)):
            inorderMap[inorder[i]] = i

        def helper(start, end):
            # base
            if start > end: return None
            nonlocal preorder, idx, inorderMap
            rootVal = preorder[idx]
            idx += 1
            root = TreeNode(rootVal)
            rootIdx = inorderMap[rootVal]
            
            root.left = helper(start, rootIdx -1)
            root.right = helper(rootIdx + 1, end)
            return root

        return helper(0, len(inorder) - 1)