import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator{    
    
    private ExecutorService executor = Executors.newFixedThreadPool(2);
    
    public Future<Integer> calculate(Integer input) {        
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
    
    public Future<Double> plus (Double numberOne, Double numberTwo){
    	return executor.submit(() -> {
    		Thread.sleep(1000);
    		return numberOne + numberTwo;
    	});
    }
}
