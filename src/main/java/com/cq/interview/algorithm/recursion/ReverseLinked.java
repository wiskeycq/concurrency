package com.cq.interview.algorithm.recursion;

import lombok.Getter;
import lombok.Setter;

/**
 * @author caoqiang
 * @date 2021/3/11下午2:40
 *
 * 反转单链表是一个常见的算法。例如链表为1->2->3->4。反转后为 4->3->2->1。
 */
public class ReverseLinked {

    public static Node reverseLink(Node head) {
        //递归的结束条件
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node newNode = reverseLink(head.next);
        // 改变1，2节点的指向
        // 通过head.next获取节点2
        Node t1 = head.next;
        // 让2的next指向 2
        t1.next = head;
        // 1的next指向null
        head.next = null;
        // 把调整之后的链表返回
        return newNode;
    }

    @Getter
    @Setter
    static class Node {
        int data;//数据
        Node next;//下一个节点

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }



    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node reverseNode = reverseLink(node1);
        System.out.println(reverseNode);
    }
}
