
# Iterative Approach 
# // Time Complexity : O(H)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        st = []
        prev = None
        
        while(root != None or st != []):
            while(root != None):
                st.append(root)
                root = root.left
                
            root = st.pop()
            if prev != None and prev.val>= root.val:
                return False
            prev = root
            root = root.right
            
        return True
            
            
        