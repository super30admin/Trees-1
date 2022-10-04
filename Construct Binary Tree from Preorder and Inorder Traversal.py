# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

#Optimized-1
# TC- O(n)
# SC - O(n)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        map_inorder = dict()
        for index, val in enumerate(inorder):
            map_inorder[val] = index
        return self.helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1, map_inorder)

    def helper(self, preorder, prestart, preend, inorder, instart, inend, map_inorder):
        if prestart > preend or instart > inend:
            return None
        rootVal = preorder[prestart]
        rootidx = map_inorder[rootVal]
        root = TreeNode(rootVal)
        num_left = rootidx - instart
        root.left = self.helper(preorder, prestart + 1, prestart + num_left, inorder, instart, rootidx - 1, map_inorder)
        root.right = self.helper(preorder, prestart + num_left + 1, preend, inorder, rootidx + 1, inend, map_inorder)
        return root

#Optimized-2
# TC - O(n)
# SC - O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
    
        def helper(start, end):
            nonlocal preIdx
            #base
            if start > end:
                return None

            #logic
            rootVal = preorder[preIdx]
            root = TreeNode(rootVal)
            preIdx += 1
            root.left = helper(start, map[rootVal]-1)
            root.right = helper(map[rootVal]+1,end)
            return root
        
        if len(preorder) == 0 or preorder == None:
            return None
        
        map = {}
        preIdx = 0
        for idx,val in enumerate(inorder):
           map[val] = idx
        return helper(0, len(preorder)-1)




#brute Force
# TC- O(n^2)
# SC - O(n^2)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        idx = -1
        
        for i in range(0,len(inorder)):
            if inorder[i] == rootVal:
                idx = i
                break
        inLeft = inorder[:idx]
        preLeft = preorder[1:idx+1]
        inRight = inorder[idx+1:]
        preRight = preorder[idx+1:]
        root.left = self.buildTree(preLeft,inLeft)
        root.right = self.buildTree(preRight,inRight)
        
        return root