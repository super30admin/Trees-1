/*
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Not tried on Leetcode.
Any problem you faced while coding this : Referred from geeksforgeeks
*/

import java.util.*;
class Pnode {
    int data;
    Pnode left, right;

    Pnode(int item)
    {
        data = item;
        left = right = null;
    }
}

class tree {
    Pnode root;
    static int preIndex = 0;

    static Pnode buildTree(int in[], int pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

        Pnode tNode = new Pnode(pre[preIndex++]);

        if (inStrt == inEnd)
            return tNode;

        int inIndex = search(in, inStrt, inEnd, tNode.data);

        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }
    static int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    static void printInorder(Pnode node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[])
    {
        int in[] = new int[] { 9,3,15,20,7 };
        int pre[] = new int[] { 3,9,20,15,7 };
        int len = in.length;
        Pnode root = tree.buildTree(in, pre, 0, len - 1);

        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}