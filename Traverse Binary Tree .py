# Tree Defenition,
class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class Solution:

    # Iterative Solution
    # time: O(N)
    # space: O(2N) in worst case
    def inorderTraversal(self, root):

        if root == None:
            return []

        stack = []
        ans = []

        while root != None or stack != []:
            while root != None:
                stack.append(root)
                root = root.left

            root = stack.pop()
            ans.append(root.key)
            root = root.right

        return ans

    # Recursive Solution
    # time: O(N)
    # space: O(N) for result array + Recursive call stack
    def inorderTraversal(self, root):
        res = []
        self.helper(root, res)
        return res

    def helper(self, root, res):
        if root:
            self.helper(root.left, res)
            res.append(root.key)
            self.helper(root.right, res)




# ===============================================================================

    # Iterative Solution --> 1 STACK APPROACH
    # time: O(N)
    # space: O(2N) for 2 arrays 
    def preOrderTraversal(self, root):
        if not root:
            return []

        stack = []
        res = []
        stack.append(root)

        while stack != []:
            root = stack.pop()
            res.append(root.key)
            if root.right != None:
                stack.append(root.right)
            if root.left != None:
                stack.append(root.left)
                    
        return res
    

    # Recursive Solution
    # time: O(N)
    # space: O(N) for result array + Recursive call Stack
    def preOrderTraversal(self, root):
        res = []
        self.helper(root, res)
        return res
    def helper(self, root, res):
        res.append(root.key)
        self.helper(root.left, res)
        self.helper(root.right, res)


# ===============================================================================
    # Iterative Solution --> 2 STACK APPROACH
    # time : O(N)
    # space : O(N), WORST CASE: stack2 holds all the node
    def postorderTraversal(self, root):
        if not root:
            return []

        stack1 = []
        stack2 = []
        res = []
        stack1.append(root)

        while stack1 != []:
            root = stack1.pop()
            if root.left != None:
                stack1.append(root.left)
            if root.right != None:
                stack1.append(root.right)
            stack2.append(root)
        
        while stack2 != []:
            resNode = stack2.pop()
            res.append(resNode.key)

        return res

    # Recursive Solution
    # time : O(N)
    # space : O(N), WORST CASE: stack2 holds all the node
    def postorderTraversal(self, root):
        res = []
        self.helper(root, res)
        return res
    def helper(self, root, res):
        if root:
            self.helper(root.left, res)
            self.helper(root.right, res)
            res.append(root.key)


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
print(obj.preOrderTraversal(root = a))
    
    

        