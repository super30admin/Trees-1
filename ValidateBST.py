// Time Complexity : O(no. of Nodes)
// Space Complexity : O(no. of Nodes)
// Did this code successfully run on Leetcode : Yes 
// // Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root is None:
            return True
        stack=[]
        ret=[]
        curr=root
        prev=float("-inf")
        while curr or len(stack): # inorder traversal
            while curr:
                stack.append(curr)
                curr=curr.left
            curr=stack.pop()
            if prev>=curr.val: #check previous with previous element
                return False #since inorder traversal , the tree will not be BST if node's value is lesser than current values
            prev=curr.val
            curr=curr.right
        return True #else return True i.e valid Tree 