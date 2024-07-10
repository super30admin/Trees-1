class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
#time = O(1)
#space O(n)
def build_tree_recursive(preorder, inorder):
    if not preorder or not inorder:
        return None
    
    # The first element of preorder is the root
    root_value = preorder[0]
    root = TreeNode(root_value)
    
    # Find the root in inorder list to split into left and right subtrees
    mid = inorder.index(root_value)
    
    # Recursively build left and right subtrees
    root.left = build_tree_recursive(preorder[1:mid+1], inorder[:mid])
    root.right = build_tree_recursive(preorder[mid+1:], inorder[mid+1:])
    
    return root

# Example usage:
preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]

tree = build_tree_recursive(preorder, inorder)
print(tree)

# Function to print tree in a structured way (for testing)
def print_tree(node, level=0, prefix="Root: "):
    if not node:
        return
    print(" " * (level * 4) + prefix + str(node.value))
    if node.left: print_tree(node.left, level + 1, "L--- ")
    if node.right: print_tree(node.right, level + 1, "R--- ")

print_tree(tree)