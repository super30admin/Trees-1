def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack=[]
        prev=None

        while stack or root:
            while root:
                stack.append(root)
                root=root.left
            root=stack.pop()

            if prev is not None and prev.val>=root.val:
                return False
            
            prev=root
            root=root.right

        return True
        