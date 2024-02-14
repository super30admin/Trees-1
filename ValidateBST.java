// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 *
 */

// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class ValidateBST {
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        // return helperTraveseInOrder(root);

        this.flag = true;
        helperMinMax(root, null, null);
        return flag;
    }

    private void helperMinMax(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return;
        }

        if (min != null && root.val <= min) {
            flag = false;
        }

        if (max != null && root.val >= max) {
            flag = false;
        }

        helperMinMax(root.left, min, root.val);
        helperMinMax(root.right, root.val, max);
    }

    // private boolean helperTraveseInOrder(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     traveserInOrder(root, list);
    //     Comparator<Integer> intComparator = (i1, i2) -> Integer.compare(i1, i2);
    //     return isListSortedAndNoDuplicates(list, intComparator);
    // }

    // private void traveserInOrder(TreeNode node, List<Integer> list) {

    //     if (node != null) {
    //         traveserInOrder(node.left, list);
    //         list.add(node.val);
    //         traveserInOrder(node.right, list);
    //     }
    // }

    // private boolean isListSortedAndNoDuplicates(List<Integer> list, Comparator<Integer> intComparator) {
    //     Iterator<Integer> itera = list.iterator();

    //     Integer current, prev = itera.next();
    //     while (itera.hasNext()) {
    //         current = itera.next();
    //         int diff = intComparator.compare(prev, current);
    //         if (diff > 0) {
    //             return false;
    //         } else if (diff == 0) {
    //             return false;
    //         }
    //         prev = current;
    //     }

    //     return true;
    // }

}

class TreeNode {
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
