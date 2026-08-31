class LFUCache {

    class Node{
        int key;
        int val;
        int freq;

        Node next;
        Node prev;

        Node(int key1,int val1){
            this.key=key1;
            this.val=val1;
            this.freq=1;
        }
    }

    class DoublyLL{
        Node head;
        Node tail;
        int size;

        DoublyLL(){
            head=new Node(-1,-1);
            tail=new Node(-1,-1);

            head.next=tail;
            tail.prev=head;

            size=0;
        }

        void addNode(Node newNode){
            Node temp=head.next;

            newNode.next=temp;
            newNode.prev=head;

            head.next=newNode;
            temp.prev=newNode;

            size++;
        }

        void deleteNode(Node delNode){
            Node delPrev=delNode.prev;
            Node delNext=delNode.next;

            delPrev.next=delNext;
            delNext.prev=delPrev;

            size--;
        }
    }

    int cap;
    int minFreq;

    HashMap<Integer,Node> mpp=new HashMap<>();
    HashMap<Integer,DoublyLL> freqmap=new HashMap<>();

    public LFUCache(int capacity) {
        cap=capacity;
        minFreq=0;
    }
    
    public int get(int key) {
        if(!mpp.containsKey(key)) return -1;

        Node node = mpp.get(key);
        updateFreq(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (cap==0) return;

        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            node.val=value;

            updateFreq(node);
            return;
        }

        if(mpp.size()==cap){
            DoublyLL list=freqmap.get(minFreq);

            Node nodeToDelete = list.tail.prev;
            list.deleteNode(nodeToDelete);

            mpp.remove(nodeToDelete.key);
        }

        Node newNode = new Node(key,value);
        mpp.put(key,newNode);

        freqmap.putIfAbsent(1,new DoublyLL());
        freqmap.get(1).addNode(newNode);

        minFreq=1;
    }
    private void updateFreq(Node node){
        int oldFreq =node.freq;
        DoublyLL oldList = freqmap.get(oldFreq);

        oldList.deleteNode(node);

        if(oldFreq==minFreq && oldList.size==0) minFreq++;

        node.freq++;

        freqmap.putIfAbsent(node.freq,new DoublyLL());

        freqmap.get(node.freq).addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */