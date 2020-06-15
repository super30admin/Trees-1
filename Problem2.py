# Time Complexity : O(n), where n is the no of elements in the array 
# Space Complexity : O(n), recurisve heap from the root node
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class TreeNode:
    def __init__(self,x):
        self.x = x 
        self.left = None 
        self.right = None 

class Solution:
    def buildTree(self,preorder,inorder):
        if not preorder or not inorder:
            return None 
        indx = inorder.index(preorder.pop(0))
        root = TreeNode(inorder[indx])
        root.left = self.buildTree(preorder,inorder[0:indx])
        root.right = self.buildTree(preorder,inorder[indx+1:])
        return root

if __name__=="__main__":
    s = Solution()
    pre = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    res = s.buildTree(pre,inorder)