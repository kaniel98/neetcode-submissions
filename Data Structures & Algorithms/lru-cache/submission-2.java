class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;

    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        removeNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (map.size() == capacity) {
                ListNode removed = head;
                removeNode(head);
                map.remove(removed.key);
            }
            ListNode newNode = new ListNode(key, value);
            addNode(newNode);
            map.put(key, newNode);
        }
    }

    private void addNode(ListNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = null;
            node.prev = null;
        } else {
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    private void removeNode(ListNode node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private static class ListNode {
        public int key;
        public int value;
        public ListNode prev;
        public ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}