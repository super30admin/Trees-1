#Did it run on Leetcode?:Yes
#Time Complexity:O(n2) for every node we have to find index
#Space Complexity:O(1)
#Approach:From preorder we get the root of the tree. We use this to split inorder into left and right subtree.
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0:
            return None
        root=TreeNode(preorder[0])
        middle=inorder.index(preorder[0])
        root.left=self.buildTree(preorder[1:middle+1],inorder[:middle])
        root.right=self.buildTree(preorder[middle+1:],inorder[middle+1:])
        return root