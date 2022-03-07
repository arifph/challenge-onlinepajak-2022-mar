package utils;

import exception.InvalidInputException;

public class ValidationUtils {
  public static boolean isNumberOfChildrenValid(int numberOfChildren) {
    boolean isValid = false;
    if (numberOfChildren >= 0) {
      isValid = true;
    }
    return isValid;
  }

  public static boolean isSalaryValid(long salary) {
    boolean isValid = false;
    if (salary > 0) {
      isValid = true;
    }
    return isValid;
  }

  public static boolean isMarried(String isMarried) throws InvalidInputException {
    if ("Y".equalsIgnoreCase(isMarried.trim())) {
      return true;
    } else if ("N".equalsIgnoreCase(isMarried.trim())) {
      return false;
    } else {
      throw new InvalidInputException("Please enter valid answer!");
    }
  }
}
