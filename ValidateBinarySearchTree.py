#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(h) i.e. h is the height of the tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/FSY8UFbnvgw
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    previous = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root)

    def inorder(self, root: TreeNode):
        #base case
        if(root==None):
            return True
        #calling for the left recursion 
        left = self.inorder(root.left)
        #st.pop()
        #rint("Up")
        #rint(root.val)
        #for the first node we avoid checking previous and we are checking the condition of the binary tree i.e if the previous element is greater than current root than the binary tree condition is bridge and thus we have to return invalid binary tree
        #placing this condition before call the right subpart of the tree will helf to avoid more traversal
        if self.previous!= None and self.previous.val>=root.val:
            return False
        #assinging the previous value here so that once right operation will take place the root will change and thus it will give wrong answer
        self.previous = root
        #rint("previous", self.previous)
        #calling the right recursion
        right = self.inorder(root.right)
        #rint("Down")
        #rint(root.val)
        return left and right
