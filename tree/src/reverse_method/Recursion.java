package reverse_method;


import basestruct.TreeNode;

//递归
public class Recursion {

    //
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + "  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.left);
            System.out.print(node.val + "  ");

            midOrder(node.right);
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + "  ");
        }

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 1;
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(0);
        node.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(9);




        new Recursion().preOrder(node);
        System.out.println();
        new Recursion().midOrder(node);
        System.out.println();
        new Recursion().postOrder(node);
        System.out.println();

        TreeNode node2 = new TreeNode();
        node2.val = 0;
        node2.left  =new TreeNode(1);
        node2.right = new TreeNode(2);

        new Recursion().preOrder(node2);
        System.out.println();
        new Recursion().midOrder(node2);
        System.out.println();
        new Recursion().postOrder(node2);
    }

}
