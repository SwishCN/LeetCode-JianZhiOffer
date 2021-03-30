/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        //获取根节点val值
        TreeNode root = new TreeNode(preorder[0]);
        //获取根节点在中序遍历中位置
        int index = findIndex(preorder, inorder);
        //递归构建左子树
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        //递归构建右子树
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    ////获取根节点在中序遍历中位置
    public int findIndex(int[] preorder, int[] inorder) {

        for (int i = 0; i < preorder.length; i++) {

            //前序遍历数组中第一个元素即为根节点
            if (inorder[i] == preorder[0]) {
                return i;
            }

        }

        return 0;

    }
    
}