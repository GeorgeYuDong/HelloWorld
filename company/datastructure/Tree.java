package company.datastructure;


public class Tree<E> {
    E item;
    Tree<E> left;
    Tree<E> right;

    public Tree(E item) {
        this.item = item;
    }

    public Tree<E> bulidLeft(E item) {
        this.left = new Tree<>(item);
        return this.left;
    }

    public Tree<E> bulidRight(E item) {
        this.right = new Tree<>(item);
        return this.right;
    }

    /**
     * public void printPreOrder() {
     * System.out.println(this.item + ">");
     * print(this.left);
     * print(this.right);
     * }
     */

    //前序遍历，是把root先遍历，然后左边一条线遍历完，然后遍历右边一条线
    //再把右边的node当做root,按照上面的步骤再来一遍,依次递归
    public void printPreOrder(Tree<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.item + ">");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        Tree<Integer> root = new Tree<>(10);
        Tree<Integer> left = root.bulidLeft(6);
        Tree<Integer> left_1 = left.bulidLeft(4);
        left_1.bulidLeft(2);
        left.bulidRight(8);
        Tree<Integer> right = root.bulidRight(18);
        right.bulidLeft(13);
        right.bulidRight(20);
        root.printPreOrder(root);
    }
}
