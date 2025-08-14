package Questions.EASY;

import java.util.*;
import Questions.EASY.SameTree.TreeNode;

public class VerticalOrder {
    class pair {
        int hd;
        TreeNode node;

        pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    Map<Integer, List<Integer>> map = new TreeMap<>();
    Queue<pair> q = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return res;
        q.add(new pair(0, root));
        while (!q.isEmpty()) {
            pair curr = q.poll();
            int hd = curr.hd;
            TreeNode node = curr.node;
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());

            }
            if (map.containsKey(hd)) {
                map.get(hd).add(node.val);
            }

            if (node.left != null)
                q.add(new pair(hd - 1, node.left));
            if (node.right != null)
                q.add(new pair(hd + 1, node.right));

        }
        for (List<Integer> val : map.values()) {
            res.add(val);
        }
        return res;
    }
}
