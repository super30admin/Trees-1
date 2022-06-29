# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.preOrderIndex = 0;
        self.inorderhash = {}
        for index,val in enumerate(inorder):
            self.inorderhash[val] = index
        return self.build(preorder,inorder,0,len(inorder)-1)
    def build(self, preorder: List[int], inorder: List[int],start,end):
        
        #base
        if start >end:
            return
        
        #rec
        val = preorder[self.preOrderIndex]
        index = self.inorderhash[val]
        self.preOrderIndex += 1
        
        root = TreeNode(val)
        root.left = self.build(preorder,inorder,start,index-1)
        root.right = self.build(preorder,inorder,index+1,end)
        
        return root
