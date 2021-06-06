package com.cq.interview.algorithm.finalTest;

import com.alibaba.fastjson.JSON;

/**
 * @author caoqiang
 * @date 2021/6/5下午9:44
 */
public class ReverseLinked1 {

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        System.out.println(node1);
        System.out.println(JSON.toJSONString(node1));
        Node newNode = reverseLinked1(node1);
        System.out.println(newNode);
    }

    static class Node {
        int data; //数据
        Node nextNode; //下一个节点

        public Node(int data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    public static Node reverseLinked1(Node head) {
        if (head == null || head.nextNode == null) {
            return head;
        }
        Node newNode = reverseLinked1(head.nextNode);
        Node t1 = head.nextNode;
        t1.nextNode = head;
        head.nextNode = null;
        return newNode;
    }

}
