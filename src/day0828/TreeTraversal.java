package day0828;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    public static class Node {
        char val;
        Node left = null;
        Node right = null;

        public Node(char val) {
            this.val = val;
        }
    }

    public static Node bulid() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //循环取出队首元素,然后访问改元素
    //当前元素左子树如果非空,就入队列,然后再看当前元素的右子树如果也非空,也入队列
    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = bulid();
        preOrder(root);
        System.out.println();
        System.out.println("--------------");
        inOrder(root);
        System.out.println();
        System.out.println("--------------");
        postOrder(root);
    }
}
