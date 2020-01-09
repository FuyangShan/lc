import java.util.ArrayList;

public class BinaryTree<T>{

    private BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> node){
        root = node;
    }

    public void printNodeByLevel(BinaryTreeNode<T> node){
        ArrayList<BinaryTreeNode<T>> list = new ArrayList<>();
        if(node == null) return;
        list.add(node);
        int cur = 0;
        while (cur < list.size()){
            int lastOfCurrentLevel = list.size();
            while (cur < lastOfCurrentLevel){
                BinaryTreeNode<T> tempNode = list.get(cur);
                System.out.print(tempNode.getData());
                if (tempNode.getLeftChild() != null){
                    list.add(tempNode.getLeftChild());
                }
                if (tempNode.getRightChild() != null){
                    list.add(tempNode.getRightChild());
                }
                cur++;
            }
            System.out.println();
        }
    }

    private void recursePreOrder(BinaryTreeNode<T> node){
        if (node == null) return;
        System.out.println(node.getData());
        if (node.getLeftChild() != null)
            recursePreOrder(node.getLeftChild());
        if (node.getRightChild() != null)
            recursePreOrder(node.getRightChild());
    }

    private void recurseInOrder(BinaryTreeNode<T> node){
        if (node == null) return;
        if (node.getLeftChild() != null)
            recurseInOrder(node.getLeftChild());
        System.out.println(node.getData());
        if (node.getRightChild() != null)
            recurseInOrder(node.getRightChild()); 
    }

    private void recursePostOrder(BinaryTreeNode<T> node){
        if (node == null) return;
        if (node.getRightChild() != null)
            recursePostOrder(node.getRightChild());
        System.out.println(node.getData());
        if (node.getLeftChild() != null)
            recursePostOrder(node.getLeftChild());
    }

    private int getNodeNumber(BinaryTreeNode<T> node){
        if (node == null) {
            return 0;
        } else {
            return 1 + getNodeNumber(node.getLeftChild()) + getNodeNumber(node.getRightChild());
        }
    }
    
    public int getNodeNumber(){
        return getNodeNumber(this.root);
    }

    private int getTreeDepth(BinaryTreeNode<T> node){
        if (node == null) return 0;
        if (node.getLeftChild() == null && node.getRightChild() == null){
            return 1;
        }
        return 1 + Math.max(getTreeDepth(node.getLeftChild()), getTreeDepth(node.getRightChild()));
    }

    private int getNumberOfKthLevel(BinaryTreeNode<T> node, int k){
        if (node == null || k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        int leftNumber =  getNumberOfKthLevel(node.getLeftChild(), k - 1);
        int rightNumber = getNumberOfKthLevel(node.getRightChild(), k - 1);
        return leftNumber + rightNumber;
    }

    public int getNumberOfKthLevel(int k){
        return getNumberOfKthLevel(this.root, k);
    }

    private int getLeafNumber(BinaryTreeNode<T> node){
        if (node == null){
            return 0;
        }
        if (node.getRightChild() == null && node.getLeftChild() == null){
            return 1;
        }
        int leftNumber = getLeafNumber(node.getLeftChild());
        int rightNumber = getLeafNumber(node.getRightChild());
        return leftNumber + rightNumber;
    }

    public int getLeafNumber(){
        return getLeafNumber(this.root);
    }

    public static boolean isSameOfTreeStructure(BinaryTreeNode<String> tree1Root, BinaryTreeNode<String> tree2Root){
        if (tree1Root == null && tree2Root == null){
            return true;
        } else if (tree1Root == null || tree2Root == null){
            return false;
        } 
        boolean leftFlag = isSameOfTreeStructure(tree1Root.getLeftChild(), tree2Root.getLeftChild());
        boolean rightFlag = isSameOfTreeStructure(tree1Root.getRightChild(), tree2Root.getRightChild());
        return leftFlag && rightFlag;

    }

    public static BinaryTreeNode<String> getMirrorTree(BinaryTreeNode<String> node){
        if (node == null){
            return null;
        }
        BinaryTreeNode<String> leftMirror = getMirrorTree(node.getLeftChild());
        BinaryTreeNode<String> rightMirror = getMirrorTree(node.getRightChild());
        node.setLeftChild(rightMirror);
        node.setRightChild(leftMirror);
        return node;
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<String> a = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> b = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> c = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> d = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> e = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> f = new BinaryTreeNode<>("F");
        a.setLeftChild(b);
        a.setRightChild(c);
        b.setLeftChild(d);
        b.setRightChild(e);
        c.setLeftChild(f);
        BinaryTree<String> binaryTree = new BinaryTree<>(a);
        binaryTree.printNodeByLevel(binaryTree.root);
        // binaryTree.recursePreOrder(binaryTree.root);
        // binaryTree.recurseInOrder(binaryTree.root);
        // binaryTree.recursePostOrder(binaryTree.root);
        // System.out.println(binaryTree.getNodeNumber());
        // System.out.println(binaryTree.getTreeDepth());
        // System.out.println(binaryTree.getNumberOfKthLevel(2));
        // System.out.println(binaryTree.getLeafNumber());
        // BinaryTree<String> mirrorTree = new BinaryTree<>(getMirrorTree(binaryTree.root));
        // mirrorTree.printNodeByLevel(mirrorTree.root);
    }
}

class BinaryTreeNode<T>{
    private BinaryTreeNode<T> leftChild,rightChild;
    private T data;
    public BinaryTreeNode(){
        leftChild = rightChild = null;
    }
    public BinaryTreeNode(T data){
        leftChild = rightChild = null;
        this.data = data;
    }
    public T getData(){
        return data;
    }
    public BinaryTreeNode<T> getLeftChild(){
        return leftChild;
    }
    public BinaryTreeNode<T> getRightChild(){
        return rightChild;
    }
    public void setLeftChild(BinaryTreeNode<T> leftChild){
        this.leftChild = leftChild;
    }
    public void setRightChild(BinaryTreeNode<T> rightChild){
        this.rightChild = rightChild;
    }

}