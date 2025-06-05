# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity - o(n)
# Time Complexity - o(n) 

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        idx = 0

        hashTb = {}
        n = len(inorder)
        for i in range(n):
            if inorder[i] not in hashTb:
                hashTb[inorder[i]] = i

        def helper(preorder,hashTb,s,e):
            nonlocal idx
            if s>e:
                return None

            root_val = preorder[idx]
            idx+=1
            root = TreeNode(root_val)
            in_idx = hashTb[root_val]
            
            root.left = helper(preorder,hashTb,s,in_idx-1,)
            root.right = helper(preorder,hashTb,in_idx+1,e)

            return root

        return helper(preorder,hashTb,0,n-1)