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

// TC: O(N) SC: O(1)
function findMode(root: TreeNode | null): number[] {
  let result: number[] = [];
  let count = 0;
  let max = 0;
  let previous: TreeNode | null = root;

  function helper(root: TreeNode | null) {
    if (root == null) return;

    helper(root.left);

    if (previous != null && previous.val == root.val) {
      count += 1;
    } else {
      count = 1;
    }
    previous = root;
    if (count == max) {
      result.push(root.val);
    } else if (count > max) {
      result = [root.val];
      max = count;
    }

    helper(root.right);
  }

  helper(root);
  return result;
}

describe("Find Modes", () => {
  it("Happy Path", () => {
    let root = new TreeNode(4);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(2);
    root.left.left.right = new TreeNode(3);
    root.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    root.right.right.left = new TreeNode(6);
    root.right.right.right = new TreeNode(6);
    expect(findMode(root)).toStrictEqual([3, 4, 6]);
  });
});
