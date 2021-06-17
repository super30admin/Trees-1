# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time Complexity: O(n2)
# Spcae Compelxity : O(n2)
class Solution(object):
    #     Defined output array
    out_arr = []

    def buildTree(self, preorder, inorder):
        #       if preorder is null then retrun none
        if len(preorder) == 0:
            return None
        #        as first elemnet in preorder will be always root value of the tree
        current_head = preorder[0]

        #         Define root with current value
        curr_node = TreeNode(current_head)

        curr_index = 0
        #         Iterate over inoreder array to get the current root index and append that in output array
        for i in range(len(inorder)):
            if inorder[i] == current_head:
                curr_index = i
                self.out_arr.append(inorder[i])

        #       Now we found the index of root then to get its childern we will make 4 array left  and right in both left and right array

        pl = preorder[1:curr_index + 1]

        pr = preorder[curr_index + 1: len(preorder)]

        il = inorder[0: curr_index]
        ir = inorder[curr_index + 1: len(inorder)]

        #      call the same function recursively as we are going to assign left and righ t child for current root

        curr_node.left = self.buildTree(pl, il)
        curr_node.right = self.buildTree(pr, ir)

        return current
        root in the
        end
        return curr_node

        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
