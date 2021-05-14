# time complexity : 0(n)
#space complexity : 0(1)

class node:
    
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None


prev = float('-inf')
def is_valid_bst(root):

    if root is None:
        return True
    global prev
    if not is_valid_bst(root.left):
        return False
    if root.val < prev:
        return False
    
    prev = root.val

    return is_valid_bst(root.right)

root = node(10)
root.left = node(2)
root.right = node(15)
root.left.left = node(1)
root.left.right = node(4)
 
if is_valid_bst(root):
    print("it is bst")
else:
    print("not bst")