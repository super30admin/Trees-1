# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to set a two pointer start and end and pop the element from preorder based on traversal and limit the pointers in inorder.

class Solution:    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        d={}
        for i in range(0,len(inorder)):
            d[inorder[i]] = i
        print(d)
        return self.helper( preorder,d,0, len(inorder)-1)
    
    def helper(self, preorder,d,start, end ):
        print(start,end)
        if start>end:
            return None
        
        p=preorder[0]
        root=TreeNode(preorder.pop(0))
        rootidx=d[p]
        root.left=self.helper(preorder, d, start, rootidx-1)
        root.right=self.helper(preorder, d, rootidx+1, end)

        return root