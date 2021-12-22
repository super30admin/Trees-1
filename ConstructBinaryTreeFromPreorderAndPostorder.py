#Time Complexity - O(n)
#Space Complexity - O(Height of the tree)
# Problem successfully executed on leetcode
# Had to take min and max NULL at first in order to incorporate the logic for edge cases nodes such as INT_MIN and INT_MAX values.

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder== None or inorder==None or len(preorder)==0:
            return None
        root=TreeNode(preorder[0])
        mid=inorder.index(root.val)
        
        root.left=self.buildTree(preorder[1:mid+1],inorder[:mid])
        root.right=self.buildTree(preorder[mid+1:],inorder[mid+1:])
        return root
        
        
        
        
        
        

