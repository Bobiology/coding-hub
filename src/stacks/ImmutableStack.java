package stacks;

import java.util.Iterator;

interface IStack<T> extends Iterable<T>{
	IStack<T> push(T value);
	IStack<T> pop();
	T peek();
	boolean isEmpty();
}

public class ImmutableStack<T> implements IStack {
	
	private T head;
	private IStack<T> tail;
	public ImmutableStack(final T head, final IStack<T> tail) {
		
	}

	@Override
	public Iterator iterator() {

		return null;
	}

	@Override
	public IStack push(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStack pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
