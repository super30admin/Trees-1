# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
#         result=[]
#         if len(preorder)==0: return 
#         rootval=(preorder[0])
#         root=TreeNode(rootval)
#         # result.append(root)
#         idx=-1
#         for i in range(len(inorder)):
#             if rootval==inorder[i]:
#                 idx=i
#         inorder_left=inorder[:idx]
#         inorder_right=inorder[idx+1:]
#         preorder_left=preorder[1:1+idx]
#         preorder_right=preorder[1+idx:]
#         root.left = self.buildTree(preorder_left,inorder_left)
#         root.right = self.buildTree(preorder_right,inorder_right)
#         return root
# Time Complexity: O(n)
# Space Complexity: O(n)
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder)==0: return None
        self.idx=0
        self.in_map=dict()
        for i in range(len(inorder)):
            self.in_map[inorder[i]]=i
        return self.helper(preorder,0,len(inorder)-1)
    def helper(self,preorder: List[int],start:int,end:int):
        if start > end: return
        rootval=preorder[self.idx]
        rootIdx=self.in_map[rootval]
        self.idx+=1
        # print(rootval)
        root=TreeNode(rootval)
        root.left= self.helper(preorder,start,rootIdx-1)
        root.right=self.helper(preorder,rootIdx+1,end)
        # print(root)
        return root
        
        
        
            
        