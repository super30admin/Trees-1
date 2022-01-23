# // Time Complexity : O(n^2)
# // Space Complexity : O(n^2)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed approach from class
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #base case
        if not preorder:
            return None
        l = len(inorder)        
        i = 0

        while i < l and preorder[0] != inorder[i]:
            i += 1
        #creating a treenode to make the final tree
        root = TreeNode(inorder[i])
        #instead of using the variables for the parameteres using slicing to get the lists
                                    #preleft,       inleft
        root.left = self.buildTree(preorder[1:i+1], inorder[:i])
                                    #preright,      inright
        root.right = self.buildTree(preorder[i+1:], inorder[i+1:])
        return root