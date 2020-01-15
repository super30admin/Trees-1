from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        """
            // Time Complexity : O(n^2) if recursive stack

                    For each child node, we are traversing the left or right half
                    There are 'n' nodes.
                                O(n) without recursive stack

           // Space Complexity : O(n)
                    We are creating sub arrays of 2(n-1) at each recursive step.

           // Did this code successfully run on Leetcode : Yes
           // Any problem you faced while coding this : Logic
           // Three line explanation of solution in plain english:
                Example:

                Root, Left, Right
                Preorder -> [ 3,  10,  12,  9,  8,  15,  9]
                              |
                            Root
                Not sure where left and right is, so use inorder to figure out

                Left, Root, Right
                Inorder  -> [10,  12,   9,  3, 15,  19,  8]
                             ------------   |  -----------
                        Left sub tree     Root      Right sub tree
                                          (idx)

                Not sure where root is, so use preorder to figure out

                Only the left sub tree and root are interchanged, the right subtree is always
                at the last.
                - First figure out the root from preorder. We know that it is always the first
                  element.
                - Figure out the root index in inorder. We now know the left and right subtrees.
                - The left inorder subtree ends before the inorder root
                - The right inorder subtree starts after the inorder root
                - The preorder left subtree starts after the root but ends exactly at the inorder root
                - The preorder right subtree starts right after the inorder root

        """
        # Preorder -Root Left Right
        # Inorder - Left Root Right

        if not preorder or not inorder:
            return None

        # inorder root index
        idx = -1
        # create the root as preorder first element is always the roo
        root = TreeNode(preorder[0])
        # find the index of the preorder element in inorder to build
        # left and right sub trees
        for i in range(len(inorder)):
            if inorder[i] == preorder[0]:
                idx = i
                break
        # inorder left starts from 0 ends at root-1
        in_left = inorder[:idx]
        # inorder right starts at root +1 and ends at len(inorder)-1
        in_right = inorder[idx + 1:]
        # preorder left starts at root + 1 and ends at inorder_root+1
        pre_left = preorder[1:idx + 1]
        # preorder right starts at inorder_root+1 and ends at len(preorder)-1
        pre_right = preorder[idx + 1:]
        root.left = self.buildTree(pre_left, in_left)
        root.right = self.buildTree(pre_right, in_right)
        return root


if __name__ == '__main__':
    h = Solution()
    print(h.buildTree([3, 9, 20, 15, 7], [9, 3, 15, 20, 7]))
