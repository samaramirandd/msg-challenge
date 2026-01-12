package ex1.application;

import ex1.domain.MathFunction;
import ex1.domain.SummationService;

/**
 * Application Layer implementation of the SummationService.
 * This class implements the use case of calculating summations.
 * It depends only on domain abstractions (interfaces), following Clean Architecture principles.
 */
public class SummationServiceImpl implements SummationService {
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int calculate(int inf, int sup, MathFunction function) {
        validateBounds(inf, sup);
        
        int result = 0;
        for (int i = inf; i <= sup; i++) {
            result += function.apply(i);
        }
        
        return result;
    }
    
    /**
     * Validates the bounds of the summation range.
     *
     * @param inf the lower bound
     * @param sup the upper bound
     * @throws IllegalArgumentException if inf > sup
     */
    private void validateBounds(int inf, int sup) {
        if (inf > sup) {
            throw new IllegalArgumentException(
                String.format("Lower bound (%d) cannot be greater than upper bound (%d)", inf, sup)
            );
        }
    }
}
