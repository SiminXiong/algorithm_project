package data_Structure.BinarySearchTree;


public class test {
    public static void main(String[] args) {
        BinarySearchTree<Integer,String> bst=new BinarySearchTree();

        //insert
        bst.put(8,"A");
        bst.put(2,"P");
        bst.put(3,"Y");
        bst.put(10,"K");
        bst.put(9,"G");
        System.out.println("the number of element:"+bst.size());

        bst.put(18,"u");
        System.out.println("the number of element:"+bst.size());

        //get
        System.out.println("key 2's value："+bst.get(2));

        //delete
        bst.delete(3);
        System.out.println("the number of element after deleting:"+bst.size());
        System.out.println("the value of the key after deleting ："+bst.get(3));
    }
}
