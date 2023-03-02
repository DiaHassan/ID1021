public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stack();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.type()) {
            case ADD: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case MULS: {
                int y = stack.pop() * 2;
                if (y < 10)
                    stack.push(y*1);
                else
                    stack.push(y-10+1);
                break;
            }

            case MOD: {
                int y = stack.pop();
                int m = y/10;

                stack.push(y-(m*10));
                break;
            }

            case DIV: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE: {
                int v = nxt.value();
                stack.push(v);
                break;
            }

        }
    }
    public int run() {
        while ( ip < expr.length ) {
            step();
        }
        return stack.pop();
    }

}


