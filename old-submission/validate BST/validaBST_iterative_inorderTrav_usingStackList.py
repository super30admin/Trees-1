# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        flag = True
        
        previous = None
        
        # Create the recursive-stack
        stack = []
        
        while root != None or len(stack) != 0:
            
            # Push everything to the stack
            # inorder(root.left)
            
            while root != None:
                stack.append(root)
                root = root.left
                continue
            
            # pop from the stack
            root = stack.pop() #1,5,3
            
            # compare root with previous
            if previous != None and previous.val >= root.val:
                # Invalid case
                
                flag = False
                break
            
            # Update previous to root
            previous = root #1,5
            
            # Update the root to right
            # inorder(root.right)
            root = root.right
            
            continue
        
        return flag