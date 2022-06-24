'''
Morris Inorder Traversal
Time: O(n)
Space: O(1)
'''

def morris_inorder(self, root):
        curr = root
        
        while curr != None:
            if curr.left == None:
                print(curr.val)
                curr = curr.right
                
            else:
                pre = curr.left
                while pre.right != None and pre.right != curr:
                    pre = pre.right
                if pre.right == None:
                    pre.right = curr
                    curr = curr.left
                else:
                    print(curr.val)
                    pre.right = None
                    curr = curr.right