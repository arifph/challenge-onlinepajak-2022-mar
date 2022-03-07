package utils;

import java.util.Arrays;
import java.util.List;
import model.Person;

public class TaxCalculation {
  public static long reliefTax(boolean marriageStatus, int numberOfChildren) throws Exception {
    long taxRelief = 54000000;
    if (marriageStatus) {
      if (!ValidationUtils.isNumberOfChildrenValid(numberOfChildren)) {
        throw new Exception("Please insert valid number of children!");
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
    long firstRate = (50000000 * 5L) / 100;
    long secondRate = ((250000000 - 50000000) * 15L) / 100;
    long thirdRate = ((500000000 - 250000000) * 25L) / 100;

    if (taxableIncome <= 50000000) {
      return List.of((taxableIncome * 5) / 100);
    } else if (taxableIncome <= 250000000) {
      return Arrays.asList(firstRate, ((taxableIncome - 50000000) * 15) / 100);
    } else if (taxableIncome <= 500000000) {
      return Arrays.asList(firstRate, secondRate, ((taxableIncome - 250000000) * 25) / 100);
    } else {
      return Arrays.asList(
          firstRate, secondRate, thirdRate, ((taxableIncome - 500000000) * 30) / 100);
    }
  }

  public static long calculateTax(Person person) throws Exception {
    if (!ValidationUtils.isSalaryValid(person.getMonthlySalary())) {
      throw new Exception("Please insert valid monthly salary");
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
