#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: yes
#preorder traversal gives the roots. The nodes in the left and right side of a particular node in inorder #traversal array give the children of that node. By looping through the preorder array and for each root in #this array, we can recurse to the right and left side of the inorder array forming the nodes.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    curr=0
    def rec_build(self,preorder,inorder,low,high,D):
        if(low>high):
            return None
        #create new node called root
        print(self.curr)
        root=TreeNode()
        root.val=preorder[self.curr]
        self.curr+=1
        root.left=self.rec_build(preorder,inorder,low,D[root.val]-1,D)
        if(root.left==None):
            self.curr-=1
        self.curr+=1
        root.right=self.rec_build(preorder,inorder,D[root.val]+1,high,D)
        if(root.right==None):
            self.curr-=1
        return root
        
        
        
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        D={}
        for i in range(len(inorder)):
            D[inorder[i]]=i
        return self.rec_build(preorder,inorder,0,len(preorder)-1,D)
