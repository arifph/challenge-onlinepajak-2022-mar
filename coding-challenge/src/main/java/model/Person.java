package model;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
  long monthlySalary;
  boolean isMarried;
  int numberOfChildren;
  long annualTax;
}
