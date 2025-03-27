package x04;

public class SimpleLinkedListTest {
    static class SimpleNode<E>{
        E data;
        SimpleNode<E> next;

        public SimpleNode(E data) {
            this.data = data;
            this.next = null;
        }
    }
    static class SimpleLinkedList<E>{
        SimpleNode<E> head;
        int size;

        public SimpleLinkedList() {
            this.head = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size(){
            return this.size;
        }

        public void addFirst(E data) {
            SimpleNode<E> node = new SimpleNode<>(data);
            node.next = this.head;
            this.head = node;
            this.size++;
        }

        public void addLast(E data) {
            SimpleNode<E> node = new SimpleNode<E>(data);
            if(this.isEmpty()){
                this.head = node;
            }else{
                SimpleNode<E> cur = this.getIndexOfNode(this.size - 1);
                cur.next = node;
            }
            this.size++;
        }

        public SimpleNode<E> getIndexOfNode(int index) {
            SimpleNode<E> cur = this.head;

            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        }

        public void add(int index, E data) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("인덱스가 범위를 벗어남");
            }
            if(index == 0){
                this.addFirst(data);
            } else if (index == this.size) {
                this.addLast(data);
            } else {
                SimpleNode<E> newNode = new SimpleNode<>(data);
                SimpleNode<E> beforeNode = this.getIndexOfNode(index - 1);

                newNode.next = beforeNode.next;
                beforeNode.next = newNode;
                this.size++;
            }
        }

        public void deleteFirst() {
            if(this.isEmpty()){
                throw new IndexOutOfBoundsException("리스트가 비어있습니다.");
            }

            this.head = this.head.next;
            this.size--;
        }

        public void deleteLast() {
            if(this.isEmpty()){
                throw new IndexOutOfBoundsException("리스트가 비어있습니다.");
            }

            if(this.size == 1){
                this.head = null;
            }else{
                SimpleNode<E> before = this.getIndexOfNode(this.size - 2);
                before.next = null;
            }
            this.size--;
        }

        public void delete(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
            }
            if(index == 0){
                this.deleteFirst();
            }
            if (index == size - 1) {
                this.deleteLast();
            }else {
                SimpleNode<E> before = this.getIndexOfNode(index - 1);
                before.next = before.next.next;
                this.size--;
            }
        }
        public E get(int index) {
            if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
            }
            SimpleNode<E> node = this.getIndexOfNode(index);
            return node.data;
        }

        @Override
        public String toString() {
            SimpleNode<E> cur = head;
            StringBuilder sb = new StringBuilder();

            while (cur != null) {
                if(cur != head){
                    sb.append("->");
                }
                sb.append(cur.data);
                cur = cur.next;
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        SimpleLinkedList<Object> list = new SimpleLinkedList<>();
        list.add(0, 6);
        list.add(1, 7);
        System.out.println(list); // 6->7

        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        System.out.println(list); // 2->3->4->6->7

        list.addLast(8);
        list.addLast(9);
        list.add(0, 1);
        list.add(4, 5);
        System.out.println(list); // 1->2->3->4->5->6->7->8->9

        list.deleteFirst();
        list.deleteLast();
        System.out.println(list); // 2->3->4->5->6->7->8

        list.delete(1);
        System.out.println(list); // 2->4->5->6->7->8

        System.out.println(list.get(1)); // 4
    }
}
