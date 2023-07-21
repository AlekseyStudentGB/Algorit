public class Bin {

    private Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean res = addNode(root, value);
            root = rb(root);
            root.color = Color.black;
            return res;
        }else {
            root = new Node();
            root.color = Color.black;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
       if (node.value==value) {
           return false;
       }else {
           if (node.value > value){
               if (node.left!=null){
                boolean res = addNode(node.left,value);
                node.left=rb(node.left);
                return res;
           }else {
                   node.left= new Node();
                   node.left.color = Color.red;
                   node.left.value = value;
                   return true;
               }
           }else {
               if(node.right != null){
                   boolean res = addNode(node.right,value);
                   node.right = rb(node.right);
                   return res;
               }else {
                   node.right = new Node();
                   node.right.color = Color.red;
                   node.right.value = value;
                   return true;
               }
           }
       }
    }
    private Node rb(Node node){
        Node res = node;
        boolean need;
        do{
            need=false;
            if (res.right != null && res.right.color == Color.red &&
                    (res.left == null || res.left.color == Color.black)){
            need = true;
            res = rightS(res);
            }
            if (res.left != null && res.left.color == Color.red&&
            res.left.left != null && res.left.left.color == Color.red){
                need = true;
            }
            if (res.left != null && res.left.color == Color.red &&
            res.right != null && res.right.color == Color.red){
                need = true;
                swapColor(res);
            }
        }
        while (need);
        return res;
    }
    private void swapColor(Node node){
        node.right.color = Color.black;
        node.left.color = Color.black;
        node.color = Color.red;
    }
    private Node leftS(Node node){
        Node lef = node.left;
        Node bet = lef.right;
        lef.right = node;
        node.left = bet;
        lef.color = node.color;
        node.color = Color.red;
        return lef;
    }
    private Node rightS(Node node){
        Node ri = node.right;
        Node bet = ri.left;
        ri.left = node;
        node.right = bet;
        ri.color = Color.red;
        node.color = Color.red;
        return ri;
    }
    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }


    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node() {
            this.color = Color.red;
        }

        Node(int _value) {
            this.value = _value;
            this.color = Color.red;

        }
    }

    enum Color {red, black}
}
