# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#validate BST using stack, traversing left child first then right child of a node
#Time Complexity:O(N)
#Space complexity:O(H), H is the height of the tree
#if it is a perfectly balanced bst then O(log N)
"""

approach 1 

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None: return True
        prev=None
        st=[]
        while st and root:
            while root is not None:
                st.append(root.val)
                root=root.left
            root=st.pop()
            if(prev !=None and prev<= root):
                return False
            prev=root
            root =root.right
        return True  
   #recursive approach with valid range, comparing root.val with low value and high value. 
   #time complexity: O(N)
   #space complexity:O(N)
"""
class Solution:
    def isValidBST(self, root)->bool:
        def helper(root, low=float("-inf"), high= float("inf")):
            if root is None: return True
            if root.val <= low or root.val>=high:
                return False
            return (helper(root.left, low, root.val)and helper(root.right, root.val, high))
        return helper(root)


    
    

             

        
        
