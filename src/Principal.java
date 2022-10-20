import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class Principal {

	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException, ClassCastException {
		
		SquareCalculator squareCalculator = new SquareCalculator();
		
		
		
		Future<Integer> future2 = squareCalculator.calculate(10);
		Future<String[]> future1 = squareCalculator.cadena();

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

		Integer result1 = future2.get();
		String[] result2 = future1.get();

		System.out.println(result1);
	}
}
