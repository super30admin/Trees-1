class TreeNode:
    def __init__(self, val, left, right):
        self.val = val
        self.right = None
        self.left = None


class inorder_traversal:
    def helper_inorder(self, node):
        # base case: It is hit when leaf node is reached whose left and right children are NULL
        if not node:
            return  # return to the line of code from where it was called.

        self.helper_inorder(node.left)  # (1) Since it is in-order, initially keep going (or adding the recursive call
        # to the stack) to the left node of the current node until leaf node is reached. Base case is hit.
        # (2) when the recursion returns at this line, it means the left child of the current node is processed and
        # internally stack.pop() happens for the previous node.

        print(node.val)  # process the current node, the node in function call: "helper_inorder(self, node)"

        self.helper_inorder(
            node.right)  # once, left child of the current node and the node itself are processed, process right child,
        # of the current node. And if right child has left child then process that first.
        # (2) when the recursion returns at this line, it means the right child of the current node is processed and
        # internally stack.pop() happens for the previous node.
        # (3) the current node its left and right children are processed and recursion for the current node
        # reaches end it is also popped from the called stack.
        # Note: The top of the stack is the activation function.


class preorder_traversal:
    def helper_preorder(self, node):
        # base case: It is hit when leaf node is reached whose left and right children are NULL
        if not node:
            return  # return to the line of code from where it was called.

        # process node
        print(node.val)  # process the current node, the node in function call: "helper_inorder(self, node)".

        self.helper_preorder(node.left)  # go to the left node of the current node, (or keep adding the function call to
        # the stack until the base case is reached). When the recursion returns at this line, it means the current node
        # and left child of the current node are processed.

        self.helper_preorder(node.right) # once the current node and its left are processed, go to the left child of the
        # current node. When the recursion returns at this line, it means the current node, left child of the current
        # node and right child of the current node are processed.


class postorder_traversal:
    def helper_postorder(self, node):
        # base case: It is hit when leaf node is reached whose left and right children are NULL
        if not node:
            return # return to the line of code from where it was called.

        self.helper_postorder(node.left)  # go to the left node of the current node, (or keep adding the function
        # call to the stack until the base case is reached). When recursion returns at this line, it means left child
        # of the current node is processed.

        self.helper_postorder(node.right) # once the left child of the current node is processed, go to the right child
        # of the current node. When the recursion returns at this line, it means left child and right child of
        # current node are processed.

        # process node
        print(node.val) # Since it is post-order the current node is processed when both of its right and left child
        # are processed.


class understand_recursion_flow:
    def helper(self, root):
        # This the base case. When the recursive call reaches the leaf node, a call to its left and right children
        # is made which are null. They hit this base case and return to the line of code from where they were
        # called that is line .....
        if root is None:
            return

        self.helper(root.left)  # (1) Go to the left child of the current node (or add left child of the current node to
        # stack). (2) when the recursion return at this line internally stack.pop() happens for that
        # call.

        print("up", root.val) # process the current node

        self.helper(root.right)  # (1) once left child and current node are processed, right child is processed.
        # (2) when the recursion return at the line internally, stack.pop() happens

        print("down", root.val) # process the current node. THis is the end for processing of current node.


obj = understand_recursion_flow()
root = TreeNode(5, None, None)
Node1 = TreeNode(1, None, None)
Node2 = TreeNode(4, None, None)
root.left = Node1
root.right = Node2
Node3 = TreeNode(3, None, None)
Node4 = TreeNode(6, None, None)
Node2.left = Node3
Node2.right = Node4

obj.helper(root)
