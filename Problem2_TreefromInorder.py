#Time Complexity:
#Space Complexity: 
#Leetcode: Yes
class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None

        root = Node(preorder[0])
        mid = 0
        for i in range(len(inorder)):
            if inorder[i] == preorder[0]:
                mid = i
                break;
        
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        return root


inorder = [9,3,15,20,7]
preorder = [3,9,20,15,7]
obj = Solution()
obj.buildTree(preorder, inorder)