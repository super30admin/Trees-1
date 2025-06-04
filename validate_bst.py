# Time complexity  : O(n)
# Space complexity : O(h)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Validate:
    def __init__(self):
        self.is_valid_bst = True
        self.prev = None

    def validate_bst(self, root):
        if root == None or self.is_valid_bst == False:
            return
        self.validate_bst(root.left)
        if self.prev != None and self.prev.val > root.val:
            self.is_valid_bst = False
        self.prev = root
        self.validate_bst(root.right)


if __name__ == "__main__":
    root = TreeNode(5, TreeNode(1), TreeNode(4, TreeNode(3), TreeNode(6)))
    v = Validate()
    v.validate_bst(root)
    print(v.is_valid_bst)
    