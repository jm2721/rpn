/** Stack interface.
    @param <T> the type of element in stack
*/
public interface Stack<T> {
    /** Push a new element on top of stack.
        @param t the element to push
    */
    void push(T t);
    /** Pop the element on top of stack.
        @throws EmptyStackException if stack is empty
    */
    void pop() throws EmptyStackException;
    /** Gets the element at top of stack.
        @return T the element at the top
        @throws EmptyStackException if stack is empty
    */
    T top() throws EmptyStackException;
    /** Check if the stack is empty or not.
        @return boolean with whether or not stack is empty.
    */
    boolean empty();
}
