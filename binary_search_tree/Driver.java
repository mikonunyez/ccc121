public class Driver {
    public static void main(String[] args) {
        BST tree = new BST(); //constructor
        
        // insert nodes
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(9);

        
        tree.inorder(); //returns the nodes in order

        int nodeCount = tree.countAll(); // returns the number of nodes
        System.out.println("There are " + nodeCount + " nodes");

        int leafCount = tree.countLeaves(); // returns the number of leaves
        System.out.println("There are " + leafCount + " leaves");

        int righthCount = tree.countRight(); // returns the number of right children
        System.out.println("There are " + righthCount + " right children");

        int leftCount = tree.countLeft(); // returns the number of left children
        System.out.println("There are " + leftCount + " left children");
    }
}
