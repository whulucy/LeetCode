//-----------------Problem Description------------------------------------------
/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
            1
           / \
          2  3
         / \
        4  5

return the root of the binary tree [4,5,2,#,#,3,1].
            4
           / \
          5   2
             / \
            3   1
*/

//思路，把左右的node, 都放到stack 里面， 然后依次pop stack 里面的node，
// 第一个node 是新的root, 2变成4的右孩子， 2的右孩子变成4的左孩子，需要把2的左右设为null

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode newRoot = stack.pop();
        cur = newRoot;
        while (!stack.isEmpty()){
            TreeNode oriParent = stack.pop();
            cur.right = oriParent;
            cur.left = oriParent.right;
            //为什么需要把oriParent 的左右变成null, if not nullified, it becomes nested, and will become endless cycle
            oriParent.left = null;
            oriParent.right = null;
            cur = oriParent;

        }
        return newRoot;
    }
}
