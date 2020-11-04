class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def buildTree(preorder, inorder):
    """
    :type preorder: List[int]
    :type inorder: List[int]
    :rtype: TreeNode
    """
    pre_id = 0

    def helper(left=0, right=len(preorder)):
        nonlocal pre_id
        if right == left:
            return None
        root_val = preorder[pre_id]
        root = TreeNode(root_val)
        pre_id += 1
        index = dic[root_val]
        root.left = helper(left, index)
        root.right = helper(index + 1, right)
        return root

    dic = {val: id for id, val in enumerate(inorder)}
    return helper()


# root=TreeNode(1)
# root.left=TreeNode(1)
# root.right=TreeNode(3)

print(buildTree([3, 9, 20, 15, 7], [9, 3, 15, 20, 7]))

# time-O(n) space-O(n)