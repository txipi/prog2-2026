package api;

public interface Lista <T> {
	public T get(int index);
	public void set(T elemento);
	public int size();
	public boolean cointains(T elemento);
	public void remove(T elemento);
}
