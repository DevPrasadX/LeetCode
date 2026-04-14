class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val)
    {
        this.key = key;
        this.val= val;
    }
}
class LRUCache {
    int capacity;
    Map<Integer,ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    head = new ListNode(-1,-1);
    tail= new ListNode(-1,-1);
    head.next = tail;
    tail.prev = head;


    }
    
    public int get(int key) {
    if(!map.containsKey(key))
    {
        return -1;
    }    
    ListNode node = map.get(key);
    remove(node);
    add(node);
    return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            ListNode oldNode = map.get(key);
            remove(oldNode);

        }

        ListNode newNode = new ListNode(key,value);
            map.put(key,newNode);
            add(newNode);
            if(map.size()>capacity)
            {
                ListNode deletingNode = head.next;
                remove(deletingNode);
                map.remove(deletingNode.key);
            }
    }

    public void add(ListNode node)
    {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */