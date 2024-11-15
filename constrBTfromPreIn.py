# // Time Complexity :O(n) for nodes
# // Space Complexity :O(n)+h for recursion stack and hashmap
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :   I was incrementing hashmap inorder index incorrectly(i++)

# My approach should be popping an array while other is hashed
# // Your code here along with comments explaining your approach

# 1) with 2 pointers, a hashmap and Recursion
class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]) -> Optional[TreeNode]:
        inOrIdx = {j:i for i,j in enumerate(inorder)} # create a value:index hashmap

        def helper(start,end):

            #basecase
            if start > end:                     # pointer crosses end
                return None             
            #logic  
            root = TreeNode(preorder.pop(0))    # pop top element of preorder 
            idx = inOrIdx[root.val]          # find popped value index in hashmap
            
            root.left = helper(start,idx-1)     # recursion left
            root.right = helper(idx+1,end)      # recurison right
            return root                         # return every root 
        
        return helper(0,len(inorder)-1)


 
# 2) make subarrays on every recursion 
# # with recursion for O(n) runtime
# class Solution:
#     def buildTree(self, preorder: list[int], inorder: list[int]) -> Optional[TreeNode]:
            
#             #basecase
#             if not preorder or not inorder:             #if both emty its a leaf node
#                 return None
            
#             #logic
#             root = TreeNode(preorder[0])                #find root node
#             idx = inorder.index(preorder[0])            #find root node present in inorder
            
#             root.left = self.buildTree(preorder[1:idx+1],inorder[:idx])     #recursion left create subarray
#             root.right = self.buildTree(preorder[idx+1:],inorder[idx+1:])   #recursion right
#             return root