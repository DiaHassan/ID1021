import java.util.Arrays;

public class Stack {
    int[] stack_array = new int[4];
    int sp = 0;

    public void push(int tbp){
        if(sp > 3){
            System.out.println("Stack over flow");
        } else {
            stack_array[sp++] = tbp;
        }
    }
    public int pop(){
        if(sp == 0)
            return stack_array[sp];
        else
            return stack_array[--sp];
    }


//    public void push(int tbp){
//        if(sp > stack_array.length - 1){
//            int[] temp_stack = new int[(stack_array.length/4 + 1)* 4];
//            for (int i = 0; i < stack_array.length; i ++)
//                temp_stack[i] = stack_array[i];
//            temp_stack[stack_array.length] = tbp;
//            stack_array = temp_stack;
//            sp++;
//        } else {
//            stack_array[sp++] = tbp;
//        }
//        System.out.println(Arrays.toString(stack_array)+" pu");
//    }
//    public int pop(){
//
//        if(stack_array.length == 4){
//            System.out.println(Arrays.toString(stack_array)+" po1");
//            if(sp == 0)
//                return stack_array[sp];
//            else
//                return stack_array[--sp];
//        }
//        if(sp < stack_array.length / 2) {
//            System.out.println(Arrays.toString(stack_array)+" po2");
//            int[] temp_stack = new int[(stack_array.length/4 - 1) * 4];
//            for (int i = 0; i < temp_stack.length; i ++)
//                temp_stack[i] = stack_array[i];
//            stack_array = temp_stack;
//        }
//        return stack_array[--sp];
//    }

}
