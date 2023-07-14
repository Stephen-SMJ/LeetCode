package template;

class doubleListNode{
    int val;
    doubleListNode next;
    doubleListNode prev;
    doubleListNode(){}
    doubleListNode(int val){
        this.val = val;
    }
    doubleListNode(int val, doubleListNode next, doubleListNode prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
class MyLinkedList {
    int size; //from 1
    doubleListNode head;
    doubleListNode tail;

    public MyLinkedList() {
        int size = 0;
        this.head = new doubleListNode(0);
        this.tail = new doubleListNode(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    public int getOptimal(int index) {  //双链表的优势：可以从两个方向去查找，计算index在mid左边还是右边。从更短的方向去找。
        if (index > this.size-1 || index < 0){
            return -1;
        }

        doubleListNode cur = head;
        if(index <= this.size/2){
            while(index >= 0){
                cur=cur.next;
                index--;
            }
        }else{
            cur = tail;
            while(size-index > 0){ //3 5
                cur = cur.prev;
                index++;
            }
        }
        return cur.val;
    }

    public int get(int index) {
        if (index > this.size-1 || index < 0){
            return -1;
        }

        doubleListNode cur = head;
        while(index >= 0){
            index--;
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        doubleListNode node = new doubleListNode(val, this.tail, this.tail.prev);
        this.tail.prev.next = node;
        this.tail.prev = node;
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size || index < 0){ //size = 3, 插入3
            return;
        }else if(index == this.size){
            addAtTail(val);
            return;
        }

        doubleListNode cur = head;
        doubleListNode node = new doubleListNode(val);
        while(index >= 0){
            index--;
            cur = cur.next;
        }
        node.next=cur;
        node.prev=cur.prev;
        cur.prev.next=node;
        cur.prev=node;
        this.size++;

    }

    public void deleteAtIndex(int index) {
        if (index > this.size-1){
            return;
        }
        doubleListNode cur = head;
        while(index >= 0){
            index--;
            cur = cur.next;
        }
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
        this.size--;
    }
}

public class DoubleLinkList {


    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        int val = myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        int val2 = myLinkedList.get(1);             // 返回 3

    }
}
