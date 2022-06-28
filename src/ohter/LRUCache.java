package ohter;
import sun.misc.Cache;

import java.util.*;




class LinkNode{
    int key,val;
    LinkNode front;
    LinkNode next;
    public LinkNode(int key,int val){
        this.key = key;
        this.val = val;
    }
}


public class LRUCache {
    LinkNode head = new LinkNode(0, 0);
    LinkNode tail = new LinkNode(0, 0);
    Map<Integer, LinkNode> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.front = head;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            movetofirst(node);
            return node.val;
        } else return -1;

    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) deletelast();
            LinkNode node = new LinkNode(key, value);
            LinkNode temp = head.next;
            head.next = node;
            node.front = head;
            node.next = temp;
            temp.front = node;
            map.put(key, node);
        } else {
            LinkNode newnode = map.get(key);
            newnode.val = value;
            movetofirst(newnode);
        }
    }

    public void deletelast() {
        LinkNode node = tail.front;
        node.front.next = tail;
        tail.front = node.front;
        map.remove(node.key);
    }

    public void movetofirst(LinkNode node) {
        node.front.next = node.next;
        node.next.front = node.front;
        LinkNode temp = head.next;
        head.next = node;
        node.front = head;
        node.next = temp;
        temp.front = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print(cache.head.next);
        cache.put(3, 3);
        System.out.println("  ");
        cache.print(cache.head.next);
        cache.get(2);
        System.out.println("  ");
        cache.print(cache.head.next);

    }

    void print(LinkNode node){
        while (node.val!=0){
            System.out.print(node.val);
            node = node.next;
        }
    }


}








/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */