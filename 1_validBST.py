# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.prev = None

    def isValidBST(self,root) :
        # # iterative
        if root == None : return True
        past=None
        st=[]
        while root != None or len(st)!=0:
            while root != None:
                st.append(root)
                root=root.left

            root=st.pop()
            if past !=None and past.val >= root.val: return False
            past=root
            root = root.right

        return True

        # recurrsive
        # if self.Inorder(root) == None: return True
        # else:
        #     return False

    def Inorder(self,root):
        if root == None: return
        print(root.val)
        if (self.Inorder(root.left) == False): return False
        if self.prev != None and self.prev.val >= root.val : return False
        self.prev=root
        return self.Inorder(root.right)

root=TreeNode(3,left=TreeNode(val=2),right=TreeNode(val=3))
a=Solution()
print(a.isValidBST(root=root))