public class BST {
    protected BSTNode root = null;

    public BST() {
    }

    public Comparable search(BSTNode p, Comparable el){
        while (p != null)
            if (el.equals(p.el)) return p.el;
            else if (el.compareTo(p.el) < 0) p = p.left;
            else p = p.right;
        return null;
    }

    public void insert(Comparable el){
        BSTNode p = root, prev = null;
        
        while (p != null){ // find a place for inserting new node
            prev = p;

            if (p.el.compareTo(el) < 0) p = p.right;
            else p = p.left;
        }

        if (root == null) root = new BSTNode(el); // if tree is empty
        else if (prev.el.compareTo(el) < 0) prev.right = new BSTNode(el);
        else prev.left = new BSTNode(el);
    }

    protected void visit(BSTNode p){
        System.out.println(p.el + " ");
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(BSTNode p){
        if (p != null){
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }

    public int countAll(){
        return countAll(root);
    }

    protected int countAll(BSTNode p){
        if (p != null) return 1 + countAll(p.left) + countAll(p.right);
        else return 0;
    }

    public int countLeaves(){
        return countLeaves(root);
    }

    public int countLeaves(BSTNode p){
        if (p != null){
            if (p.left == null && p.right == null) return 1;
            else return countLeaves(p.left) + countLeaves(p.right);
        }
        else return 0;
    }

    public int countRight(){
        return countRight(root);
    }
    
    public int countRight(BSTNode p){
        if (p != null){
            if (p.right != null){
                return 1 + countRight(p.right) + countRight(p.left);
            }
            else return countRight(p.left);
        }
        else return 0;
    }

    public int countLeft(){
        return countLeft(root);
    }
    
    public int countLeft(BSTNode p){
        if (p != null){
            if (p.left != null){
                return 1 + countLeft(p.right) + countLeft(p.left);
            }
            else return countLeft(p.right);
        }
        else return 0;
    }
}
