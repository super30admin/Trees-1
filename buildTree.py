# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """   
    Description: Given preorder and inorder traversal of a tree, construct the binary tree.
    
    Approach (alternative):
    1. Start with first element of given preorder list as root node
    2. Get index of the element with same value as in #1 
    3. Split the values in left and right or both preorder and inorder lists
    4. Use the new lists to repeat the above until tree is built
    
    Approach (Optimal):
    1. create a hashmap using indices and values of the preorder traversal
    2. use start and end indices for each left and right subtree recursively to create a BST
    
    Time Complexicity: O(n)
    Space Complexicity: O(n) {O(n) for hash and O(n) for split right and left tree arrays}
    
    """
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        assert len(inorder) == len(preorder), "must have equal lengths"
        if len(preorder) == 0: return None
        
        self.idx = 0
        self.root_dict = {}
        for value, key in enumerate(inorder):
            self.root_dict[key] = value
        
        return self.helper(preorder, 0, len(preorder)-1)
    
    def helper(self, preorder, start, end):

        # Base
        if start > end: return None

        # Logic
        root_val = preorder[self.idx]
        root = TreeNode(root_val)
        self.idx += 1
        root_idx = self.root_dict[root_val]

        root.left = self.helper(preorder, start, root_idx - 1)
        root.right = self.helper(preorder, root_idx + 1, end)

        return root
        
    
    """ Alternative Solution:
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        # Time Complexicity: O(n^2)
        # Space Complexicity: O(n^2), where n is number of items in preorder/inorder list
        
        assert len(inorder) == len(preorder), "must have equal lengths"
        if len(preorder) == 0: return None

        root = TreeNode(preorder[0])
        pos = inorder.index(preorder[0])
        preleft_ = preorder[1:pos+1]
        preright_ = preorder[pos+1:len(preorder)]
        inleft_ = inorder[0:pos]
        inright_ = inorder[pos+1:len(inorder)]

        root.left = self.buildTree(preleft_, inleft_)
        root.right = self.buildTree(preright_, inright_)
        
        return root
    """       
