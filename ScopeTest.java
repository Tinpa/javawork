class ScopeTest
{

int memberVar=2;


public static void main (String[] args)

  {
      ScopeTest s= new ScopeTest();
      s.method1();
  }
  
    public void method1()

        {
        int localVar=3;
        memberVar=localVar;
        method2();
        }
    
            public void method2()
  
            {
            int localVar=4;
            System.out.println("memberVar = "+ memberVar);
            System.out.println("localVar = "+ localVar);
            }
     
}
