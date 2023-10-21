package reverse;

import java.util.ArrayList;
import basestruct.TreeNode;
public class SumPath {
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        //定义result用来存累加和结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfs(result, new ArrayList<>(), root, sum);
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);

        dfs(result, list, root.left, sum - root.val);
        dfs(result, list, root.right, sum - root.val);

        list.remove(list.size() - 1);
    }
}
