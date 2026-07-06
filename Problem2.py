#Problem 105. CONSTRUCT BINARY TREE FROM PREORDER AND INORDER TRAVERSAL
# TIME COMPELXITY: O (N) where N is the number of nodes
# SPACE COMPLEXITY: O (N) where N is the number of nodes


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        self.index=0
        inordermap={val:i for i,val in enumerate(inorder)}
        return self.helper(preorder,0,len(inorder)-1,inordermap)

    def helper(self,preorder,start,end,inordermap):
        if start>end:
            return None
        root_val=preorder[self.index]
        self.index+=1
        root=TreeNode(root_val)

        root_idx=inordermap[root_val]
        root.left=self.helper(preorder,start,root_idx-1,inordermap)
        root.right=self.helper(preorder,root_idx+1,end,inordermap)

        return root