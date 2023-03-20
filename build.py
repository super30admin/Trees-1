# time complexity - O(n)
# space complexity - O(1)
# worked on leetcode? yes
# logic - find the index of root node in inorder traversal, this gives the count
# of left and right elements of that node.
# If mid is index of root in inorder traversal, then left tree is comprised of 
# inorder[:mid] and preorder[1:mid+1] by excluding root at 0 and no of elements is found to be mid from inorder
# right will be inorder[mid+1:] and preorder[mid+1:]
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1],inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:],inorder[mid+1:])
        return root
