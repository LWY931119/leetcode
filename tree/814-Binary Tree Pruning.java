/*
*给出一棵树，树的节点值只有0，1两种取值。若该树的子树中所有节点的值为0则删除该子树。
*给出两个函数来解决这个问题，containsOne判断该树中所有节点的值是否全为0.
*主函数pruneTree根据containsOne的结果分别处理该树的根，左，右。两个函数都是递归来做。
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        if(!containsOne(root))return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }
    public boolean containsOne(TreeNode root){
        if(root == null)return false;
        if(root.val == 1)return true;
        else return containsOne(root.left) || containsOne(root.right);
    }
}
