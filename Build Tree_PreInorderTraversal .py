
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

#time complexity = O(N*N), index() --> O(N) and all elements of preorder are visited once
#space complexity = O(1)

class Solution(object):
    def buildTree(self, preorder, inorder):
        # EDGE CASE
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        
        # LOGIC
        root = TreeNode(preorder.pop(0))
        k = inorder.index(root.key)
        # list.index() ==> O(N) as it has to do a for loop over all elements in list

        root.left = self.buildTree(preorder, inorder[:k])
        root.right = self.buildTree(preorder, inorder[k+1:])
        return root


obj = Solution()
print(obj.buildTree(preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]))
