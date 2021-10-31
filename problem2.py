#Time complexity O(n) and space complexity O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    p=0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        map={}
        #Finding the index in inorder
        for i in range(len(inorder)):
            map[inorder[i]]=i
            
        return self.helper(preorder,0,len(preorder)-1,map)
   
#Creating a root node for each index corresponding in the preorder
    def helper(self,preorder,s,e,map):
        if s>e:
            return None

        idx = map[preorder[self.p]]
        root = TreeNode(preorder[self.p])
        self.p+=1
        root.left = self.helper(preorder,s,idx-1,map)
        root.right =self.helper(preorder,idx+1,e,map)
        
        return root
