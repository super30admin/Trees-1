import { Tree } from "istanbul-lib-report";
import { number } from "yargs";

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

// N = Number of nodes in the tree
// TC: O(N) SC: O(1)
function maxDepth(root: TreeNode | null): number {
  function traverse(root: TreeNode | null, depth: number): number {
    if (root == null) return depth;

    let left_depth = traverse(root.left, depth + 1);
    let right_depth = traverse(root.right, depth + 1);

    return Math.max(left_depth, right_depth);
  }

  return traverse(root, 0);
}

describe("Max Depth", () => {
  it("Happy Path", () => {
    let root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    expect(maxDepth(root)).toStrictEqual(3);
  });

  it("Negative", () => {
    let root = new TreeNode(3);
    expect(maxDepth(root)).toStrictEqual(1);
  });
});
