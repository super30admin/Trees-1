
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def buildTree(preorder, inorder):

    def array_to_tree(left, right, preorder_index=0):
        if left > right: return None

        # select the preorder_index element as the root and increment it
        root_value = preorder[preorder_index]
        root = TreeNode(root_value)


        preorder_index += 1

        # build left and right subtree
        # excluding inorder_index_map[root_value] element because it's the root
        root.left = array_to_tree(left, inorder_index_map[root_value] - 1, preorder_index)
        root.right = array_to_tree(inorder_index_map[root_value] + 1, right, preorder_index)

        return root

    preorder_index = 0
    '''
    build a hash map of inorder traversal with its value as key and index as value
    '''
    inorder_index_map = {}
    for index, value in enumerate(inorder):
        inorder_index_map[value] = index

    return array_to_tree(0, len(preorder) - 1, preorder_index)

'''
Complexity analysis
Time complexity O(N) n elements in tree, and also n recursive calls
Space complexity O(N) n elements in creating hashmap
'''