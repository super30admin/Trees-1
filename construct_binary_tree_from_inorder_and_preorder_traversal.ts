import { help } from "yargs";

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

//
function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
  let root = helper(preorder, inorder);
  return null;
}

let helper = function (preorder: number[], inorder: number[]): TreeNode | null {
  if (preorder.length == 0 && inorder.length == 0) return null;

  let root = new TreeNode(preorder[0]);

  let root_idx = 0;

  for (let index = 0; index < inorder.length; index++) {
    if (inorder[index] == root.val) {
      root_idx = index;
      break;
    }
  }
  let leftInorder: number[] = inorder.slice(0, root_idx);
  let rightInorder: number[] = inorder.slice(root_idx + 1, inorder.length);

  let leftPreorder: number[] = preorder.slice(1, leftInorder.length + 1);

  let rightPreorder: number[] = preorder.slice(
    leftPreorder.length + 1,
    preorder.length
  );

  root.left = helper(leftPreorder, leftInorder);
  root.right = helper(rightPreorder, rightInorder);

  return root;
};

let pre_order_idx: number = 0;
let map = new Map<number, number>();
function buildTree_optimised(
  preorder: number[],
  inorder: number[]
): TreeNode | null {
  // Build Map
  for (let index = 0; index < inorder.length; index++) {
    map.set(inorder[index], index);
  }
  // Call The Helper
  let root = helper_optimised(preorder, 0, (inorder.length - 1));
  return root;
}

let helper_optimised = (
  preorder: number[],
  start: number,
  end: number
): TreeNode | null => {
  if (start > end) return null;

  let root_val: number = preorder[pre_order_idx];
  let root = new TreeNode(root_val);
  let root_idx_in_inorder: number = map.get(root_val)!;
  pre_order_idx += 1;

  root.left = helper_optimised(preorder, start, root_idx_in_inorder - 1);
  root.right = helper_optimised(preorder, root_idx_in_inorder + 1, end);

  return root;
};

describe("Find Max Profit", () => {
  it("Backtracking Happy Path", () => {
    expect(
      buildTree_optimised([3, 9, 20, 15, 7], [9, 3, 15, 20, 7])
    ).toStrictEqual([
      [5, 4, 11, 2],
      [5, 8, 4, 5],
    ]);
  });

  it("Backtracking Happy Path 02", () => {
    expect(
      buildTree_optimised([-1], [-1])
    ).toStrictEqual([
      [5, 4, 11, 2],
      [5, 8, 4, 5],
    ]);
  });
});
