public class LinkedList implements List {
	
	public void add (int pos, Object data)
    {
        if (pos == 0)
        {
            Node node = new Node();
            node.data = data;
            node.next = head;
            head = node;
            size++;
        }
        else
        {
            Node previous = getNode(pos-1);
            Node node = new Node();
            node.data = data;
            node.next = previous.next;
            previous.next = node;
            ++size;

        }
    }

    public void add (Object value)
        {
            Node num = new Node(value);
            num.setNext(head);
            head = num;
            size++;
        }
    
    public Object get(int pos)
    {
        if (pos < 0 || pos >= size)
        {
            throw new IllegalArgumentException("The size is too great");
        }
        Node curr = getNode(pos);
        return curr.data;
    }

    public Object remove (int pos) {
        if (pos < 0 || pos >= size)
        {
            throw new IllegalArgumentException("The size is too great");
        }
        if (pos == 0)
        {
            Node curr = head;
            head = head.getNext();
            --size;
            return curr.data;
        }
        else
        {
            Node previous = getNode(pos-1);
            Node curr = previous.next;
            previous.next = curr.next;
            --size;
            return curr.data;
        }
    }
    
    public int size()
    {
        return size;
    }
	
    public class Node{
        private Object data;
        private Node next;
        public Node()
        {
            this.data = 0;
            this.next = null;

        }
        public Node(Object data)
        {
            this.data = data;
            this.next = null;
        }
        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
        private int size = 0;
        private Node head = null;


        public LinkedList()
        {
            size = 0;
            head = null;
        }

    public Node getNode(int pos)
    {
        Node node = head;
        for (int i = 0; i < pos;i++)
        {
            node = node.getNext();
        }
        return node;
    }

        public String toString()
        {
        	String listString = "";
        	Node current = head;
        	while (current != null)
			{
				listString += current.getData() + "\n";
				current = current.getNext();
			}
			return listString;
        }

        

}


