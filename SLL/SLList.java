package SLL;

import java.util.NoSuchElementException;

public class SLList { 
  protected SLLNode head, tail;

  public SLList() {
    head = tail = null;
  } 

  public boolean isEmpty() { 
    return head == null; 
  }  

  public Object deleteFromHead(){
    Object el = head.info;
    if (head == tail){
      head = tail = null;
    }
    else {
      head = head.next;
    }

    return el;
  }

  public void printAll() { //utility function
    for (SLLNode tmp = head; tmp != null; tmp = tmp.next) 
      System.out.println(tmp.info);
  }

  // methods required for submission start here

  public void addLast(int el){
    if (!isEmpty()){
      tail.next = new SLLNode(el);
      tail = tail.next;
    }

    else {
      head = tail = new SLLNode(el);
    }
  }

  public Object getFirst() { 
    if (isEmpty()){
      throw new NoSuchElementException("The list is empty!");
    }

    return head.info; 
  }

  public Object getLast(){
    if (isEmpty()){
      throw new NoSuchElementException("The list is empty!");
    }

    return tail.info;
  }

  public Object deleteLast(){
    if (isEmpty()){
      throw new NoSuchElementException("The list is empty!");
    }

    Object el = tail.info;
    SLLNode foo, temp;
    foo = head;
    temp = head.next;

    while (temp.next != null){
      foo = foo.next;
      temp = temp.next;
    }

    tail = foo;
    tail.next = null;

    return el;
  }

  public void deleteAll(Object el) {    // find and remove el;  
    if (isEmpty()){
      throw new NoSuchElementException("The list is empty!");
    }

    int size = size();
    for (int a = 0; a != size; a++){
      if (head == tail && el == head.info){
        head = tail = null;
      }
      else if (el == head.info){
        head = head.next;
      }
      else{
        SLLNode pred, tmp;
        for (pred = head, tmp = head.next; tmp != null && tmp.info != el; pred = pred.next, tmp = tmp.next){}
        
        if (tmp != null) {
          pred.next = tmp.next;
          if (tmp == tail){
            tail = pred;
          }
        }
      }
    }
  }

  public int size() { 
    int size = 0;

    for (SLLNode tmp = head; tmp != null; tmp = tmp.next){
      size++;
    } 

    return size;
  }

  public int lastIndexOf(int ob){
    int index, foo;
    boolean obExists = false;
    index = 0; 
    foo = 0;
    SLLNode tmp = head;

    while (tmp != null){
      if ((int) tmp.info == ob){
        foo = index;
        obExists = true;
      }
      tmp = tmp.next;
      index++;
    }

    index = foo;

    if (!obExists){
      return -1;
    }

    return index;
  }

  public int firstIndexOf(int ob){
    SLLNode tmp = head;
    int index = 0;

    // if ((int) head.info == ob){
    //   return index;
    // }

    while (tmp != null){
      if ((int) tmp.info == ob){
        return index;
      }
      tmp = tmp.next;
      index++;
    }


    return -1;
  }

}