/** Stack implementation with an Array.
    @param <T> the type of each element in stack
*/
public class ArrayStack<T> implements Stack<T> {
    private T[] rep;
    private int used;

    /** Constructor for ArrayStack.
    */
    public ArrayStack() {
        this.rep = (T[]) new Object[1];
    }

    /** Double the size of the array.
    */
    private void grow() {
        T[] bigger = (T[]) new Object[this.rep.length * 2];
        for (int i = 0; i < this.rep.length; i++) {
            bigger[i] = this.rep[i];
        }
        this.rep = bigger;
    }
    /** Push a new element on top of stack.
        @param t the element to push
    */
    public void push(T t) {
        if (this.used == this.rep.length) {
            this.grow();
        }
        this.rep[this.used] = t;
        this.used += 1;
    }
    /** Pop the element on top of stack.
        @throws EmptyStackException if stack is empty
    */
    public void pop() throws EmptyStackException {
        if (this.empty()) {
            throw new EmptyStackException();
        }
        this.used -= 1;
    }
    /** Gets the element at top of stack.
        @return T the element at the top
        @throws EmptyStackException if stack is empty
    */
    public T top() throws EmptyStackException {
        if (this.empty()) {
            throw new EmptyStackException();
        }
        return this.rep[this.used - 1];
    }
    /** Check if the stack is empty or not.
        @return boolean with whether or not stack is empty.
    */
    public boolean empty() {
        return this.used == 0;
    }

    /** Display the stack as a string.
        @return the string representation of the stack.
    */
    public String toString() {
        if (this.used == 0) {
            return "[]";
        }
        String stack = "[";
        for (int i = 0; i < this.used - 1; i++) {
            stack += this.rep[i];
            stack += " ";
        }
        stack += this.rep[this.used - 1] + "]";

        return stack;
    }
    /** Get the size of the stack.
        @return this.used the size of the stack.
    */
    public int size() {
        return this.used;
    }
}
