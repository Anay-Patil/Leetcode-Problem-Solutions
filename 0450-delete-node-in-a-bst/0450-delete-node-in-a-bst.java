/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else {  //key found
            //if node is leaf
            if(root.left == null && root.right == null) {
                return null;
            }
            else if(root.left == null) {
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else {
                TreeNode succ = findSucc(root);
                root.val = succ.val;
                root.right = deleteNode(root.right, succ.val);
            }
        }
        return root;
    }

    private TreeNode findSucc(TreeNode root) {
        TreeNode temp = root.right;
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
}