package Questions.EASY;

import java.util.*;
import Questions.EASY.SameTree.TreeNode;

public class TopView {

    // Helper class to store node + its horizontal distance (hd)
    class pair {
        int hd;         // horizontal distance from root
        TreeNode node;  // reference to current node
        pair(TreeNode node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }

    // Final result list (left to right)
    ArrayList<Integer> res = new ArrayList<>();
    // Queue for BFS traversal
    Queue<pair> q = new LinkedList<>();
    // TreeMap to store first node of each HD (keys auto-sorted)
    Map<Integer, Integer> map = new TreeMap<>();

    ArrayList<Integer> topView(TreeNode root) {
        // Edge case: if tree is empty
        if (root == null) return res;

        // Start BFS from root, with hd = 0
        q.add(new pair(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            pair curr = q.poll();
            int hd = curr.hd;
            TreeNode node = curr.node;

            // If this HD is not in map yet, this is the topmost node for it
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            // Add left child with hd - 1
            if (node.left != null) {
                q.add(new pair(node.left, hd - 1));
            }
            // Add right child with hd + 1
            if (node.right != null) {
                q.add(new pair(node.right, hd + 1));
            }
        }

        // TreeMap keys are sorted, so values will be left-to-right
        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}
