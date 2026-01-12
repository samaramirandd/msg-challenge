package ex1.client;

import ex1.domain.MathFunction;
import ex1.domain.SummationService;
import ex1.application.SummationServiceImpl;

/**
 * Client code demonstrating the usage of the Summation Framework.
 * This belongs to the outermost layer (Presentation/Infrastructure).
 * 
 * Calculates: Σ (4 + sin(i)) for i from inf to sup
 */
public class ClientExample {
    
    public static void main(String[] args) {
        // Dependency injection - client creates the service instance
        // In a real application, this would be done by a DI container (Spring, etc.)
        SummationService summationService = new SummationServiceImpl();
        
        // Define the specific function: f(i) = 4 + sin(i)
        MathFunction function = i -> (int) (4 + Math.sin(i));
        
        // Calculate the summation from 1 to 10
        int result = summationService.calculate(1, 10, function);
        
        System.out.println("Summation of (4 + sin(i)) from 1 to 10: " + result);
        
        // Example 2: Simple function f(i) = i²
        MathFunction squareFunction = i -> i * i;
        int squareSum = summationService.calculate(1, 5, squareFunction);
        System.out.println("Summation of i² from 1 to 5: " + squareSum);
        
        // Example 3: Using method reference
        MathFunction doubleFunction = ClientExample::doubleValue;
        int doubleSum = summationService.calculate(1, 10, doubleFunction);
        System.out.println("Summation of 2i from 1 to 10: " + doubleSum);
    }
    
    /**
     * Example function that can be used as a method reference.
     */
    private static int doubleValue(int i) {
        return 2 * i;
    }
}
