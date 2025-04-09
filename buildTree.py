from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Approach 1: Naive Recursive Split (Slow)
# Repeatedly slicing lists and searching index in inorder array
# TC = O(n²) - each recursive call slices and searches
# SC = O(n)  - recursive call stack and list slices


class Solution:
    def buildTree1(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None

        root = TreeNode(preorder[0])

        # Find the root in inorder
        rootidx = -1
        for index, val in enumerate(inorder):
            if val == root.val:
                rootidx = index
                break

        # Split preorder and inorder for left and right
        inleft = inorder[:rootidx]
        preleft = preorder[1 : rootidx + 1]

        inright = inorder[rootidx + 1 :]
        preright = preorder[rootidx + 1 :]

        root.left = self.buildTree1(preleft, inleft)
        root.right = self.buildTree1(preright, inright)

        return root

    # Approach 2: Optimized Recursion with HashMap
    # Use a hashmap to quickly locate root in inorder
    # Avoids repeated slicing/index search
    # TC = O(n)  - each node visited once, hashmap lookup is O(1)
    # SC = O(n)  - recursion + hashmap

    def buildTree2(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Map to store value -> index in inorder
        map_inorder = {val: idx for idx, val in enumerate(inorder)}

        return self.helper(
            preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1, map_inorder
        )

    def helper(self, preorder, prestart, preend, inorder, instart, inend, map_inorder):
        if prestart > preend or instart > inend:
            return None

        rootVal = preorder[prestart]
        root = TreeNode(rootVal)
        rootidx = map_inorder[rootVal]

        # Number of nodes in the left subtree
        num_left = rootidx - instart

        root.left = self.helper(
            preorder,
            prestart + 1,
            prestart + num_left,
            inorder,
            instart,
            rootidx - 1,
            map_inorder,
        )

        root.right = self.helper(
            preorder,
            prestart + num_left + 1,
            preend,
            inorder,
            rootidx + 1,
            inend,
            map_inorder,
        )

        return root


from collections import deque


def print_level_order(root: Optional[TreeNode]):
    if not root:
        print("[]")
        return

    queue = deque([root])
    result = []

    while queue:
        node = queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)

    # Remove trailing None values
    while result and result[-1] is None:
        result.pop()

    print(result)


# Test Case
# Preorder: [3,9,20,15,7]
# Inorder:  [9,3,15,20,7]

if __name__ == "__main__":
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]

    print("Naive:")
    tree1 = Solution().buildTree1(preorder, inorder)
    print_level_order(tree1)

    print("\nOptimized:")
    tree2 = Solution().buildTree2(preorder, inorder)
    print_level_order(tree2)
