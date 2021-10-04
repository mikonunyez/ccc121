package SLL;

/*Data Structures and Algorithm by Adam Drozdek */
public class SLLNode { 
  public int info; 
  public SLLNode next; 

  public SLLNode() { 
    next = null; 
  } 

  public SLLNode(int el) { 
    info = el; next = null; 
  } 
  
  public SLLNode(int el, SLLNode ptr) { 
    info = el; next = ptr; 
  }
}
  
  