# Time Complexity : O(n), n is the number of nodes
# Space Complexity : O(H), height of the tree (for recursive stack)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
       if len(preorder)==0: return None


       rootval=preorder[0] #get root from preorder
       root=TreeNode(rootval) #make a new node
       rootidx=inorder.index(rootval) #find root in inorder
       inleft=inorder[:rootidx] #then split inorder to left and right sub arrays
       inright=inorder[rootidx+1:]
       preleft=preorder[1:len(inleft)+1] #cause preorder is root,left,right -> using len on inleft build preleft
       preright=preorder[len(preleft)+1:] #similary build #preright
       root.right=self.buildTree(preright,inright) #now recursively build the entire tree
       root.left=self.buildTree(preleft,inleft)
       return root
