# tc O(n), sc O(n).
indices = {val: idx for idx, val in enumerate(inorder)}

def rec(pstart, istart, iend):
    # base case
    if istart > iend:
        return None, pstart

    # recursive case
    val = preorder[pstart]
    node = TreeNode(preorder[pstart])
    val_in_inorder = indices[val]
    pstart += 1

    node.left, pstart = rec(pstart, istart, val_in_inorder-1)
    node.right, pstart = rec(pstart, val_in_inorder+1, iend)

    return node, pstart

return rec(0, 0, len(inorder)-1)[0]
