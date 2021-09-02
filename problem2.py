#time-O(n**2) we have to reapeat for each node and then traverse in the pre array to find the order
#space-O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.preidx=0
        return self.helper(preorder,inorder,0,len(preorder)-1)
    def helper(self,preorder,inorder,s,e):
            #base case'
            if s>e:
                return None
            #construct a node with preorder id
            root=TreeNode(preorder[self.preidx])
            self.preidx=self.preidx+1
            #search the node in inorder
            inidx=s
            for i in range(s,e+1):
                if root.val==inorder[i]:
                    inidx=i
                    break
            #now split the tree from inorder idx to left and right tree
            root.left=self.helper(preorder,inorder,s,inidx-1)
            root.right=self.helper(preorder,inorder,inidx+1,e)
            return root
       
