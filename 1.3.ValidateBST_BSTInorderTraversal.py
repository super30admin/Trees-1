# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    """
    Time Complexity: 0(h) -- where h is height of tree
    Space Complexity: 0(h) -- build recursive stack
    Approach: BST Inorder Traversal
    """

    def __init__(self):
        # self.inorderList = []
        
        self.previousEle = None
        self.flag = True
    
    def __inorder(self, node):
        
        # base
        if node == None:
            return

        # logic
        
        # go-left
        self.__inorder(node.left)
        
        if self.flag == False:
            return

        # add to the list
        if self.previousEle != None and self.previousEle >= node.val:
            # invalid case
            self.flag = False
            return 
        else:
            self.previousEle = node.val

        # perform chk
        # if len(self.inorderList) > 0 and self.inorderList[-1] >= node.val:
        #     # invalid -- we have a breech
        #     self.flag = False
        #     return           
        
        # else:
        #     self.inorderList.append(node.val)
        

        # go-right
        self.__inorder(node.right)

        if self.flag == False:
            return

        return

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        self.__inorder(root)

        return self.flag