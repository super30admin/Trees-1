# Time Complexity : O(n), where n is the no of elements in the array 
# Space Complexity : O(n), as we have created a HashMap.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class TreeNode:
    def __init__(self,x):
        self.x = x 
        self.left = None 
        self.right = None 

class Solution:
    # Time = O(n) | O(h) space where h is the height of the tree.
    # def buildTree(self,preorder,inorder):
    #     if not preorder or not inorder:
    #         return None 

    #     return index
    #     # indx = inorder.index(preorder.pop(0))
    #     # root = TreeNode(inorder[indx])
    #     # root.left = self.buildTree(preorder,inorder[0:indx])
    #     # root.right = self.buildTree(preorder,inorder[indx+1:])
    #     # return root
    
    index = 0
    d = {}
    # Time = O(n) time | O(n) space.
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None 
        for i in range(len(inorder)):
            self.d[inorder[i]] = i 
        return self.helper(preorder,inorder,0,len(inorder)-1)
    
    def helper(self,preorder,inorder,start,end):
        # Edge case 
        if self.index == len(inorder) or start > end:
            return None 
        
        #Logic 
        root = TreeNode(preorder[self.index])
        self.index += 1 
        indx = self.d[root.val]
        root.left = self.helper(preorder,inorder,start,indx-1)
        root.right = self.helper(preorder,inorder,indx+1,end)
        return root

if __name__=="__main__":
    s = Solution()
    pre = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    res = s.buildTree(pre,inorder)
    print(res)