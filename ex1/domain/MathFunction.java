package ex1.domain;

/**
 * Domain abstraction representing a mathematical function f: int → int
 * This interface belongs to the Domain Layer (innermost layer in Clean Architecture)
 * and defines the core business contract without any implementation details.
 */
@FunctionalInterface
public interface MathFunction {
    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    int apply(int value);
}
