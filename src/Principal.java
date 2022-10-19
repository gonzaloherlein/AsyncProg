import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class Principal {

	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException, ClassCastException {
		SquareCalculator squareCalculator = new SquareCalculator();

		Future<Integer> future1 = squareCalculator.calculate(10);
		Future<Double> future2 = squareCalculator.plus(100.0,200.0);

		while (!(future1.isDone() && future2.isDone())) {
		    System.out.println(
		      String.format(
		        "future1 is %s and future2 is %s", 
		        future1.isDone() ? "done" : "not done", 
		        future2.isDone() ? "done" : "not done"
		      )
		    );
		    Thread.sleep(300);
		}

		Integer result1 = future1.get();
		Double result2 = future2.get();

		System.out.println(result1 + " and " + result2);
	}
}
