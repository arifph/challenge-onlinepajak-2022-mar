package utils;

import exception.InvalidInputException;
import java.util.Arrays;
import java.util.List;
import model.Person;

public class TaxCalculation {
  public static final int FIRST_INCOME = 50000000;
  public static final int SECOND_INCOME = 250000000;
  public static final int THIRD_INCOME = 500000000;

  public static long reliefTax(boolean marriageStatus, int numberOfChildren)
      throws InvalidInputException {
    long taxRelief = 54000000;
    if (marriageStatus) {
      if (!ValidationUtils.isNumberOfChildrenValid(numberOfChildren)) {
        throw new InvalidInputException("Please insert valid number of children!");
      }
      switch (numberOfChildren) {
        case 0:
          taxRelief = 58500000;
          break;
        case 1:
          taxRelief = 63000000;
          break;
        case 2:
          taxRelief = 67500000;
          break;
        default:
          taxRelief = 72000000;
          break;
      }
    }
    return taxRelief;
  }

  public static List<Long> rateIncomeTax(long taxableIncome) {
    long firstRate = (FIRST_INCOME * 5L) / 100;
    long secondRate = ((SECOND_INCOME - FIRST_INCOME) * 15L) / 100;
    long thirdRate = ((THIRD_INCOME - SECOND_INCOME) * 25L) / 100;

    if (taxableIncome <= FIRST_INCOME) {
      return List.of((taxableIncome * 5) / 100);
    } else if (taxableIncome <= SECOND_INCOME) {
      return Arrays.asList(firstRate, ((taxableIncome - FIRST_INCOME) * 15) / 100);
    } else if (taxableIncome <= THIRD_INCOME) {
      return Arrays.asList(firstRate, secondRate, ((taxableIncome - SECOND_INCOME) * 25) / 100);
    } else {
      return Arrays.asList(
          firstRate, secondRate, thirdRate, ((taxableIncome - THIRD_INCOME) * 30) / 100);
    }
  }

  public static long calculateTax(Person person) throws InvalidInputException {
    if (!ValidationUtils.isSalaryValid(person.getMonthlySalary())) {
      throw new InvalidInputException("Please insert valid monthly salary");
    }
    long taxableIncome =
        (person.getMonthlySalary() * 12)
            - reliefTax(person.isMarried(), person.getNumberOfChildren());
    List<Long> ratedTax = rateIncomeTax(taxableIncome);
    for (int i = 0; i < ratedTax.size(); i++) {
      person.setAnnualTax(person.getAnnualTax() + ratedTax.get(i));
    }
    return person.getAnnualTax();
  }
}
