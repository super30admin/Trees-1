# Time: O(N)
# Space: O(N)
class Solution:
    def buildTree(self, preorder, inorder):
        print(preorder, inorder)
        idxmap = dict(zip(inorder, range(len(inorder))))
        print(idxmap)
        pre_iter = iter(preorder)

        def buildTreeHelper(start, end):
            print("-" * 40)
            print(start, end)
            if start > end: return None
            root_val = next(pre_iter)
            root = TreeNode(root_val)
            index = idxmap[root_val]
            print(root_val)
            root.left = buildTreeHelper(start, index - 1)
            root.right = buildTreeHelper(index + 1, end)
            return root

        return buildTreeHelper(0, len(inorder) - 1)