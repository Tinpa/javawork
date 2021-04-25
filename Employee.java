/*    */ class Employee {
/*    */   private String name;
/*    */   
/*    */   private double salary;
/*    */   
/*    */   public Employee(String paramString, double paramDouble) {
/*  9 */     this.name = paramString;
/* 10 */     this.salary = paramDouble;
/*    */   }
/*    */   
/*    */   public double getBonus(double paramDouble) {
/* 15 */     return this.salary * paramDouble;
/*    */   }
/*    */   
/*    */   public double getBonus(double paramDouble1, double paramDouble2) {
/* 20 */     return this.salary * paramDouble1 + paramDouble2;
/*    */   }
/*    */   
/*    */   public double getBonus(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 25 */     double d = this.salary * paramDouble1 + paramDouble2;
/* 26 */     return (d <= paramDouble3) ? d : paramDouble3;
/*    */   }
/*    */   
/*    */   public double getBonus(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 31 */     double d = this.salary * paramDouble1 + paramDouble2;
/* 34 */     if (d < paramDouble3 && d > paramDouble4)
/* 35 */       return d; 
/* 38 */     return (d > paramDouble3) ? paramDouble3 : paramDouble4;
/*    */   }
/*    */ }


/* Location:              /Users/student/Desktop/javawork/!/Employee.class
 * Java compiler version: 9 (53.0)
 * JD-Core Version:       1.1.3
 */