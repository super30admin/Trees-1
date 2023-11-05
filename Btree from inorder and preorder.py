# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n^2)
#SC: O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        if not inorder:
            return None
        
        val = preorder.pop(0) #O(n)
        node = TreeNode(val)
        index = inorder.index(val) #O(n)
        node.left = self.buildTree(preorder,inorder[:index]) #O(n)
        node.right = self.buildTree(preorder,inorder[index+1:]) #O(n)
               
        return node

#TC: O(n)
#SC: O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        
        def to_tree(left, right):
            nonlocal preorder_index
            # if there are no elements to construct the tree
            if left > right: return None

            # select the preorder_index element as the root and increment it
            root_value = preorder[preorder_index]
            root = TreeNode(root_value)


            preorder_index += 1

            # build left and right subtree
            root.left = to_tree(left, inorder_map[root_value] - 1) #O(n)
            root.right = to_tree(inorder_map[root_value] + 1, right) #O(n)

            return root
        
        preorder_index = 0
        # build a hashmap to store value -> its index relations
        inorder_map = {}
        for index, value in enumerate(inorder): #O(n)
            inorder_map[value] = index

        return to_tree(0, len(preorder) - 1)
    
