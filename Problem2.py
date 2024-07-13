#I used a recursive approach to build the tree. First, I handle the base cases where either the preorder or inorder list is empty. Then, I take the first element from the preorder list as the root of the current subtree. I find this element's position in the inorder list, which tells me how many elements are in the left subtree. Using this information, I recursively build the left subtree using the elements before this position in the inorder list, and the right subtree using the elements after this position. The preorder list naturally divides itself as we pop elements from its beginning. This process continues until we've used all elements to construct the entire tree.

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        if not inorder:
            return None
        ele = preorder.pop(0)
        root = TreeNode(ele)
        idx = inorder.index(ele)
        root.left = self.buildTree(preorder, inorder[:idx])
        root.right = self.buildTree(preorder, inorder[idx+1:])
        return root