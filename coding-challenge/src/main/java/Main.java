import java.util.Scanner;
import model.Person;
import utils.TaxCalculation;
import utils.ValidationUtils;

public class Main {
  public static void main(String[] args) throws Exception {
    Person person = new Person();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input monthly salary : ");
    person.setMonthlySalary(scanner.nextLong());
    System.out.println();
    System.out.print("Are you married? (Y/N) : ");
    String isMarried = scanner.next();
    System.out.println();
    if (ValidationUtils.isMarried(isMarried)) {
      person.setMarried(true);
      System.out.print("Input number of children : ");
      person.setNumberOfChildren(scanner.nextInt());
      System.out.println();
    } else {
      person.setMarried(false);
    }
    System.out.println();
    System.out.println("Annual tax is " + TaxCalculation.calculateTax(person) + " IDR");
  }
}
