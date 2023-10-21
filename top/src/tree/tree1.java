package tree;

import basestruct.TreeNode;

public class tree1 {


    //二叉树中是否存在节点和为指定值的路径
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     *
     * return a||b的意思就是如果a是true则返回a,否则返回b
     * return a&&b的意思就是如果a是true就则返回b，否则返回a
     * return a,b,c的意思就是返回c
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root == null)
            return false;

        sum -= root.val;

        //
        if (sum == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

//    public  what(){
//        double s = Math.random();
//
//        return s;
//    }

    public static void main(String[] args) {

        System.out.println(Math.random()*10);
        Thread
    }
}
