package utils;

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

  public static boolean isMarried(String isMarried) throws Exception {
    if ("Y".equalsIgnoreCase(isMarried.trim())) {
      return true;
    } else if ("N".equalsIgnoreCase(isMarried.trim())) {
      return false;
    } else {
      throw new Exception("Please enter valid answer!");
    }
  }
}
