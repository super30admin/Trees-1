# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    ### THIS CODE DOES NOT WORK IN LEETCODE BUT WORKS IN MY LOCAL PYTHON ENVIRONMENT ###
    Time Complexicity: O(n^2)
    Space Complexicity: O(n^2)
    Where n is number of items in preorder/inorder list
    
    Description: Given preorder and inorder traversal of a tree, construct the binary tree.
    
    Approach:
    1. Start with first element of given preorder list as root node
    2. Get index of the element with same value as in #1 
    3. Split the values in left and right or both preorder and inorder lists
    4. Use the new lists to repeat the above until tree is built
    
    """
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        assert len(inorder) == len(preorder), "must have equal lenghts"
        if len(preorder) == 0: return None

        root = TreeNode(preorder[0])
        pos = inorder.index(preorder[0])
        preleft_ = preorder[1:pos+1]
        preright_ = preorder[pos+1:len(preorder)]
        inleft_ = inorder[0:pos]
        inright_ = inorder[pos+1:len(inorder)]

        root.left = buildTree(preleft_, inleft_)
        root.right = buildTree(preright_, inright_)
        
        return root
