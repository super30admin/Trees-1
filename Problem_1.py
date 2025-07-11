'''
98 Validate BST
https://leetcode.com/problems/validate-binary-search-tree/description/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Solution:
1. Brute Force:
Perform inorder traversal of tree and store the node values in an array as we traverse through each node. Once the inorder traversal is complete, copy the array into a new array and sort it. Compare the array with the sorted array. If they match, then it is a valid BST. Else, invalid.
https://youtu.be/oxZyTn72aEI?t=285
Time: O(N + N log N) = O(N log N), Space: O(H + N) = O(N) (O(H) for recursion
stack, O(N) for storing the elements in the array)

2. Inorder traversal (sub-optimal):
Perform inorder traversal of tree and store the node values in an array as we traverse through each node. Once the inorder traversal is complete, check if the elements in the array are arranged in an ascending order. If yes, then tree is a BST. Else, tree is not a BST.
https://youtu.be/oxZyTn72aEI?t=443
Time: O(N), Space: O(N) (storing the node values in an array)

3. Min-max (optimal):
Let m = min value, M = max value. For each node we traverse using inorder traversal, we check if the value of the node lies in (m, M).

For each parent node, ensure the following 3 condition holds:
parent node:    m < parent.value < M
left child:     m < left.value < parent.value
right child:    parent.value < right.value < M

Step 0: parent node=root node, m = -inf, M = +inf
Step 1: Go to left node with bounds (m, parent.value).
        Check if left.value lies within bounds. If true, go to Step 2. Else return False
Step 2: Go to right node with bounds (parent.value, M).
        Check if right.value lies within bounds. If true, go to Step 3. Else return False
Step 3: Repeat Steps 1 and 2 until we reach leaf node.

Note that this solution works for preorder, inorder or postorder traversal. Hence, independent of traversal order.
https://youtu.be/oxZyTn72aEI?t=2469
Time: O(N), Space: O(H) (space of recursion stack)
'''
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def build_tree_level_order(values):
    N = len(values)
    if N == 0:
        return None
    q = deque()
    tree = TreeNode(values[0])
    q.append(tree)
    i=0
    while i < N and q:
        node = q.popleft()
        left_index = 2*i+1
        right_index = left_index + 1
        if left_index < N and values[left_index] is not None:
            node.left = TreeNode(values[left_index])
            q.append(node.left)
        if right_index < N and values[right_index] is not None:
            node.right = TreeNode(values[right_index])
            q.append(node.right)
        i += 1
    return tree

def inorder(root, array):
    if not root:
        return None
    inorder(root.left, array)
    array.append(root.val)
    inorder(root.right, array)

def helper_1(root):
    # T: O(N), S: O(N)
    array=[]
    inorder(root, array)
    #print(array)
    N = len(array)
    if N == 0:
        return True
    # If array is an ascending order sequence, then
    # valid BST. Else invalid BST.
    prev = float('-inf')
    for i in range(N):
        curr = array[i]
        if curr < prev:
            return False
        prev = curr
    return True

def helper_2(root, m=float('-inf'), M=float('+inf')):
    # T: O(N), S: O(H)
    # Solution works for preorder, inorder or postorder traversal. Hence, independent of traversal order

    if not root:
        return True
    # preorder traversal (works)
    # if not (m < root.val < M):
    #     return False
    # left_valid = helper_2(root.left,m=m,M=root.val)
    # right_valid = helper_2(root.right,m=root.val,M=M)
    # return left_valid & right_valid

    # postorder traversal (works)
    # left_valid = helper_2(root.left,m=m,M=root.val)
    # right_valid = helper_2(root.right,m=root.val,M=M)
    # if not (m < root.val < M):
    #     return False
    # return left_valid & right_valid

    # inorder traversal (works)
    left_valid = helper_2(root.left,m=m,M=root.val)
    if not (m < root.val < M):
        return False
    right_valid = helper_2(root.right,m=root.val,M=M)
    return left_valid & right_valid


def is_valid_bst(root, method=2):
    tree=build_tree_level_order(root)
    if method == 1: # inorder traversal (sub-optimal)
        result = helper_1(tree)
    elif method == 2: # min-max (optimal)
        result = helper_2(tree)
    else:
        print(f"invalid method {method}")
        result = None
    return result

def run_is_valid_bst():
    tests = [([5,1,4,None,None,3,6], False),
             ([2,1,3], True),
             ([1,2,3], False),
             ([5,2,6,1,4,None,7,None,None,3,None,None,None,None,None], True),
             ([1], True),
             ([], True)]
    for test in tests:
        root, ans = test[0], test[1]
        for method in [1,2]:
            valid = is_valid_bst(root, method)
            print(f"\ntree={root}")
            print(f"Method {method}: is valid bst: {valid}")
            print(f"Pass: {ans == valid}")

run_is_valid_bst()