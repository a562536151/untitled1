package ListNODE;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}

public class list {
    public ListNode buildList(int[] a){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 0;i<a.length;i++){
            ListNode node = new ListNode(a[i]);
            cur.next = node;
            cur = cur.next;
        }
        cur = head;
        return cur.next;
    }

    public void print(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        list lists = new list();
        int[] arr = new int[]{1,3,5,7,1};
        ListNode head = lists.buildList(arr);
//        head = lists.delete(head,5);
//        head = lists.delete(head,1);
//        head = lists.delete(head,3);
        lists.insert(head,1,2);
        lists.print(head);
    }


    public ListNode delete(ListNode head, int val) {
        if(head.val==val) {
            head = head.next;
            return head;
        }
        ListNode cur =head.next,pre = head;
        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                return head;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return null;
    }

    private void insert(ListNode head, int lo, int j) {
        ListNode node = new ListNode(j);
        ListNode cur = head.next,pre = head;
        for(int i = 1;i<lo;i++){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = node;
        node.next = cur;

    }


//    private void insert(ListNode head, int i, int j) {
//        int count = 0;
//        ListNode node = new ListNode(j);
//            while(count<i-1){
//                head = head.next;
//                count++;
//            }
//            ListNode temp = head.next;
//            head.next = node;
//            node.next = temp;
//    }


}



