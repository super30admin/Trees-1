#Time Complexity: O(n)
#Space Complexity: O(log n ) (recursion stack) 
#LeetCode: yes
class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

class Solution:
    def isValidateBST(self, root):
        def isValid(node, left_range, right_range):
            if node is None:
                return True
            
            if not (node.data>left_range and node.data<right_range):
                return False
            
            return (isValid(node.left, left_range, node.data) and isValid(node.right, node.data, right_range))
        return isValid(root, float("-inf"), float("inf"))


a = Node(2)
a.left = Node(1)
a.right = Node(3)

obj = Solution()
print(obj.isValidateBST(a))