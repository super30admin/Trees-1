class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
#O(N)
#O(N)
#1st value of preorder is root
#get that values's index from inorder and traverse from (srt...index-1) for left side and (index+1...end) for right side
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        def helper(in_left, in_right):
            if in_left > in_right:
                return None

            root_val = preorder.pop(0)
            root_index = inorder_map[root_val]
            root = TreeNode(root_val)
            root.left = helper(in_left, root_index - 1)
            root.right = helper(root_index + 1, in_right)
            return root
        
        inorder_map = {value:index for index, value in enumerate(inorder)}
        return helper(0, len(inorder)-1)
