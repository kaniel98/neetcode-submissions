class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Node> heap = constructHeap(a, b, c);
        while (!heap.isEmpty()) {
            Node curr = heap.poll();
            int len = sb.length();

            if (len > 1 && sb.charAt(len - 1) == curr.chr && sb.charAt(len - 2) == curr.chr) {
                // We will get another node
                if (heap.isEmpty()) {
                    break;
                }
                Node next = heap.poll();
                sb.append(next.chr);
                next.count--;
                if (next.count > 0) {
                    heap.offer(next);
                }
                heap.offer(curr);
            } else {
                sb.append(curr.chr);
                curr.count--;
                if (curr.count > 0) {
                    heap.offer(curr);
                }
            }
        }

        return sb.toString();
    }

    private PriorityQueue<Node> constructHeap(int a, int b, int c) {
        PriorityQueue<Node> heap = new PriorityQueue<>((nodeA, nodeB) -> {
            return nodeB.count - nodeA.count; // Max heap for the count;
        });

        if (a > 0)
            heap.offer(new Node('a', a));
        if (b > 0)
            heap.offer(new Node('b', b));
        if (c > 0)
            heap.offer(new Node('c', c));
        return heap;
    }

    private static class Node {
        Character chr;
        Integer count;

        public Node(Character chr, Integer count) {
            this.chr = chr;
            this.count = count;
        }
    }
}