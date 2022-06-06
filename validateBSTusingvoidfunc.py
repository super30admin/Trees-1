#Time Complexity : O(n)
#Space Complexity: O(n) where n -> height of tree
#Did your code run on leetcode : yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isvalid = False
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = -math.inf
        global isvalid
        isvalid = True
        self.inorder(root)
        return isvalid
    
    
    def inorder(self, root: Optional[TreeNode])->None:
        if root == None : return
        
        self.inorder(root.left)
        print("up")
        print(root.val)
        global isvalid



        if(self.prev >= root.val):
            isvalid = False
        
        self.prev = root.val
        self.inorder(root.right)
        print("down")
        print(root.val)
