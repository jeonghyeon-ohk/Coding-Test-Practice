package self_study.list.단일연결리스트;
import java.util.*;

class SinglyLinkedList{
  private Node head;

  SinglyLinkedList(){
    this.head = null;
  }

  SinglyLinkedList(int value){
    this.head = new Node(value, null);
  }

  class Node {
    private int value; // 값
    private Node next; // 포인터

    Node(int value, Node next){
      this.value = value;
      this.next = next;
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
  }

  public void addNode(int value){

    if(this.head == null){
      this.head = new Node(value, null);
      return;
    }

    Node pointer = this.head;
    while(pointer.next != null) {
      pointer = pointer.next;
    }

    pointer.next = new Node(value, null);
  }

  public void addNode(int value, int index){
    Node pointer = this.head;
    Node newNode = new Node(value, null);

    for(int i=0; i<index-1; i++)
      pointer = pointer.next;

    newNode.next = pointer.next;
    pointer.next = newNode;
  }

  public void delete(int value){
    Node pointer = this.head;

    if(pointer.getValue()==value){
      Node removeNode = this.head;
      this.head = this.head.next;

      removeNode = null;
      return;
    }

    Node temp = pointer;
    while(pointer!=null && pointer.getValue() != value){
      temp = pointer;
      pointer = pointer.next;
    }

    if(pointer == null){
      System.out.println("해당하는 노드가 없습니다.");
      return;
    }

    temp.next = (pointer.next == null) ? null : pointer.next;
    pointer = null;
  }
}

public class Main{
  public static void main(String[] args){
    SinglyLinkedList myList = new SinglyLinkedList();
    myList.addNode(85);
    myList.addNode(59);
    myList.addNode(70);
    myList.addNode(23);
    myList.addNode(65);
    myList.addNode(1,3);

    System.out.print("단일 연결 리스트 : ");
    myList.printAll();

    myList.delete(85);
    System.out.print("단일 연결 리스트 : ");
    myList.printAll();

    myList.delete(23);
    System.out.print("단일 연결 리스트 : ");
    myList.printAll();

    myList.delete(2);
    System.out.print("단일 연결 리스트 : ");
    myList.printAll();
  }
}

