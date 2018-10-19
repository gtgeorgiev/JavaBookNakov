package homeworks;

public class MyStack {
	private int maxSize;
	private long[] stackArrray;
	private int top;
	
	public MyStack(int size) {
		this.maxSize = size;
		this.stackArrray = new long[size];
		this.top = -1;
	}
	
	public void push(long element) {
		 this.stackArrray[++top] = element;
	}
	
	public long pop() {
		return this.stackArrray[top--];
	}
	
	public long peek() {
		return this.stackArrray[top];
	}
	
	
}
