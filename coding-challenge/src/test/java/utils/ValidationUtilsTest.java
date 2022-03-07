package utils;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationUtilsTest {
    @Test
    public void test_isNumberOfChildrenValid() {
        assertFalse(ValidationUtils.isNumberOfChildrenValid(-1));
        assertTrue(ValidationUtils.isNumberOfChildrenValid(0));
        assertTrue(ValidationUtils.isNumberOfChildrenValid(1));
        assertTrue(ValidationUtils.isNumberOfChildrenValid(2));
        assertTrue(ValidationUtils.isNumberOfChildrenValid(3));
    }

    @Test
    public void test_isSalaryValid() {
        assertFalse(ValidationUtils.isSalaryValid(0));
        assertFalse(ValidationUtils.isSalaryValid(-100));
        assertTrue(ValidationUtils.isSalaryValid(100));
        assertTrue(ValidationUtils.isSalaryValid(7000000));
        assertTrue(ValidationUtils.isSalaryValid(25000000));
        assertTrue(ValidationUtils.isSalaryValid(1000000000));
        assertTrue(ValidationUtils.isSalaryValid(10000000000L));
    }

    @Test
    public void test_isMarried() throws InvalidInputException {
        assertTrue(ValidationUtils.isMarried("Y"));
        assertFalse(ValidationUtils.isMarried("n"));
        assertThrows(InvalidInputException.class, () -> ValidationUtils.isMarried("Yes"));
    }
}
