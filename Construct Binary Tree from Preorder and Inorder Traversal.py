# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

#Optimized
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



#
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        return root
        