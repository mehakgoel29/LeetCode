package Questions.EASY;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p==null || q==null) return false;

        if(p.val==q.val){

            //both subtree must be identical
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        else{
            return false;
        }

    }

    public static class TreeNode {
          public int val;
          public TreeNode left;
          public TreeNode right;
          TreeNode() {}
          public TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

}
