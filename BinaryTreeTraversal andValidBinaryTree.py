
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: O(n)
# Space Complexity: 0(1)

'''
Taking minimum value as - infinity and maximum value as + infinity.
Performing the inorder Traversal
While traversing to the left the minimum value remains the same and the maximum value chnages as we traverse the tree
Similarly while traversing to the right of the root node, Maximum value remains the and the minimum value changes
Recursively calling the isValidBST finction adn if the output is in ascending order then it is a valid BST
'''

class Solution:
    def isValidBST(self, root: TreeNode, min = float('-inf'), max = float('inf')) -> bool:
        if not root:
            return True
        if(root.val>=max):
            return False
        if(root.val<=min):
            return False
        
        # 
        
    
        return self.isValidBST(root.left, min, root.val) and self.isValidBST(root.right, root.val, max)

    #****************************************************************************************

    # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Time Complexity: O(n)
# Space Complexity : O(1)

'''
Since preorder is root left right therefore the first element of the preorder list will be root
using the roort from preorder finding the root in the inorder traversal
Based on the root finding the rightinorder, left inorder, right pre order and left pre order
Recursively traversing on right side and the left side
'''


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if(len(inorder) ==0 or len(preorder)==0):
            return None
        
        leftin=[]
        rightin=[]
        leftpre = []
        rightpre = []
        
        root = TreeNode(preorder[0])
        indx = -1
        
        for i in range(len(inorder)):
            if(inorder[i] == preorder[0]):
                indx = i
                break
        leftin = inorder[:indx]
        rightin = inorder[indx+1:]
        leftpre = preorder[1:indx+1]
        rightpre = preorder[indx+1:]
        
        
        root.right = self.buildTree(rightpre, rightin)
        root.left = self.buildTree(leftpre, leftin)
        return root