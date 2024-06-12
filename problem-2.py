# Time Complexity : O(n)

# space complexity : O(h)

# Approach :

# use dfs
# create a hashmap and store the elements and indices of the inorder array
# keep iterating through the preorder array to find root
# keep two iterators start and end . If start > end, it means its a leaf node
# keep a pointer which remains static for every recursive call so that we can find the new root in every recursion from preorder array


class Solution:
    hashMap = dict()

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.preOrderIndex = 0
        self.lenInorder = len(inorder)

        for i in range(self.lenInorder):
            Solution.hashMap[inorder[i]] = i

        result = self.checkTree(preorder, 0, self.lenInorder - 1)
        return result

    def checkTree(self, preorder, start, end):

        if start > end:
            return None

        rootVal = preorder[self.preOrderIndex]
        self.preOrderIndex += 1

        rootNode = TreeNode(rootVal)

        rootNode.left = self.checkTree(
            preorder, start, Solution.hashMap[rootVal] - 1)
        rootNode.right = self.checkTree(
            preorder, Solution.hashMap[rootVal] + 1, end)

        return rootNode
