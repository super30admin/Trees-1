# Leet code - 105
# time complexity -O(N)
#Space complexity=O(N)
# here the root becomes the preorder first value and we get the index using inorder. Anything left of index belongs to lleft and anything right of index belongs to right subtree. 



class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        #edge case
        if len(preorder)==0: return None
        
        root=TreeNode(preorder[0])
        index=-1
        for i in range(len(inorder)):
            if inorder[i]==root.val:
                index=i
                break
        preleft=preorder[1:index+1]
        preright=preorder[index+1:len(preorder)]
        inleft=inorder[0:index]
        inright=inorder[index+1:len(inorder)]
        
        root.left=self.buildTree(preleft,inleft)
        root.right=self.buildTree(preright,inright)
        return root
            
        
