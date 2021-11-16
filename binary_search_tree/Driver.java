public class Driver {
    public static void main(String[] args) {
        BST tree = new BST(); //constructor

        // insert nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        tree.inorder();
    }
}
