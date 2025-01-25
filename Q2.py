############# Construct Tree from Preorder and Inorder ############

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# recursively build the tree by using the inorder traversal to get the node and the preorder traversal to get the left and right.


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def constructTree(inorder,preorder):
        if not preorder or not inorder:
            return None

        index_map = {}

        for i in range(len(inorder)):
            index_map[inorder[i]] = i
        
        a = [0]

        def compute(start,end):
             if start > end:
                return None
                
             root = TreeNode(preorder[a[0]])
             root_idx = index_map[preorder[a[0]]]
             a[0]+=1

             root.left = compute(start,root_idx-1)
             root.right = compute(root_idx+1,end)

             return root

        return compute(0,len(preorder)-1)
        
