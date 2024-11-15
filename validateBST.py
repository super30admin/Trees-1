# // Time Complexity : O(n), every node is visited only once
# // Space Complexity :O(h) due to recursion stack//o(logn) for balanced
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Base cases handling issues


# // Your code here along with comments explaining your approach
# We will use recursion to check left and right side of the node.
# Let us say node is on 13. left node bounds will be (-inf,13).
# right bound will be (13,inf). As long as the number is inbounds we can verify it.


# from typing import Optional
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# og solution
class Solution:                                                     #(-inf,13) and (13,inf) 
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root,float('-inf'),float('inf'))


    def helper(self,root,minVal:float,maxVal:float):
        if root == None:                                        # base case
            return True
        
        if root.val >= maxVal or root.val <= minVal:            # root.val beyond(-inf, inf)
            return False
        
        return self.helper(root.left,minVal,root.val) and self.helper(root.right,root.val,maxVal) # checks left first

# # using a flag(void bsed)
# class Solution:
#     def __init__(self):
#         self.prev = None                                    #need a prev node to keep track of last ancestor/dababy

#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         self.flag = True
#         self.helper(root)
#         return self.flag

#     def helper(self,root):
#         if root == None:                                    # root == None or not self.flag
#             return True

#         self.helper(root.left)

#         if self.prev != None and self.prev.val >= root.val: # 
#             self.flag = False
#             # return True -> faster? why 

#         self.prev = root
#         self.helper(root.right)

        
#boolean based recur
# class Solution:
#     def __init__(self):
#         self.prev = None

#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         return self.helper(root)                                    #return the helper itself

#     def helper(self,root):
#         if root == None:
#             return True

#         left = self.helper(root.left)
#         if self.prev != None and self.prev.val >= root.val:
#             return False
        
#         self.prev = root

#         right = self.helper(root.right)
        
#         return left and right                                       #calculate in the helper

#conditional recursion: BEST HERE FOR RUNTIME
# class Solution:
#     def __init__(self):
#         self.prev = None

#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         return self.helper(root)

#     def helper(self,root):
#         if root == None:
#             return True

#         left = self.helper(root.left)

#         if left == False:                                   #if out left has already found a breach, why do we check the right?
#             return False

#         if self.prev != None and self.prev.val >= root.val:
#             return False
        
#         self.prev = root

#         right = self.helper(root.right)

#         return left and right




    

# ---------------------------------------------------------------------
# helper to make a treenode 
# def build_tree(lst):
#     if not lst:
#         return None
#     root = TreeNode(lst[0])
#     queue = [root]
#     i = 1
#     while i < len(lst):
#         node = queue.pop(0)
#         if lst[i] is not None:
#             node.left = TreeNode(lst[i])
#             queue.append(node.left)
#         i += 1
#         if i < len(lst) and lst[i] is not None:
#             node.right = TreeNode(lst[i])
#             queue.append(node.right)
#         i += 1
#     return root

# Example usage

# root = build_tree([100,50,150,30,80,120,170,20,40,60,90,None,130,160,200]) 
# print(Solution().isValidBST(root)) # True
