import java.text.NumberFormat;

class Employee {
  private String name;
  private double salary;

  // constructor initializes the members
  public Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
  }

  // overloaded - takes one double
  public double getBonus(double percent) {
    return salary * percent;
  }

  // overloaded - takes two double
  public double getBonus(double percent, double additional) {
    return salary * percent + additional;
  }

  // overloaded - takes three doubles
  public double getBonus(double percent, double additional, double max) {
    double bonus = salary * percent + additional;
    return bonus <= max ? bonus : max;
  }

  // overloaded - takes four doubles
  public double getBonus(double percent, double additional, double max, double min) {
    double bonus = salary * percent + additional;

    // if in range, return the bonus
    if ((bonus < max) && (bonus > min)) {
      return bonus;
    } else // out of range, return max or min
    {
      return bonus > max ? max : min;
    }
  }
}

class EmployeeBonusOverloadedMethod {

  // the tester program
  public static void main(String[] args) {
    Employee emp1 = new Employee("John", 50000);
    double bonus = emp1.getBonus(.5);
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    String bonusString = formatter.format(bonus);
    System.out.println("John's bonus:\t" + bonusString);

    Employee emp2 = new Employee("Paul", 75000);
    bonus = emp2.getBonus(.25, 10000);
    bonusString = formatter.format(bonus);
    System.out.println("Paul's bonus:\t" + bonusString);

    Employee emp3 = new Employee("George", 100000);
    bonus = emp3.getBonus(.50, 25000, 60000);
    bonusString = formatter.format(bonus);
    System.out.println("George's bonus:\t" + bonusString);

    Employee emp4 = new Employee("Ringo", 20000);
    bonus = emp4.getBonus(.20, 5000, 60000, 10000);
    bonusString = formatter.format(bonus);
    System.out.println("Ringo's bonus:\t" + bonusString);
  }
}
