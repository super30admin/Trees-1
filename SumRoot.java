import java.util.*;

public class SumRoot {

    class Pair {
        TreeNode node;
        int value;

        public Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }

        public TreeNode getNode() {
            return this.node;
        }

        public int getValue() {
            return this.value;
        }
    }

    public int sumRoot(TreeNode root) {
        int result = 0;
        int num = 0;
        Stack<Pair> s = new Stack<>();

        while (root != null || !s.isEmpty()) {

            while (root != null) {
                // N
                num = num * 10 + root.val;
                Pair pair = new Pair(root, num);
                s.push(pair);
                // L
                root = root.left;
            }
            Pair pair = s.pop();
            root = pair.getNode();
            num = pair.getValue();

            if (root.left == null && root.right == null) {
                result += num;
            }
            root = root.right;
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
