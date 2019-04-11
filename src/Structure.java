public interface Structure<T> {

	abstract void add(T t);
	abstract void push(T t);
	abstract T pop();
	abstract T remove();
	abstract boolean isEmpty();


}
