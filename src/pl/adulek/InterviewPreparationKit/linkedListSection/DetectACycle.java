package pl.adulek.InterviewPreparationKit.linkedListSection;

import java.util.HashMap;
import java.util.Map;

public class DetectACycle {

    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

//    static boolean hasCycle(Node head) {
//        if (head == null) {
//            return false;
//        }
//    }

    static boolean hasCycle(Node head) {
        if (head == null || head.next==null) {
            return false;
        }
        Map<Integer, Node> visited = new HashMap<Integer, Node>();
        Node curr = head;
        visited.put(curr.data, curr);
        while (curr.next != null) {
            if(visited.containsValue(curr.next)) {
                return true;
            }
            visited.put(curr.data, curr);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(hasCycle(new Node(1, null)));
//        System.out.println(hasCycle(new Node(1, new Node(2, null))));
//        System.out.println(hasCycle(new Node(1, new Node(2, new Node(3, null)))));
        Node firstNode = new Node(1, null);
        Node Node2 = new Node(2, null);
        firstNode.next = Node2;
        Node Node3 = new Node(3, firstNode);
        Node2.next = Node3;
        System.out.println(hasCycle(firstNode));

        firstNode.next = firstNode;
        System.out.println(hasCycle(firstNode));

        firstNode.next = Node2;
        Node2.next = Node3;
        Node3.next = Node2;
        System.out.println(hasCycle(firstNode));

    }
}
