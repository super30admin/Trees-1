# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder==None or len(preorder)==0:
            return
        
        rootVal=preorder[0]
        root=ListNode(rootVal)
        idx=-1
        for i in range (0,len(inorder)):
            if inorder[i]==rootVal:
                idx=i
        
        inleft=inorder[0:idx]
        inright=inorder[idx+1:len(inorder)]

        preleft=preorder[1:idx+1]
        preright=preorder[idx+1:len(preorder)]

        root.left=self.buildTree(preleft,inleft)
        root.right=self.buildTree(preright,inright)

        return root
        