package SLL;

/*Data Structures and Algorithm by Adam Drozdek */
public class SLList { 
  protected SLLNode head, tail;

  public SLList() {
    head = tail = null;
  } 

  public boolean isEmpty() { 
    return head == null; 
  }

  public void addToHead(int el) {
    head = new SLLNode(el, head);
    if (tail == null){
      tail = head;
    }
  }

  public void addToTail(int el){
    if (!isEmpty()){
      tail.next = new SLLNode(el);
      tail = tail.next;
    }

    else {
      head = tail = new SLLNode(el);
    }
  }

  public int deleteFromHead(){
    int el = head.info;
    if (head == tail){
      head = tail = null;
    }
    else {
      head = head.next;
    }

    return el;
  }

  public int deleteFromTail(){
    int el = tail.info;
    if (head == tail){
      head = tail = null;
    }
    else head = head.next;
    return el;
  }

  public Object first() { 
    return head.info; 
  }

  public void printAll() { 
    for (SLLNode tmp = head; tmp != null; tmp = tmp.next) 
      // out.print(tmp.info); 
      System.out.println(tmp.info);
  }

  public boolean isInList(int el){
    SLLNode tmp;
    for (tmp = head; tmp != null && tmp.info != el; tmp = tmp.next);
    return tmp != null;
  }

  // public void addFirst(Object el) { 
  //   head = new SLLNode(el,head); 
  // }

  public Object find(Object el) { 
    SLLNode tmp = head; 
    for ( ; tmp != null && !el.equals(tmp.info); tmp = tmp.next); 
    if (tmp == null) return null; else return tmp.info; 
  }

  public Object deleteFirst() { // remove the head and return its info; 
    Object el = head.info; head = head.next; return el; 
  }

  public void delete(int el) {    // find and remove el;  
    if (!isEmpty()){
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
}