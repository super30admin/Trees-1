"""
Time - O(n)
Space - O(n)
Runs on leetcode - YES
"""


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hashmap = {}
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i  

        self.idx = 0  

        def helper(preorder, hashmap, start, end):
            # base
            if start > end:
                return None

            # logic
            rootVal = preorder[self.idx]  
            self.idx += 1

            root = TreeNode(rootVal)

            rootIdx = hashmap[rootVal]
            root.left = helper(preorder, hashmap, start, rootIdx - 1)
            root.right = helper(preorder, hashmap, rootIdx + 1, end)  

            return root

        return helper(preorder, hashmap, 0, len(inorder) - 1)

