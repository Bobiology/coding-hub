package stack;

public interface Stack<T> {
	public Stack<T> push(T value);
	public Stack<T> pop();
	public T head();
	public boolean isEmpty();
	
	

}
