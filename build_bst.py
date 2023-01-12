# Time Complexity :
# O(N^2)

# Space Complexity :
# O(N^2)

# Did this code successfully run on Leetcode :
#Yes

#The first element of the pre order is the root of the tree. We then look for this element in the inorder list. Everything to the left of this in the inorder is the leftsubtree and right of the root in the inorder is the right subtree.
#We then recursively call buildtree on these left and right preorder and inorder lists

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 0 :
            return None
        root_val = preorder[0]
        root_inorder_idx = inorder.index(root_val)

        root =  TreeNode(root_val)

        inorder_left = inorder[:root_inorder_idx]
        inorder_right = inorder[root_inorder_idx+1:]
        preorder_left = preorder[1:len(inorder_left)+1]
        preorder_right = preorder[len(inorder_left)+1:]

        root.left = self.buildTree(preorder_left,inorder_left)
        root.right = self.buildTree(preorder_right,inorder_right)
        return root 
