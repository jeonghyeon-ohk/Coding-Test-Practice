package self_study.list.원형_단일연결리스트;
import java.util.*;

class CircularLinkedList{
  private Node head;
  private Node tail;
  int size;

  CircularLinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  class Node {
    private int value;
    private Node next;

    Node(int value){
      this.value = value;
      this.next = null;
    }

    int getValue(){
      return this.value;
    }
  }

  public void addNode(int value){
    if(this.head == null && this.tail == null){
      Node node = new Node(value);
      this.head = node;
      this.tail = node;
      size++;
      return;
    }

    Node pointer = this.tail;
    pointer.next = new Node(value);

    this.tail = pointer.next;
    this.tail.next = this.head;
    size++;
  }

  public void delete(int value){
    Node pointer = this.head;

    if(pointer.getValue() == value){
      Node removeNode = this.head;
      this.head = this.head.next;
      this.tail.next = this.head;

      removeNode = null;
      return;
    }

    Node temp = pointer;
    while(pointer.next != this.tail && pointer.getValue() != value){ // 포인터의 다음 노드가 tail 이거나 포인터가 삭제할 노드인경우 정지
      temp = pointer;
      pointer = pointer.next;
    }

    if(pointer.next.getValue() == value){ // 포인터의 다음 노드가 삭제할 값인경우 즉, tail의 값을 삭제
      this.tail = pointer;
      this.tail.next = this.head;
    }
    else // 포인터 노드를 삭제해야하는 경우
      temp.next = pointer.next;

    pointer = null;
  }

  public void printAll(){
    StringBuilder sb = new StringBuilder();
    sb.append(this.head.getValue()).append("(head) -> ");

    Node pointer = this.head.next;

    while(pointer != this.tail){
      sb.append(pointer.getValue()).append(" -> ");
      pointer = pointer.next;
    }

    sb.append(pointer.getValue()).append("(tail) -> ");
    sb.append(this.head.getValue()).append("(head again)");

    System.out.println(sb.toString());
  }
}

public class Main{
  public static void main(String[] args){
    CircularLinkedList myList = new CircularLinkedList();
    myList.addNode(11);
    myList.addNode(9);
    myList.addNode(27);
    myList.addNode(41);
    myList.addNode(3);
    myList.printAll();

    myList.delete(3);
    myList.printAll();

    myList.delete(11);
    myList.printAll();


    myList.delete(27);
    myList.printAll();
  }
}
