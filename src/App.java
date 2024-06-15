public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        
        // Add nodes to the binary tree
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);
        
        // Traverse the binary tree in pre-order
        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal();
        
        // Traverse the binary tree in in-order
        System.out.println("In-order traversal:");
        tree.inOrderTraversal();
        
        // Traverse the binary tree in post-order
        System.out.println("Post-order traversal:");
        tree.postOrderTraversal();
    }
}

class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public void addNode(int data) {
        root = addNodeRecursive(root, data);
    }
    
    private Node addNodeRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        
        if (data < current.data) {
            current.left = addNodeRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addNodeRecursive(current.right, data);
        }
        
        return current;
    }
    
    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }
    
    private void preOrderTraversalRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversalRecursive(node.left);
            preOrderTraversalRecursive(node.right);
        }
    }
    
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }
    
    private void inOrderTraversalRecursive(Node node) {
        if (node != null) {
            inOrderTraversalRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderTraversalRecursive(node.right);
        }
    }
    
    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }
    
    private void postOrderTraversalRecursive(Node node) {
        if (node != null) {
            postOrderTraversalRecursive(node.left);
            postOrderTraversalRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }
}