import java.util.Iterator;
public class TreeIterator implements Iterator<Integer> {
//    private BinaryTree.Node next;
    private Queueadv stack;
    public TreeIterator() {
        stack = new Queueadv(BinaryTree.root);
    }

    @Override
    public boolean hasNext() {
        return stack.head != null;
    }

    @Override
    public Integer next() {
        if (hasNext() == false)
            return null;
        BinaryTree.Node current  = stack.head.item;
        int tbr = current.value;
        if(current.left != null) {stack.add(current.left);}
        if(current.right != null) {stack.add(current.right);}
        stack.remove();
        return tbr;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
