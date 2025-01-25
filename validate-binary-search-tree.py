# tc O(n), sc O(n).
stack = deque()
prev = float('-inf')

while root or stack:
    while root:
        stack.append(root)
        root = root.left
    root = stack.pop()
    if root.val <= prev:
        return False
    prev = root.val
    root = root.right

return True