package stack;

import java.util.EmptyStackException;

public class ImmutableStack<T> implements Stack<T> {
	
	private final T value;
	private final Stack<T> tail;
	
	private ImmutableStack(T value, Stack<T> tail){
		this.value = value;
		this.tail = tail;
	}

	@Override
	public Stack<T> push(T value) {
		return new ImmutableStack<T>(value, this);
	}

	@Override
	public Stack<T> pop() {
		return tail;
	}

	@Override
	public T head() {
		return value;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
	
	public static final Stack empty() {
		return EmptyStack.getInstance();
	}
	
	private static final class EmptyStack<T> implements Stack<T> {

		@SuppressWarnings("rawtypes")
		private static final EmptyStack instance = new EmptyStack();

		@SuppressWarnings("rawtypes")
		public static final EmptyStack getInstance() {
			return instance;
		}

		@Override
		public final Stack<T> push(T e) {
			return new ImmutableStack<>(e, this);
		}

		@Override
		public final Stack<T> pop() throws EmptyStackException {
			throw new EmptyStackException();
		}

		@Override
		public final T head() throws EmptyStackException {
			throw new EmptyStackException();
		}

		@Override
		public final boolean isEmpty() {
			return true;
		}
	}

}
