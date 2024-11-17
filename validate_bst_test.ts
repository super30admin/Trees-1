import { Tree } from "istanbul-lib-report";

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

// TC: O(N)  SC: O(1)
function isValidBST(root: TreeNode | null): boolean {
  // Global Variables
  let flag: boolean = true;
  let prev_min: number | null = null;
  let prev_max: number | null = null;

  // Recursive Function
  function helper(
    root: TreeNode | null,
    min: number | null,
    max: number | null,
    previous_min: number | null,
    previous_max: number | null
  ) {
    if (root == null) return;

    if (min != null && root.val <= min) {
      flag = false;
    }

    if (max != null && root.val >= max) {
      flag = false;
    }

    helper(root.left, min, root.val, min, max);
    helper(root.right, root.val, max, min, max);
    prev_min = previous_min;
    prev_max = previous_max;
  }

  helper(root, null, null, prev_min, prev_max);
  return flag;
}

// TC: O(N)  SC: O(1)
function isValidBSTV2(root: TreeNode | null): boolean {
  // Global Variables
  let flag: boolean = true;
  let previous: TreeNode | null = null;

  // Recursive Function
  function helper(root: TreeNode | null) {
    if (root == null) return;

    helper(root.left);

    if (previous != null && previous.val >= root.val) {
      flag = false;
      return;
    }
    previous = root;

    helper(root.right);
  }

  helper(root);
  return flag;
}

// TC: O(N)  SC: O(1)
function isValidBSTV3(root: TreeNode | null): boolean {
  // Global Variables
  let flag: boolean = true;
  let previous: TreeNode | null = null;

  // Recursive Function
  function helper(root: TreeNode | null, previous: TreeNode | null) {
    if (root == null) return;

    helper(root.left, previous);

    if (previous != null && previous.val >= root.val) {
      flag = false;
    }
    previous = root;

    helper(root.right, previous);
  }

  helper(root, previous);
  return flag;
}

describe("Find Max Profit", () => {
  it("Happy Path", () => {
    let root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    expect(isValidBST(root)).toStrictEqual(true);
  });

  it("Happy Path V2", () => {
    let root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    expect(isValidBSTV2(root)).toStrictEqual(true);
  });

  it("Happy Path V3", () => {
    let root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    expect(isValidBSTV3(root)).toStrictEqual(true);
  });
});
