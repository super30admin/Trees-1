
# INORDER TRAVERSAL SOLUTION

# Time Complexity: O(N), N: no.of.nodes in the tree
# Space Complexity: O(N) for 1 stack 
# Did problem run on Leetcode: yes

class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class Solution:
    def inorder_isValidBST(self, root):
        if not root:
            return True
        
        stack = []
        previous = None

        while root != None or stack != []:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if previous != None and root.key <= previous.key:
                return False
            previous = root
            root = root.right
        
        return True


a = TreeNode(20)
a.left = TreeNode(15)
a.right = TreeNode(25)
a.left.left = TreeNode(13)
a.left.right = TreeNode(18)
a.right.left = TreeNode(24)
a.right.right = TreeNode(27)
a.left.left.left = TreeNode(10)
a.left.left.right = TreeNode(14)
a.left.right.left = TreeNode(16)
a.left.right.right = TreeNode(19)

obj = Solution()
print(obj.inorder_isValidBST(root=a))

