package section7;

/*연결리스트는 배열처럼 reallocation 필요 없음, 다른 데이터의 이동 없이 중간에 데이터 삽입이나 삭제 추가 가능
길이의 제한이 없음
단, 랜덤 엑세스가 불가능*/

/*인터페이스와 구현을 분리하면 코드의 모듈성 (modularity) 가 증가하며, 코드의 유지 / 보수, 코드의 재사용이 용이해진다.*/

public class MySingleLinkedList<T> {

    private Node<T> head;
    private int size;

    public MySingleLinkedList(){
        head = null;
        size = 0;
    }

    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data){
            this.data = data;
            next = null;
        }
    }

    private void addFirst(T item){
        Node<T> newNode = new Node<T>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    private void addAfter(Node<T> before, T item){
        Node<T> newNode = new Node<T>(item);
        newNode.next = before .next;
        before.next = newNode;
        size++;
    }

    public void add(int index, T item){
        if(index < 0 || index > size)
            return;
        if(index == 0)
            addFirst(item);
        else {
            Node<T> q = getNode(index - 1);
            addAfter(q, item);
        }
    }

    public T remove(int index){
        if(index < 0 || index >= size)
            return null;
        if(index == 0)
            return removeFirst();
        Node<T> prev = getNode(index - 1);
        return removeAfter(prev);
    }

    public T remove(T item){
        Node<T> p = head;
        Node<T> q = null;
        while(p != null && !p.data.equals(item)) {
            q = p;
            p = p.next;
        }
        if(p == null)
            return null;
        if(q == null)
            return removeFirst();
        else
            return removeAfter(q);
    }

    private T removeFirst(){
        if(head == null) return null;
        T removeData = head.data;
        head = head.next;
        size--;
        return removeData;
    }

    private T removeAfter(Node<T> before){
        if(before.next == null) return null;
        T removeData = before.next.data;
        size--;
        before.next = before.next.next;
        return removeData;
    }

    public int indexOf(T item){
        Node<T> p = head;
        int index = 0;
        while(p != null){
            if(p.data.equals(item))
                return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    private Node<T> getNode(int index){
        if(index < 0 || index >= size)
            return null;
        Node<T> p = head;
        for(int i = 0; i < index; i ++)
            p = p.next;
        return p;
    }

    public T get(int index){
        if(index < 0 || index >= size)
            return null;
        return getNode(index).data;
    }
}
