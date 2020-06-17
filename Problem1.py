# Time Complexity : O(n) 
# Space Complexity : (Iterative)O(h) Space, where h is the height of the tree. and O(n) for recursive.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,val=0):
        self.val = val 
        self.left = None 
        self.right = None 
        
class Solution:
    # 1) Inorder method => Time = O(n) | O(n) Space
    # def isValidBST(self, root):
    #     if not root:
    #         return True
    #     nums = []
    #     self.inorder(root,nums)
    #     print(nums)
    #     for i in range(1,len(nums)):
    #         if nums[i-1] >= nums[i]:
    #             return False 
    #     return True 
        
    # def inorder(self,root,nums):
    #     if not root:
    #         return 
    #     self.inorder(root.left,nums)
    #     nums.append(root.val)
    #     self.inorder(root.right,nums)

    # 2) Recursive Solution =>  Time = O(n) | O(n) Space
    # def isValidBST(self,root):
    #     def helper(node,lower,upper):
    #         if not node:
    #             return True 
    #         if node.val <= lower or node.val >= upper:
    #             return False 
    #         return helper(node.left,lower,node.val) and helper(node.right,node.val,upper)
        
    #     return helper(root,float('-inf'),float('inf'))
    
    # 3) Iterative Solution => Time = O(n) | O(h) Space, where h is the height of the tree.
    def isValidBST(self,root):
        stack = []
        pre = None 
        curr = root 
        while stack or curr:
            if curr :
                stack.append(curr)
                curr = curr.left 
            else:
                node = stack.pop()
                if pre and node.val < pre.val:
                    return False 
                pre = node 
                curr = node.right 
        return True 
                 
if __name__ == "__main__":
    s = Solution()
    # n = Node(2)
    # n.left = Node(1)
    # n.right = Node(3)
    n = Node(1)
    n.left = None
    n.right = Node(2)
    res = s.isValidBST(n)
    print(res)
    
    