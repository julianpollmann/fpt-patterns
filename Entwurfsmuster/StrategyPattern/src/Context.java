
public class Context {

	private BaseStrategy strategy;

	public Context(BaseStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(BaseStrategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return this.strategy.doOperation(num1, num2);
	}

}
