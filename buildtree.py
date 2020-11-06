# time complexity: O(N)
# space complexity:O(n)
# leetcode: accepted
# explaination: in preorder traversal the root always at the front. Find the root element and its index in the inorder traversal
# elements left to the root element forms the left subtree and elements towards the riht form theright subtree.
# left subtree = 0 to index1 and right subtree = index+1 till end of array. Keep on continu you reach ibase case that is len(preorder) is 0
# doubts: None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        # print(self.root.val)
        index = None
        for i in range(len(inorder)):
            if inorder[i] == (root.val):
                index = i
        preleft = preorder[1:index + 1]
        inleft = inorder[0:index]
        preright = preorder[index + 1:len(preorder)]
        inright = inorder[index + 1:len(preorder)]
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)
        return root

