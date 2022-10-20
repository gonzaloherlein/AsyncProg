import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator{    
	String[] lista= new String[] {"hola","que","tal","estas","estas","estas","estas","estas","estas","estas","estas","estas","estas","estas","estas","estas","estas"};

    private ExecutorService executor = Executors.newSingleThreadExecutor();
   
    public String[] recorrerString(String[] lista) {
    	for(String cadena:lista) {
    	     System.out.println(cadena);
    	}
		return lista;
    }
    
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
    
    public Future<String[]> cadena(){
    	return executor.submit(() -> {
    		Thread.sleep(1000);
    		return recorrerString(lista);
    	});
    }   
 
}
