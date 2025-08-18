# main.py

from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: Optional['TreeNode'] = None, right: Optional['TreeNode'] = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        curr = root
        pre_val = float('-inf')  # last visited value in inorder

        while curr or stack:
            # go left as far as possible
            while curr:
                stack.append(curr)
                curr = curr.left

            # visit node
            curr = stack.pop()

            # inorder must be strictly increasing
            if curr.val <= pre_val:
                return False
            pre_val = curr.val

            # then go right
            curr = curr.right

        return True

if __name__ == "__main__":
    sol = Solution()

    # 1) Your case: [5,1,4,null,null,3,6] -> should be False
    bad = TreeNode(5,
            TreeNode(1),
            TreeNode(4, TreeNode(3), TreeNode(6)))
    print("Case 1 (expected False):", sol.isValidBST(bad))

    # 2) Valid BST: [2,1,3] -> True
    good = TreeNode(2, TreeNode(1), TreeNode(3))
    print("Case 2 (expected True):", sol.isValidBST(good))

    # 3) Duplicate on left: not allowed in strict BST -> False
    dup = TreeNode(1, TreeNode(1), None)
    print("Case 3 (expected False):", sol.isValidBST(dup))
# Time Complexity (TC): O(n) — every node is pushed/popped at most once during the inorder traversal.

# Space Complexity (SC): O(h) — stack holds the path from root to current node, where h is tree height.