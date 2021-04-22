class Employee
{
    private String name;
    private double salary;

   // constructor initializes the members
   public Employee(String name, double salary)
   {
      this.name = name;
      this.salary = salary;
   }

   public double getBonus(double percent)
   {
      return salary * percent;
   }
}

class EmployeeBonus
{

   // the tester program
   public static void main(String[] args)
   {
       Employee emp = new Employee("Joe", 50000);
       double bonus = emp.getBonus(.5);

       System.out.println("Joe's bonus: $" + bonus);
   }
}
