# Time complexity: O(n)
# Space complexity: O(logn)
# Works on leetcode: yes
# Approach: To construct the tree, we get root from the front of preorder list and get index of root from
# inorder list.We then recurse with the inorder list split using the index.
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        preorder = collections.deque(preorder)
        
        def helper(preorder, inorder):
            if inorder:
                rootval = preorder.popleft()
                root = TreeNode(rootval)
                ind = inorder.index(rootval)
                root.left = helper(preorder, inorder[:ind])
                root.right = helper(preorder, inorder[ind+1:])
                return root
        ans = helper(preorder, inorder) 
        return ans