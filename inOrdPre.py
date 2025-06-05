"""
First element in preorder is always root.
Find that root’s index in inorder; everything left of it belongs to the left subtree, everything right is the right subtree.
Recursion on left and right subtrees using correct subarrays.
"""
"""
Time Complexity: O(n) — All nodes visited once
Space Complexity: O(n) - For inorder_map
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class inOrdPre:
    def buildTree(self, preorder: list[int], inorder: list[int]):
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        self.pre_idx = 0


        def helper(left, right):
            if left > right:
                return None

            root_val = preorder[self.pre_idx]
            self.pre_idx += 1
            root = TreeNode(root_val)

            mid = inorder_map[root_val]
            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)
            return root

        return helper(0, len(inorder) - 1)

def print_inorder(root):
    if not root:
        return
    print_inorder(root.left)
    print(root.val, end=' ')
    print_inorder(root.right)
    
if __name__ == "__main__":
    obj = inOrdPre()
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    root = obj.buildTree(preorder, inorder)
    print_inorder(root)