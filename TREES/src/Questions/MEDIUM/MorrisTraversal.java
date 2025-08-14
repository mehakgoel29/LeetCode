package Questions.MEDIUM;
import Questions.EASY.SameTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Approach / Intuition:

1. Agar current node ka left child nahi hai:

   * Node ko visit (print) karo.
   * Current ko uske right child pe move karo.

2. Agar current node ka left child hai:

   * Left subtree ka sabse right node (predecessor) dhoondo:
     → current.left se start karo
     → jab tak uska right NULL nahi hai, right me jaate raho
     (tab tak jao jab tak tumhe left subtree ka last/rightmost node na mil jaye).

   * Ab predecessor ka right pointer temporarily current node pe set karo.
     Iska matlab: "jab left subtree complete ho jaye, to wapas yahan aa jana".

   * Current node ka left pointer NULL kar do
     (ye isliye taaki dobara left side me na ghuso, warna loop ban jayega).

   * Ab current ko uske left child pe move karo.
     (Kyuki ab hum left subtree explore karne jaa rahe hain.)

3. Ye process tab tak repeat karo jab tak current NULL na ho jaye:

   * Har step me ya to directly right move hota hai,
     ya left me jaake pointer adjust hote hain.

*/
public class MorrisTraversal {
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                res.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode leftChild=curr.left;
                while (leftChild.right!=null){
                    leftChild=leftChild.right;
                }
                leftChild.right=curr;

                TreeNode temp=curr;
                curr=curr.left;
                temp.left=null;
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
    }
}
