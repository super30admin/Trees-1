'''

Did  it run on leet code: Yes
Did you face any problems: Yes, how do we slice preorder array for left and right subtree

Time Complexity: 0(n2)
- 0(N) :To contruct tree
- 0(N): To search root in inorder array

Space Complexity: 0(N)

Algorithm:

- The first node in preorder traversal is always a root.
- The elements left and right to a node in inorder traversal are its left subtree and right subtree
- Recursively repeated this process
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        
        if len(preorder) == 0:return None
        root_node = TreeNode(preorder[0])
        j = inorder.index(root_node.val)
        root_node.left  = self.buildTree(preorder[1:j+1],inorder[0:j])
        root_node.right = self.buildTree(preorder[j+1:],inorder[j+1:])
        return root_node
        