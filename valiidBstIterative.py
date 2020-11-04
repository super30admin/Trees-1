# the recursion can be simulated using stack. So, the simple way to solve this problem is maintaing stack and pushing eleements until none is found and then popping accordingly. Now, I compare the preev element value with root, if the condition is violated then return false.
# Time Complexity: O(n)
# Space Complexity: O(h) 
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        st = list()
        prev= None
        while(root is not None or len(st)!=0):
            while(root is not None):
                st.append(root.left)
                root = root.left
            root = st.pop()
            if (prev is not None and prev.val>=root.val):
                return False
            prev = root
            root = root.right
        return True

n1 = TreeNode(5)
n2 = TreeNode(3)
n3 = TreeNode(6)
n1.left = n2
n1.right = n3
s = Solution()
s.isValidBST(n1)

