package data_Structure.BinarySearchTree;

import org.w3c.dom.Node;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {
    //create root
    Node root;

    //the elements in the tree
    int N;

    //class Node
    public class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key,Value value,Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }

    //method
    //1.return the size of tree
    public int size(){
        return N;
    }

    //2.add element into the tree
    public void put(Key key,Value value){
        root=put(root,key,value);
    }

    //reload the put method
    public Node put(Node x,Key key,Value value){
        //1.x's subtree is null
        if(x==null){
            N++;
            return new Node(key,value,null,null);
        }

        //2.X has subtree
        int compare=key.compareTo(x.key);

        //2.1 key is smaller than x's key
        if(compare<0){
            put(x.left,key,value);
        }
        //2.2 key is greater than x's key
        else if(compare>0){
            put(x.right,key,value);
        }
        else{
            x.value=value;
        }
        return x;
    }

    //3.get the value of the key
    public Value get(Key key){
        return get(root,key);
    }
    //reload methods
    public Value get(Node x,Key key){
        //3.1 x is null
        if(x==null){
            return null;
        }

        //3.2 x is not null
        int compare=key.compareTo(x.key);

        //3.2.1 key is smaller than x's key
        if(compare<0){
           return get(x.left,key);
        }
        //3.2.2 key is greater than x's key
        else if(compare>0){
          return get(x.right,key);
        }
        else{
           return x.value;
        }
    }

    //4.delete method
    public void delete(Key key){
        delete(root,key);
    }

    //reload methods
    public Node delete(Node x,Key key){
        //4.1 x is null
        if(x==null){
            return null;
        }

        //4.2 x is not null,find the key that need to be deleted
        int compare=key.compareTo(x.key);

        //4.2.1 key is smaller than x's key
        if(compare<0){
           delete(x.left,key);
        }
        //3.2.2 key is greater than x's key
        else if(compare>0){
            delete(x.right,key);
        }
        else{
            //have find the key that need to be deleted
            N--;
            //if x just have one side of subtree, then just replace it with subtree
            if(x.left==null){
                x=x.left;
            }
            else if(x.right==null){
                x=x.right;
            }
            else{
                //x has two side of subtrees
                //find the smallest value is x's right tree and get it's node
                Node MinNode=x.right;
                while(MinNode.left!=null){
                    MinNode=MinNode.left;
                }
               // delete this smallest value
                Node n=x.right;
                while(n.left!=null){
                    if(n.left.left!=null){
                        n=n.left;
                    }
                    else{
                        n.left=null;
                    }
                }
                MinNode.left=x.left;
                MinNode.right=x.right;
                x=MinNode;
            }
        }
        return x;
    }
}
