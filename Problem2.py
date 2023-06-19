# Time Complexity : O(n)
# Space Complexity : O(n) for the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  Here we use create a hashmap that helps point to the index of a given lelement in the inorder array.
#  We know that as we go along the preorder array, if we are able to find the element in the inorder array, we can split the array into left and right subtrees at that node.
# We use this property to move an iterator along the preOrder array, and construct the nodes and recurse properly into the left and right subtrees using the inorder array.
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        preIdx = 0
        mp = {}
        for idx, i in enumerate(inorder):
            mp[i] = idx
        
        def helper(preorder, inorder, instart, inend):
            nonlocal mp, preIdx
            if instart > inend:
                return None
            inIdx = mp[preorder[preIdx]]
            root = TreeNode(preorder[preIdx])
            preIdx += 1
            root.left = helper(preorder, inorder, instart, inIdx-1)
            root.right = helper(preorder, inorder, inIdx+1, inend)
            return root

        return helper(preorder, inorder, 0, len(inorder)-1)        
