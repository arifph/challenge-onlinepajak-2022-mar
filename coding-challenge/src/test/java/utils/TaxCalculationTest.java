package utils;


import exception.InvalidInputException;
import model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaxCalculationTest {
    @Test
    public void test_reliefTax() throws InvalidInputException {
        assertEquals(54000000, TaxCalculation.reliefTax(false, 0));
        assertEquals(58500000, TaxCalculation.reliefTax(true, 0));
        assertEquals(63000000, TaxCalculation.reliefTax(true, 1));
        assertEquals(67500000, TaxCalculation.reliefTax(true, 2));
        assertEquals(72000000, TaxCalculation.reliefTax(true, 3));
        assertThrows(InvalidInputException.class, ()-> TaxCalculation.reliefTax(true, -1));
    }

    @Test
    public void test_rateIncomeTax() {
        List<Long> ratedTax1 = TaxCalculation.rateIncomeTax(78000000);
        assertEquals(4200000, ratedTax1.get(1));

        List<Long> ratedTax2 = TaxCalculation.rateIncomeTax(300000000);
        assertEquals(12500000, ratedTax2.get(2));

        List<Long> ratedTax3 = TaxCalculation.rateIncomeTax(900000000);
        assertEquals(2500000, ratedTax3.get(0));
        assertEquals(30000000, ratedTax3.get(1));
        assertEquals(62500000, ratedTax3.get(2));
        assertEquals(120000000, ratedTax3.get(3));
    }

    @Test
    public void test_calculateTax() throws InvalidInputException {
        Person personWithoutSalary = Person.builder().monthlySalary(0).isMarried(false).build();
        Person marriedPersonPtkp = Person.builder().monthlySalary(6000000).isMarried(true).numberOfChildren(3).build();
        Person singlePerson = Person.builder().monthlySalary(25000000).isMarried(false).build();
        Person marriedPersonWithoutChild = Person.builder().monthlySalary(30000000).isMarried(true).numberOfChildren(0).build();
        Person marriedPersonWithOneChild = Person.builder().monthlySalary(35000000).isMarried(true).numberOfChildren(1).build();

        assertThrows(InvalidInputException.class, ()->TaxCalculation.calculateTax(personWithoutSalary));
        assertEquals(0, TaxCalculation.calculateTax(marriedPersonPtkp));
        assertEquals(31900000, TaxCalculation.calculateTax(singlePerson));
        assertEquals(45375000, TaxCalculation.calculateTax(marriedPersonWithoutChild));
        assertEquals(59250000, TaxCalculation.calculateTax(marriedPersonWithOneChild));
    }
}
