package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/8/12 0:13
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
