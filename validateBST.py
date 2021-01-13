# Validation of BST

# Approach 1:

# In order to validate the BST, we could apply inorder traversal 
# and check on the fly if the 2 pointers we choose(prev(prev root, initalized to None) and root dont breach the condition where prev >= root
# This is in the case where we apply inorder traversal from left, root, right


# Iterative approach

# Time Complexity: O(N) we visit all the nodes in the tree
# Space Complexity: O(H) where H is the height of the tree, since at any instant we do not store all the nodes in the tree
def isValidBST(root: TreeNode) -> bool

    stack = []
    TreeNode.prev = None

    if root == None:
        #Empty trees are valid BSTs.
        return True 

    while root != None or stack != []:

        while root != None:

            stack.append(root)
            root = root.left

        root = stack.pop()
        if (TreeNode.prev) != None and (TreeNode.prev.val >= root.val):
            return False
        
        TreeNode.prev = root
        root = root.right

    return True



# Recursive approach - Validate BST

def isValidBST(root: TreeNode):

    TreeNode.prev = None

    if root == None:
        return True

    return inOrder(root)


def inOrder(root):

    if root == None:
        return True

    if(inOrder(root.left) == False):
        return False
    
    if (TreeNode.prev != None) and if (TreeNode.prev.val >= root.val):
        return False

    TreeNode.prev = root

    return inOrder(root.right)




# Approach 2: Use min (float("-inf") and float("inf")) 
# To compare along the tree nodes we set min max for left and right subtree

def isValidBST(self, root: TreeNode) -> List[int]:

    return helper(root, float("-inf"), float("inf"))


def helper(root, minVal, maxVal):

    if root is None:
        return True

    if root.val <= minVal or root.val >= maxVal:
        return False

    leftIsValid = helper(root.left, minVal, root.val)
    rightIsValid = helper(root.right, root.val, maxVal)

    return leftIsValid and rightIsValid






# ============================================================== #


# Attempted inorder traversal iteratively and recursively

# Inorder Traversal of BST (root, left, right)
# Both iterative and recursive solutions take up O(H) space where H denotes the height of stack 
# Time = O(N)

# If tree is balanced at any time the H will refer to the levels of the Tree
# In worst case it could be O(N) where it is unbalanced, example: only left subtree or right subtree

# Iterative solution
def inOrderTraversal(root):

    stack = []
    result = []

    while root != None or stack != []:

        while root != None:
            stack.append(root)
            root = root.left

        root = stack.pop()
        result.append(root.val)
        root = root.right


    return result


# Recursive solution
def inOrderTraversal(root):

    if root == None:
        return []


    return inOrderTraversal(root.left) + [root.val] + inOrderTraversal(root.right)