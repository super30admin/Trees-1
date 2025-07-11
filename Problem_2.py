'''
105 Construct Binary Tree From Preorder And Inorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Note: You may assume that duplicates do not exist in the tree.
Can you do it both iteratively and recursively?

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

Let N = num of nodes, H = height of tree

Solution:
1. Brute Force:
Maintain an index (pidx) to retrieve the root node from preorder[] list.
Based on pidx, get the root node using preorder[pidx].
Find the corresponding index (call it 'mid') of the root node in inorder[] using linear search.
Nodes left of inorder[mid] constitute the left subtree
Nodes right of inorder[mid] constitute the left subtree
Now, update pidx = pidx + 1 to retrieve the next root node.
Time complexity is based on traversing all nodes (O(N)) but for each node
we perform a linear search which is another O(N).
Time: O(N^2), Space: O(H)

2. Hashing: This is similar in logic as Brute force but uses a hash table
for finding the index ('mid') of the root node in inorder[]
Time is reduced to O(N) for traversing the nodes. Hash table lookup takes only O(1). Space is O(N) due to hash table and O(H) due to recursion stack
Time: O(N), Space: O(N + H) = O(N)
'''
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def levelOrderTraversal(tree):
    q = deque()
    array=[]
    if not tree:
        return []
    q.append(tree)
    while q:
        node = q.popleft()
        #print(node.val, end = " --> ")
        array.append(node.val)
        if node.left:
            q.append(node.left)
        if node.right:
            q.append(node.right)
    #print(f"None")
    return array


def build_tree(preorder, inorder):
    def helper(preorder, inorder, left, right):
        nonlocal pidx
        N = len(preorder)
        if N == 0:
            return []
        if pidx > N-1:
            return None

        # Build the root node
        root_val = preorder[pidx]
        root = TreeNode(root_val)

        mid = h[root_val]

        # Build the left subtree if it exists
        left_tree = inorder[left:mid]
        if len(left_tree) == 1:
            pidx += 1
            root.left = TreeNode(left_tree[0])
        elif len(left_tree) > 1:
            pidx += 1
            root.left = helper(preorder, inorder, left, mid-1)
        else: # len = 0 (doesn't exist)
            # root.left = None (by default)
            pass


        # Build the right subtree if it exists
        right_tree = inorder[mid+1:right+1]
        if len(right_tree) == 1:
            pidx += 1
            root.right = TreeNode(right_tree[0])
        elif len(right_tree) > 1:
            pidx += 1
            root.right = helper(preorder, inorder, mid+1, right)
        else: # len = 0 (doesn't exist)
            # root.right = None (by default)
            pass

        return root


    # index of root in postorder[]
    pidx = 0

    # lookup table to retrieve indices of all nodes in inorder[]
    h = {value: index for index, value in enumerate(inorder)}

    # define the partitions of inorder[]
    # inorder = [(<-- left subtree -->), (root), (<--right subtree) -->]
    #         = [(left,...,mid-1), (mid), (mid+1,...,right)]

    # start index of inorder[] comprising of nodes in left subtree
    left = 0
    # end index of inorder[] comprising of nodes in right subtree
    right = len(inorder) - 1
    root = helper(preorder, inorder, left, right)
    return root

def run_build_tree():
    tests = [([3,9,20,15,7], [9,3,15,20,7], [3,9,20,15,7]),
            ([1,2,3], [1,2,3], [1,2,3]),
            ([7,-10,-4,3,-1,2,-8,11], [-4,-10,3,-1,7,11,-8,2], [7,-10,2,-4,3,-8,-1,11]),
            ([-1],[-1],[-1]),
            ([],[],[])]
    for test in tests:
        preorder, inorder, ans = test[0], test[1], test[2]
        tree = build_tree(preorder, inorder)
        levelorder = levelOrderTraversal(tree)
        print(f"\npre = {preorder}")
        print(f"in = {inorder}")
        print(f"level = {levelorder}")
        print(f"Pass: {ans == levelorder}")

run_build_tree()