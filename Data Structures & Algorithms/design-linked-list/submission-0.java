class MyLinkedList {

    private ListNode head; 
    private ListNode tail; 
    private int size = 0;

    public MyLinkedList() {
    
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        if (head == null) {
            init(val);
            return; 
        }

        ListNode temp = new ListNode();
        temp.val = val;
        temp.next = head;
        head.prev = temp;
        head = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        if (tail == null) {
            init(val);
            return;
        }

        ListNode temp = new ListNode();
        temp.val = val;
        temp.prev = tail;
        tail.next = temp;
        tail = temp;
        size++;
    }

    private void init(int val) {
        ListNode temp = new ListNode();
        temp.val = val;
        head = temp; 
        tail = temp; 
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
            ListNode newNode = new ListNode();
            newNode.val = val;
            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev.next = newNode;
            curr.prev = newNode;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            ListNode curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        size--;
    }

    public static class ListNode {
        private ListNode next;
        private ListNode prev;
        private int val;

        public ListNode () {
            next = null;
            prev = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }
    }
}