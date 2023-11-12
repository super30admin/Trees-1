class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val=val
        self.left=left
        self.right=right


class Traverse:
    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        curr=root
        print(curr.val)
        self.inorder(root.right)


node = Node(5)
node.left = Node(4)
node.right = Node(6)
node.left.left= Node(3)
node.right.right = Node(7)
solve = Traverse()
print(solve.inorder(node))






