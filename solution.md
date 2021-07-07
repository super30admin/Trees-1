# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
N/A
## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
    class TreeNode:
      def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

      class Solution:
          def isValidBST(self, root, lessThan = float('inf'), largerThan = float('-inf')):
              if not root:
                  return True
              if root.val <= largerThan or root.val >= lessThan:
                  return False
              return self.isValidBST(root.left, min(lessThan, root.val), largerThan) and \
                     self.isValidBST(root.right, lessThan, max(root.val, largerThan))
                     
# Problem 2
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
N/A
## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
        class TreeNode:
           def __init__(self, x):
               self.val = x
               self.left = None
               self.right = None

        class Solution:
            def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
                if not preorder:
                    return None

                m = {}
                for i in range(0, len(inorder)):
                    m[inorder[i]] = i
                return self.helper(preorder, 0, len(preorder), m, [0])


            def helper(self, preorder, start, end, m, curr):
                if start == end:
                    return None
                if start == end - 1:
                    node = TreeNode(preorder[curr[0]])
                    curr[0] += 1
                    return node

                node = TreeNode(preorder[curr[0]])
                curr[0] += 1

                i = m[node.val]
                node.left = self.helper(preorder, start, i, m, curr)
                node.right = self.helper(preorder, i + 1, end, m, curr)
                return node
