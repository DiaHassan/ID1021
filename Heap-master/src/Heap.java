public class Heap {
    Node root;

    public class Node {
        public int nb_branches;
        public Integer value;
        public Node left, right;

        public Node(Integer value) {
            this.value = value;
            this.left = this.right = null;
        }
//        public static branch_maker(){
//
//        }
        public void add(Integer inputValue){
            Node current = this;
            current.nb_branches++;
            Integer holder = null;
            if(current.value > inputValue) {
                holder = current.value;
                current.value = inputValue;
            } else {
                holder = inputValue;
            }

            if(current.left == null){
                current.left = new Node(holder);
            } else if (current.right == null){
                current.right = new Node(holder);
            } else if (current.right.nb_branches > current.left.nb_branches ){
                current.left.add(holder);
            } else if (current.right.nb_branches < current.left.nb_branches ){
                current.right.add(holder);
            } else {
                current.left.add(holder);
            }
        }
        public Node remove(){
            if (this.left == null){
                return  this.right;
            } else if (this.right == null){
                return  this.left;
            } else if (this.right.value > this.left.value){
                this.value =  this.left.value;
                this.nb_branches--;
                if(this.left.nb_branches == 0)
                    this.left = null;
                else
                    this.left = this.left.remove();
                return this;
            } else {
                this.value =  this.right.value;
                this.nb_branches--;
                if(this.right.nb_branches == 0)
                    this.right = null;
                else
                    this.right = this.right.remove();
                return this;
            }
        }

        public void push(Integer incr){
            Node current = this;
            Integer holder;
            if(current.left == null && current.right == null){
                current.value += incr;
            } else if (current.left != null && current.left.value < current.value +incr){
                if(current.right != null && current.right.value < current.left.value){
                    holder = current.right.value;
                    current.right.value = current.value;
                    current.value = holder;
                    current.right.push(incr);
                } else {
                    holder = current.left.value;
                    current.left.value = current.value;
                    current.value = holder;
                    current.left.push(incr);
                }
            } else if (current.right != null &&current.right.value < current.value +incr ){
                if(current.left != null && current.left.value < current.right.value){
                    holder = current.left.value;
                    current.left.value = current.value;
                    current.value = holder;
                    current.left.push(incr);
                } else {
                    holder = current.right.value;
                    current.right.value = current.value;
                    current.value = holder;
                    current.right.push(incr);
                }
            } else {
                current.value += incr;
            }
        }
    }
    public Heap(){
        root = null;
    }
    public void add(int nb){
        if(root == null) {
            root = new Node(nb);
        }
        else{
            root.add(nb);
        }
    }
    public Integer remove(){
        if(root.nb_branches == 0) {
            Integer temp = root.value;
            root = null;
            return temp;
        }
        else{
            return  root.remove().value;
        }
    }
    public void push(Integer m){
        if(root == null) {

        }
        else{
            root.push(m);
        }
    }

}
