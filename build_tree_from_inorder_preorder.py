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
Say preorder = [0,1,3,4,2,5], inorder = [3,1,4,0,5,2]
- Get the root node which is at the first index of preorder[] list.
Therefore, root = 0 at position = 0
- Find position of root node in the inorder[] list using linear search.
Since inorder[3] = root, root_idx = 3.
- The inorder list can now be split into left sub-tree (inorder[0:root_idx])
and right sub-tree (inorder[root_idx+1:]).
                        inorder = [3,1,4,  0,    5,2]
                                  left    root   right

- Now the elements of the left sub-tree should be present in the preorder[] list
right after the root node.
preorder = [0,    1,3,4,    2,5],
           root   left      right

That means, if root node is preorder[0], then preorder[1:len(left sub-tree)+1] is the preorder alignment of nodes of the left sub-tree and preorder[len(left sub-tree)+1:] is the preorder alignment of nodes of the right sub-tree.


- Now we have the root, preorder and inorder of left-subtree, preorder and inorder of right-subtree.
root = 0
inorder_left  = [3,1,4], preorder_left =  [1,3,4]
inorder_right = [5,2],   preorder_right = [2,5]

We are back at the same problem which can be solved by making two recursion calls - first on the left sub-tree and then on the right sub-tree

Time complexity is based on traversing all nodes (O(N)) but for each node
we perform a linear search which is another O(N) and slicing the array
to extract left and right sub-trees which is O(2N)
Time: O(N^2), Space: O(N^2)

2. Hashing + Two pointer: This is similar in logic as Brute force but uses a hash table for finding the index of the root node in inorder[]. Hash table lookup takes only O(1) instead of linear search O(N).

But copying of arrays still takes O(2N). Space is O(N) due to hash table and O(H) due to recursion stack and O(2N) for array memory for each recursion call. Hence, total space is O(2NH + N) = O(NH)
which in worst case is O(N^2). Hence, Time: O(N^2), Space: O(N^2)

Rather than creating new arrrays and copying, we just maintain one pointer for the preorder array and another pointer for the inorder array
Time: O(N), Space: O(N)

https://youtu.be/TfnvkPC4UrI?t=5202
'''
from binary_tree import *

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

def build_tree_1(preorder, inorder):
    '''
    Brute Force
    '''
    def get_root_id_from_inorder(val, inorder):
        '''
        Linear search O(N)
        Assumption: No duplicates in array since this is given in the constraint
        of the problem
        '''
        for i in range(N):
            if inorder[i] == val:
                return i
        return -1

    def recurse(preorder, inorder, root):
        # find root id in inorder using linear search O(N)
        root_idx = get_root_id_from_inorder(root.val, inorder)

        # slicing to get left + right: O(N)
        in_left = inorder[0:root_idx]
        in_right = inorder[root_idx+1:]

        # slicing to get left + right: O(N)
        pre_left = preorder[1:1+len(in_left)]
        pre_right = preorder[1+len(in_left):]

        # left sub-tree
        if len(pre_left):
            root.left = TreeNode(pre_left[0])
            recurse(pre_left, in_left, root.left)

        # right sub-tree
        if len(pre_right):
            root.right = TreeNode(pre_right[0])
            recurse(pre_right, in_right, root.right)

        return

    N = len(preorder)
    if N == 0:
        return []
    assert N == len(inorder), f"Lengths of Inorder and Preorder must be the same"
    root = preorder[0]
    new = TreeNode(root)
    recurse(preorder, inorder, new)
    return new

def build_tree_2(preorder, inorder):
    '''
    Hash map + Two-pointer
    '''
    def recurse(start, end):
        nonlocal pre_root_idx
        if start > end:
            return
        if pre_root_idx > N-1:
            return

        root_val = preorder[pre_root_idx]
        # root id in inorder using hash map O(1)
        in_root_idx = h[root_val]
        pre_root_idx += 1
        root = TreeNode(root_val)
        root.left = recurse(start, in_root_idx - 1)
        root.right = recurse(in_root_idx + 1, end)
        return root

    N = len(preorder)
    if N == 0:
        return []
    assert N == len(inorder), f"Lengths of Inorder and Preorder must be the same"
    h = {}
    for i in range(N):
        h[inorder[i]] = i

    pre_root_idx = 0
    root = recurse(0, N-1)
    return root


def run_tests():
    tests = [([3,9,1,2,20,15,7], [9,2,1,3,15,20,7], [3,9,20,1,15,7,2]),
             ([3,9,20,15,7], [9,3,15,20,7], [3,9,20,15,7]),
             ([0,1,3,4,2,5], [3,1,4,0,5,2], [0,1,2,3,4,5]),
            ([1,2,3], [1,2,3], [1,2,3]),
            ([7,-10,-4,3,-1,2,-8,11], [-4,-10,3,-1,7,11,-8,2], [7,-10,2,-4,3,-8,-1,11]),
            ([-1],[-1],[-1]),
            ([],[],[])]

    for test in tests:
        preorder, inorder, ans = test[0], test[1], test[2]
        ans_tree = build_tree_level_order(ans)
        ans_tree.display()

        tree1 = build_tree_1(preorder, inorder)
        res1 = levelOrderTraversal(tree1)
        tree2 = build_tree_2(preorder, inorder)
        res2 = levelOrderTraversal(tree2)

        print(f"\npre = {preorder}")
        print(f"in = {inorder}")
        print(f"1. Brute Force = {res1}")
        print(f"2. Hashing + Two pointer  = {res2}")
        passed = (ans == res1 == res2)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()