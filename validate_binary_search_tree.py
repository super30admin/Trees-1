
def isValidBST(root):
    stack, prev = [], float("-inf")
    '''
    If next element in inorder traversal
    is smaller than the previous one
    that's not BST.
    '''
    while stack or root:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        if root.val <= prev:
            return False
        prev = root.val
        root = root.right

    return True


'''
Complexity Analysis
Time complexity : O(N) N elements in the tree
Space complexity : O(N) N elements added in stack
'''