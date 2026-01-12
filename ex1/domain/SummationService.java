package ex1.domain;

/**
 * Domain service interface for calculating summations.
 * This interface belongs to the Domain Layer and represents the core business capability.
 * It follows the Dependency Inversion Principle - clients depend on this abstraction,
 * not on concrete implementations.
 * 
 * Calculates: Σ f(i) for i from inf to sup
 */
public interface SummationService {
    /**
     * Calculates the summation of a given function over a range.
     *
     * @param inf the lower bound (inclusive)
     * @param sup the upper bound (inclusive)
     * @param function the mathematical function to sum
     * @return the calculated summation result
     * @throws IllegalArgumentException if inf > sup
     */
    int calculate(int inf, int sup, MathFunction function);
}
