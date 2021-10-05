package SLL;

public class SLLNode { 
  public Object info; 
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
  
  