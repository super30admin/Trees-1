import { Tree } from "istanbul-lib-report";
import { help, number } from "yargs";

class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

// TC: O(N) SC: O(1)
function isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
  // Global Variables
  let is_same = true;
  // Recursive Function
  function helper(p_node: TreeNode | null, q_node: TreeNode | null) {
    if (p_node == null && q_node == null) {
      return;
    }

    if (
      (p_node == null && q_node != null) ||
      (p_node != null && q_node == null) ||
      p_node!.val != q_node!.val
    ) {
      is_same = false;
      return;
    }

    helper(p_node!.left, q_node!.left);
    if (is_same == false) return;
    helper(p_node!.right, q_node!.right);
  }

  // Main Method Call
  helper(p, q);

  return is_same;
}

// TC: O(N) SC: O(1)
function isSameTree_bool_based_recursion(
  p: TreeNode | null,
  q: TreeNode | null
): boolean {
  // Recursive Function
  function helper(p_node: TreeNode | null, q_node: TreeNode | null): boolean {
    if (p_node == null && q_node == null) {
      return true;
    }

    if (
      (p_node == null && q_node != null) ||
      (p_node != null && q_node == null) ||
      p_node!.val != q_node!.val
    ) {
      return false;
    }

    let left: boolean = helper(p_node!.left, q_node!.left);
    let right: boolean = helper(p_node!.right, q_node!.right);

    return left && right;
  }

  // Main Method Call
  return helper(p, q);
}

describe("Is Same Tree", () => {
  it("Happy Path", () => {
    let root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    expect(isSameTree(root, root)).toStrictEqual(true);
    expect(isSameTree_bool_based_recursion(root, root)).toStrictEqual(true);
  });

  it("Happy Path", () => {
    let root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);

    let root2 = new TreeNode(4);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(9);
    expect(isSameTree(root, root2)).toStrictEqual(false);
    expect(isSameTree_bool_based_recursion(root, root2)).toStrictEqual(false);
  });
});
