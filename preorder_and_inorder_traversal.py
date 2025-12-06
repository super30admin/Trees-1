# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

#Time Complexity- O(n2), Space Complexity- O(n2)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
            self.value = val
            self.left = left
            self.right = right

class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]):

        if not preorder:
             return None
        # finding the root- in preorder the sequence is root -> left -> right
        root_val = preorder[0]
        # finding the index of the root in inorder list
        root_idx = inorder.index(root_val)
        # finding the left subtree
        in_left = inorder[:root_idx]
        # finding the right subtree
        in_right = inorder[root_idx+1:]
        # finding the left subtree in preorder. starting from 1 because at 0th position root is present and adding 1 to len(...) because we want all elements and last element is exclusive. 
        pre_left = preorder[1:1+len(in_left)]
        # finding the right subtree in preorder. adding one 1 to the existing half till last index
        pre_right = preorder[1+len(in_left):]

        # calling the TreeNode to create a new node in the tree
        root = TreeNode(root_val)
        # recursivly calling the function
        root.left = self.buildTree(pre_left,in_left)
        root.right = self.buildTree(pre_right, in_right)
        # return the root which is the pointer to all other nodes
        return root
    

def printTree(root):
    if not root:
        return
    printTree(root.left)
    print(root.value, end=" ")
    printTree(root.right)

solution = Solution()
root = solution.buildTree([3,9,20,15,7],[9,3,15,20,7])
printTree(root)

        
        
         


