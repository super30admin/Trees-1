from tkinter.tix import Tree


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# SC: O (height of tree)
# tc :O(n)
def inorder(root):
    stack = []

    while stack or root:
        # inorder left operation
        while(root): # root not null
            stack.append(root)
            root = root.left
        # Data retrieval part st.pop     
        root = stack.pop()
        print(root.val)
        root = root.right

if __name__ == "__main__":
    print("entering main")
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    root.right.right = TreeNode(6)
    root.left.left = TreeNode(-1)
    root.left.right = TreeNode(1.5)
    inorder(root)