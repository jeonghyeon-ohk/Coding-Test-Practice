package self_study.list.이중연결리스트;
import java.util.*;

class DoubleLinkedList{
  private Node head;

  DoubleLinkedList(){
    this.head = null;
  }

  DoubleLinkedList(int value){
    this.head = new Node(value);
  }

  class Node {
    private int value; // 값
    private Node next; // 다음 포인터
    private Node prev; // 이전 포인터

    Node(int value){
      this.value = value;
      this.next = this.prev = null;
    }

    Node(int value, Node prev, Node next){
      this.value = value;
      this.next = next;
      this.prev = prev;
    }

    public int getValue(){
      return this.value;
    }
  }

  public Node getHead(){
    return this.head;
  }

  public void printAll(){
    Node pointer = this.head;
    StringBuilder sb = new StringBuilder();

    while(pointer.next != null){
      sb.append(pointer.value).append(" -> ");
      pointer = pointer.next;
    }

    sb.append(pointer.value).append("\n");
    System.out.print(sb.toString());

    sb.setLength(0);
    System.out.print("                   ");

    while(pointer.prev != null){
      sb.append(pointer.value).append(" -> ");
      pointer = pointer.prev;
    }

    sb.append(pointer.value).append("\n");
    System.out.print(sb.toString());

  }

  public void addNode(int value){

    if(this.head == null){
      this.head = new Node(value);
      return;
    }

    Node pointer = this.head;
    while(pointer.next != null) {
      pointer = pointer.next;
    }

    Node newNode = new Node(value);
    pointer.next = newNode;
    newNode.prev = pointer;
  }

  public void addNode(int value, int index){
    Node pointer = this.head;
    Node newNode = new Node(value);

    for(int i=0; i<index-1; i++)
      pointer = pointer.next;

    newNode.next = pointer.next;
    pointer.next.prev = newNode;
    newNode.prev = pointer;
    pointer.next = newNode;
  }

  public void delete(int value){
    Node pointer = this.head;

    if(pointer.getValue()==value){
      Node removeNode = this.head;
      this.head = this.head.next;
      this.head.prev = null;

      removeNode = null;
      return;
    }


    while(pointer!=null && pointer.getValue() != value){
      pointer = pointer.next;
    }

    if(pointer == null){
      System.out.println("해당하는 노드가 없습니다.");
      return;
    }

    if(pointer.next == null){
      pointer.prev.next = null;
    }
    else{
      pointer.prev.next = pointer.next;
      pointer.next.prev = pointer.prev;
    }
    pointer = null;
  }
}

public class Main{
  public static void main(String[] args){
    DoubleLinkedList myList = new DoubleLinkedList();
    myList.addNode(85);
    myList.addNode(59);
    myList.addNode(70);
    myList.addNode(23);
    myList.addNode(65);
    myList.addNode(1,3);

    System.out.print("이중 연결 리스트 : ");
    myList.printAll();

    myList.delete(85);
    System.out.print("이중 연결 리스트 : ");
    myList.printAll();

    myList.delete(23);
    System.out.print("이중 연결 리스트 : ");
    myList.printAll();

    myList.delete(2);
    System.out.print("이중 연결 리스트 : ");
    myList.printAll();
  }
}


