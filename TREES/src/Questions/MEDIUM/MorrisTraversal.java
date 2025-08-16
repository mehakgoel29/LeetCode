package Questions.MEDIUM;
import Questions.EASY.SameTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/* Approach / Intuition for Morris Inorder Traversal:

1. Jab tak current NULL nahi hai:

   Case A: Agar current ka left child NULL hai:
       * Matlab left subtree nahi hai, to current ko visit (print/store) karo.
       * Current = current.right kar do (right subtree traverse karne ke liye).

   Case B: Agar current ka left child hai:
       * To left subtree ka predecessor (rightmost node) dhoondo:
         → temp = current.left lo
         → jab tak temp.right != NULL && temp.right != current,
           tab tak temp = temp.right move karo
         (yeh ensure karega ki left subtree ka rightmost node mil jaye).

       * Ab do situation ho sakti hain:

         (i) Agar predecessor.right == NULL:
             * Iska matlab abhi tak link create nahi hua hai.
             * To predecessor.right = current set karo
               (temporary thread banate hain taaki wapas current pe laut sako).
             * Fir current = current.left kar do
               (kyunki ab pehle left subtree traverse karna hai).

         (ii) Agar predecessor.right == current:
             * Matlab left subtree complete traverse ho chuka hai aur
               hum wapas thread ke through current pe aaye hain.
             * To pehle predecessor.right = NULL kar do
               (thread tod do, original tree restore ho jaye).
             * Fir current ko visit (print/store) karo.
             * Fir current = current.right kar do
               (ab right subtree traverse karna hai).

2. Ye process continue karo jab tak current NULL na ho jaye.
   Har step me ya to ek new link banta hai, ya ek link todta hai aur node visit hoti hai.
   Isse O(n) time aur O(1) extra space me inorder traversal milta hai.
*/

public class MorrisTraversal {
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode leftChild = curr.left;
                //Find rightmost node of left subtree
                while (leftChild.right != null && leftChild.right != curr) {
                    // Predecessor milte hi (right == null ya right == curr) loop ruk jaye, isliye && use karte hain; || hota to loop rukta hi nahi

                    leftChild = leftChild.right;
                }

                if (leftChild.right == null) {
                    leftChild.right = curr; // make thread
                    curr = curr.left;
                } else {
                    leftChild.right = null; // break thread
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode leftChild = curr.left;
                //Find rightmost node of left subtree
                while (leftChild.right != null && leftChild.right != curr) {
                    leftChild = leftChild.right;
                }

                if (leftChild.right == null) {
                    leftChild.right = curr;  // make thread
                    res.add(curr.val);
                    curr = curr.left;
                } else {
                    leftChild.right = null;  // break thread
                    curr = curr.right;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        // Example tree
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(inorderTraversal(root));
        System.out.println(preorderTraversal(root));
    }
}
