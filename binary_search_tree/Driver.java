public class Driver {
    public static void main(String[] args) {
        BST tree = new BST(); //constructor
        
        // insert nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);

        
        // tree.inorder(); //returns the nodes in order

        int nodeCount = tree.countAll(); // returns the number of nodes
        System.out.println("There are " + nodeCount + " nodes");

        int leafCount = tree.countLeaves(); // returns the number of leaves
        System.out.println("There are " + leafCount + " leaves");
    }
}
