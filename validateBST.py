#Time complexity: O(n)
#Space Complexity: O(1)

class Root:
    def __init__(self, value):
        self.val = value
        self.left = None
        self.right = None


class Solution:
    def isValidBST(self, root):
       
         res = []
         def dfs(root):
             if root != None:
                 dfs(root.left)
                 res.append(root.val)
                 dfs(root.right)
         
         dfs(root)
         print(res)
         for i in range(1,len(res)):
             if (res[i] <= res[i-1]):
                 return False

         return True
    

tree = Root(2)
tree.left = Root(1)
tree.right = Root(3)


output = Solution()
result = output.isValidBST(tree)
print(result)