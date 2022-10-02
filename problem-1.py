# Time Complexity = O(n)
# Space Complexity = O(h). h = height of the tree
# Did this problem run on leetcode : Yes



class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

prev = None
isValid = True
def isValidBST(root: TreeNode) -> bool:
    if root is None:
        return isValid
    
    inorder(root)
    return isValid

def inorder(root: TreeNode) -> bool:
    if root is None:
        return
    
    inorder(root.left)

    if(prev is not None and prev.val >= root.val):
        isValid = False
    prev = root

    inorder(root.right)

