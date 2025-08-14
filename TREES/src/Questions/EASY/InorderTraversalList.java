package Questions.EASY;

import java.util.ArrayList;
import java.util.List;
import Questions.EASY.SameTree.TreeNode;

public class InorderTraversalList {
    List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public static void main(String[] args) {
        // Sample tree creation:
        //        1
        //       / \
        //      2   3
        //     / \    \
        //    4   5    6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        InorderTraversalList obj = new InorderTraversalList();
        List<Integer> result = obj.inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);
    }

}
