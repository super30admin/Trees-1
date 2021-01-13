'''
    Time Complexity:
        O(n) (where h = number of nodes)

    Space Complexity:
        O(n) (where n = number of nodes)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Store the inorder sequence in a HashMap of val: idx.
        Intially start building the tree for the entire inorder array.
        You need a global variable to manage the index of the root node.
        Use the inorder hash map to find the index of your root.
        [Start: root_idx] is your left subtree.
        [root_idx+1: End] is your right subtree.
'''
class Solution:
    def __init__(self):
        self.pre_order = []
        self.in_order_map = {}
        self.root_idx = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.pre_order = preorder

        for idx, node_val in enumerate(inorder):
            self.in_order_map[node_val] = idx

        return self.generate_tree(0, len(inorder) - 1)

    def generate_tree(self, start, end):
        if start > end:
            return None

        root_val = self.pre_order[self.root_idx]
        root = TreeNode(root_val)

        self.root_idx += 1

        inorder_idx = self.in_order_map[root_val]

        root.left = self.generate_tree(start, inorder_idx - 1)
        root.right = self.generate_tree(inorder_idx + 1, end)

        return root
