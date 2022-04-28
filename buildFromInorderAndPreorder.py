# Time complexity -> O(n^2)
# Space complexity -> O(n^2)

class Solution:
    hashMap = {}
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder== None or inorder==None or len(preorder) == 0:
            return None

        for i in range(len(inorder)):
            self.hashMap[inorder[i]] = i
            
        return self.helper(preorder,0, len(preorder)-1)
                
    def helper(self,preorder,start,end):
        if start>end:
            return None

        rootVal = preorder[self.idx]
        root = TreeNode(val = rootVal)
        self.idx += 1
        
        root.left = self.helper(preorder, start,self.hashMap[rootVal]-1)
        root.right = self.helper(preorder,self.hashMap[rootVal]+1, end)
        
        return root
        
    
# # Time complexity -> O(n^2)
# # Space complexity -> O(n^2)

# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
#         if preorder== None or inorder==None or len(preorder) == 0:
#             return None
        
#         root = TreeNode(val=preorder[0])
#         rootIndx = -1
#         for i in range(len(inorder)):
#             if inorder[i] == root.val:
#                 rootIndx = i
#                 break
                
#         preLeft = preorder[1:rootIndx+1]
#         preRight = preorder[1+rootIndx:]
#         inLeft = inorder[:rootIndx]
#         inRight = inorder[rootIndx+1:]
        
#         root.left = self.buildTree(preLeft, inLeft)
#         root.right = self.buildTree(preRight, inRight)
        
#         return root