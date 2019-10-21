public class linkedlist<T> {
        T Value;
        Node<T> head;

        public linkedlist(T value){
            this.Value=value;
            this.head=new Node(value);
        }

        class Node<T>{
            T value;
            Node<T> next;

            public Node(T value){
                this.value=value;
                this.next=null;
            }
        }

    public  void addNode(T value){
            Node tmp=head;
            Node newNode=new Node(value);
            while (tmp.next!=null){
                tmp=tmp.next;
            }
            tmp.next=newNode;
            newNode.next=null;
    }


    public static void main(String args[]){

        linkedlist<String> linkl= new linkedlist("l");
        linkl.addNode("s");
    }

}

