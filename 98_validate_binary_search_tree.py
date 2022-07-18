'''

## Problem 98: Validate binary search tree

## Author: Neha Doiphode
## Date:   07-16-2022

## Description
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

## Notes:
    > Tree Traversals:
        * In-order   = Left Root Right OR Right Root Left
        * Pre-order  = Root Left Right OR Root Right Left
        * Post-order = Left Right Root OR Right Left Root

                                 50
                            /         \
                           35          80
                          /  \       /   \
                        20   40     75    90
                       /  \    \   /  \   / \
                     15   25   45 60  78 85 100

                In   - order  = [15, 20, 25, 35, 40, 45, 50, 60, 75, 78, 80, 85, 90, 100]
                Pre  - order  = [50, 35, 20, 15, 25, 40, 45, 80, 75, 60, 78, 90, 85, 100]
                Post - order  = [15, 25, 20, 45, 40, 35, 60, 78, 75, 85, 100, 90, 80, 50]

        * Special property for in-order traversal of binary search tree:
            - Always in ascending order of elements if order followed is Left Root Right.
            - Always in descending order of elements if order follwoed is Right Root Left.

    > In case of tree data structure, recursion might turn out to be more powerful over iteration.

## Examples:
    Example 1:
        Input: root = [2,1,3]
        Output: true

    Example 2:
        Input: root = [5,1,4,null,null,3,6]
        Output: false
        Explanation: The root node's value is 5 but its right child's value is 4.

## Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1

## Time complexity: O(n), where n is number of nodes in the tree.

## Space complexity: O(h), space required to store nodes on recursive stack.
                           where h is height of the tree.
                           At a time, only h number of nodes will be present on the stack.

'''

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def to_binary_tree(items):
    if not items:
        return None

    # iter(object, sentinel [optional])
    # sentinel = special character used to represent end of the sequence.
    it = iter(items)
    root = TreeNode(next(it))
    q = [root]
    for node in q:
        val = next(it, None)
        if val is not None:
            node.left = TreeNode(val)
            q.append(node.left)
        val = next(it, None)
        if val is not None:
            node.right = TreeNode(val)
            q.append(node.right)
    return root

def get_input():
    print("Enter nodes of tree with spaces at height h, from left to right.")
    print("Input null if no left or right child to a node at height h.")
    inp_list = input()
    inp_list = inp_list.split()
    l = []
    for value in inp_list:
        if value != "null":
            l.append(int(value))
        else:
            l.append(None)

    return l, to_binary_tree(l)

class Solution:
    isValid = True
    prev = None
    def bst_preorder_iterative(self, root: Optional[TreeNode]) -> None:
        print("Iterative: Pre-order traversal(Root, Left, Right): ", end = "")
        # base case
        if root == None:
            return
        stack = []
        while root != None or len(stack) != 0:
            while root != None:
                print(f"{root.val} ", end = " ")
                stack.append(root)
                root = root.left
            root = stack.pop()
            root = root.right
        print()

    def bst_postorder_iterative(self, root: Optional[TreeNode]) -> None:
        print("Iterative: Post-order traversal(Left, Right, Root): ", end = "")
        print()

    def bst_inorder_iterative(self, root: Optional[TreeNode]) -> None:
        print("Iterative: In-order traversal(Left, Root, Right): ", end = "")
        # base case
        if root == None:
            return
        stack = []
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left

            root = stack.pop()
            print(f"{root.val} ", end = " ")
            root = root.right
        print()

    def bst_inorder_recursive(self, root: Optional[TreeNode]) -> None:
        # base case
        if root == None:
            return

        # logic
        self.bst_inorder_recursive(root.left)
        print(f"{root.val} ", end = " ")
        self.bst_inorder_recursive(root.right)

    def bst_preorder_recursive(self, root: Optional[TreeNode]) -> None:
        # base case
        if root == None:
            return

        # logic
        print(f"{root.val} ", end = " ")
        self.bst_inorder_recursive(root.left)
        self.bst_inorder_recursive(root.right)

    def bst_postorder_recursive(self, root: Optional[TreeNode]) -> None:
        pass

    def bst_inorder_recursive_helper(self, root: Optional[TreeNode]) -> None:
        # base case
        if root == None:
            return True

        # logic
        # Right sub tree won't be called if left has a mis-match or nodes in non-ascending order
        if not self.bst_inorder_recursive_helper(root.left):
            return False

        # Right sub tree won't be called if left has a mis-match or nodes in non-ascending order
        if self.prev != None and self.prev.val >= root.val:
            return False

        self.prev = root
        return self.bst_inorder_recursive_helper(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        '''
        ################# JUST FOR PRACTICE ###################
        self.bst_inorder_iterative(root)
        self.bst_preorder_iterative(root)
        self.bst_postorder_iterative(root)

        print("Recursive: In-order traversal(Left, Root, Right): ", end = "")
        self.bst_inorder_recursive(root)
        print()

        print("Recursive: Pre-order traversal(Root, Left, Right): ", end = "")
        self.bst_preorder_iterative(root)
        print()

        print("Recursive: Post-order traversal(Left, Right, Root): ", end = "")
        self.bst_postorder_recursive(root)
        print()
        '''
        self.prev = None
        return self.bst_inorder_recursive_helper(root)

# Driver code
solution = Solution()
l, root = get_input()
print(f"Input Tree: {l}", end = "")
print()
print(f"Is it a valid BST?: {solution.isValidBST(root)}")
