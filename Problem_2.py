# // Time Complexity : O(n)
# // Space Complexity : O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.idx = -1
        self.hashMap = {val:idx for idx,val in enumerate(inorder)}

        def helper(left_idx,right_idx):
            
            if(left_idx > right_idx or self.idx >=len(inorder)):
                return None 
            self.idx += 1
            root = TreeNode(preorder[self.idx])

            inorder_idx = self.hashMap[root.val]

            root.left = helper(left_idx,inorder_idx - 1)
            root.right = helper(inorder_idx + 1,right_idx)



            return root

        root = helper(0,len(inorder)-1)

        return(root)
            
        