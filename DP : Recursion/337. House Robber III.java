// recursion + memorization

public class Solution {
    public int rob(TreeNode root) {
        return rob(root, new HashMap());
    }
    private int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left, map) + rob(root.left.right, map);
        }
        if (root.right != null) {
            val += rob(root.right.left, map) + rob(root.right.right, map);
        }
        int res = Math.max(val + root.val, rob(root.left, map) + rob(root.right, map));
        map.put(root, res);
        return res;
    }
}

// recursion + memo 2
public class Solution {
    Map<TreeNode, Integer> map = new HashMap();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int left = 0, right = 0;
        if (root.left != null) {
            left += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            right += rob(root.right.left) + rob(root.right.right);
        }
        int res = Math.max(rob(root.left) + rob(root.right), left + right + root.val);
        map.put(root, res);
        return res;
    }
}


// DP
public class Solution {
    public int rob(TreeNode root) {
        int[] res = robSub(root); // res[1]: rob, res[0]: not-rob
        return Math.max(res[0], res[1]);
    }
    
    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];
        int left[] = robSub(root.left);
        int right[] = robSub(root.right);
        
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
