"""
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/submissions/
"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None


class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        """
        The idea is fairly simple (and the same as finding the convergence point of 2 linked lists).
         We keep two pointers, p1 and p2. Originally, these pointers point to q and p,
         respectively. Then we follow their parent pointers until they point to the same node.
         When either of the pointers points to root, we set it to the other original starting node.
         For example, when p1 points to root (i.e p1.parent is None), assign q to p1.


        """
        
        
        p1,p2=p,q
        while p1!=p2:
            if p1.parent:
                p1=p1.parent
            else:
                p1=q
            if p2.parent:
                p2=p2.parent
            else:
                p2=p
        return p1
        
        
        
        






#         p1, p2 = p, q
#         while p1 != p2:
#             p1 = p1.parent if p1.parent else q
#             p2 = p2.parent if p2.parent else p

#         return p1


"""