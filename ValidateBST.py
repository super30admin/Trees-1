# time complexity is o(n), where n is the number if nodes in the tree
# space complexity is o(h), where h is the height of the tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    # sums = 0 
    def isValidBST(self, root: Optional[TreeNode]) -> bool:   
        self.prev = None
        # self.flag = False
        # self.traverse(root)
        return self.traverse(root)
    def traverse(self, root):
        if(not root):
            return True
        if (not self.traverse(root.left) ):
            return False
        if(self.prev and self.prev.val >= root.val):
            return False
        self.prev = root
        # right = self.traverse(root.right)
        return self.traverse(root.right)
    
    #iterative
    # st = list()
    #     while(root != None or len(st) != 0):
    #         while(root != None):
    #             st.append(root)
    #             root = root.left
    #         root = st.pop()
    #         if(self.prev != None and self.prev.val >= root.val):
    #             return False
    #         self.prev = root
    #         root = root.right
    #     return True
        



        
        