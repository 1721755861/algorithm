package reverse;

import basestruct.TreeNode;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 1;
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(0);
        node.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(9);

        depthOrderTraversal(node);
    }

    /**
     * 用栈实现非递归深度遍历二叉数
     * 这个深度遍历是先序遍历
     * @param root
     */
    public static void depthOrderTraversal(TreeNode root) {
        //非空判断
        if (root == null) {
            return;
        }

        //创建一个栈，并把根节点root存进去
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        //用while循环遍历，
        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            System.out.print(" ");
        }
    }


    //先序遍历，迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }


    //后序遍历，迭代
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(node.val);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

}
