#time complexity: o(n) , traversing pre and inor list once so 0(2n) = o(n)
#space complexity:
#passed all cases on LeetCode:yes
#difficulty faced:-
# comments:in the code

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: 'List[int]', inorder: 'List[int]') -> 'Optional[TreeNode]':

        self.hmap = {}
        self.idx = 0

        if (len(preorder) == None or len(inorder) == None or preorder == None or inorder == None): return None

        #using the hmap to store indexes of root nodes bec while traversing preorder
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i

        #print(self.hmap)

        def helper(preorder,inorder, start, end):

            if start > end: return None
            #print(self.idx, preorder[self.idx])
            #for every element in the preorder list
            #we need to find the corresponding idx in inorder because that gives root idx and left and right of this lie left roots and right roots
            rootval = preorder[self.idx]
            self.idx += 1
            root = TreeNode(rootval)
            rootidx = self.hmap[rootval]
            #print(rootidx)
            print("start:", start)
            print("end:",rootidx-1 )
            #the above rootidx helps us finding left and right subtree roots for next iterations
            #imagine this example: Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
            #Output: [3,9,20,null,null,15,7]
            #the leftside of this root will be found from start of preord arr till rootidx
            root.left = helper(preorder,inorder, start, rootidx-1)
            #the rightside of this root will be found from rootidx+1 of preord arr till end
            root.right = helper(preorder,inorder,rootidx+1,end)

            #print(root.val)    

            return root

       

        return helper (preorder,inorder, 0, len(inorder)-1)
        


