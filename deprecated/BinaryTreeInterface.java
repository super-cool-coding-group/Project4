package deprecated;

/**
 * This is the BinaryTreeInterface which extends the TreeInterface - a separately documented interface.
 *
 * The BinaryTreeInterface introduces additional methods: setRootData, setTree, setLeft, and setRight.
 *
 * While all trees share some common properties, Binary trees have a maximum of two subtrees, which is
 * what we define with these methods.
 *
 * The additional methods are documented separately.
 *
 * @author George Matta
 * @version 1.1
 */
public interface BinaryTreeInterface<T> extends TreeInterface<T>{

    /** Sets this binary tree to a new binary tree.
     * @param rootData   The object that is the data for the new tree's root.
     * @param leftTree   The left subtree of the new tree.
     * @param rightTree  The right subtree of the new tree.
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree);

} // end BinaryTreeInterface
