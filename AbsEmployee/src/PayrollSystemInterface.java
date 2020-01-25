/* PayrollSystemInterface.java
1. Requrest employee name, type, pay rate, and hours.
2. Print employee name and pay.
3. Repeat until the name is blank.
4. Print the total pay. */


import TerminalIO.KeyboardReader;

public class PayrollSystemInterface {

   public static void main (String [] args) {
	   
	   int x = 0;
	   
	   Employee[] emps = new Employee[5];
	   
      KeyboardReader reader = new KeyboardReader();
      //Employee emp;    // employee
      String name;     //   name     
      int    type;     //   type 
      double rate;     //   hourly pay rate
      //int    hours;    //   hours worked    
      String prompt;   // user prompt;
      
      while (x < 5){
      
         // Get the name and break if blank
         System.out.println("Enter employee data");
         name = reader.readLine("  Name (or blank to quit): ");
         name = name.trim(); // Trim off leading and trailing spaces
         if (name.length() == 0) break;
         
         // Get the type until valid
         while (true){
            prompt = "  Type (" + Employee.getTypeRules() + "): ";
            type = reader.readInt(prompt);
            if (Employee.typeOK(type)) break;
         }
         // Instantiate an employee of the correct type and set the name
         if (type == 1) {
            emps[x] = new FullTimeEmployee();
         }
         else
            emps[x] = new PartTimeEmployee();
         emps[x].setName(name);
         
         // Get the hourly pay rate until valid
         while (true){
            prompt = "  Hourly rate (" + Employee.getRateRules() + "): ";
            rate = reader.readDouble(prompt);
            if (emps[x].setRate(rate)) break;
         }
            
         // Get the hours worked until valid
         //   To illustrate the possibilities we compress this code 
         //   into a single unreadable statement. 
         while (!emps[x].setHours(reader.readInt
                ("  Hours worked (" + Employee.getHoursRules() + "): ")));
         
         // Print the name and pay
         System.out.println
            ("  The weekly pay for " + emps[x].getName() + 
             " is $" + emps[x].getPay());
         //System.out.println("ID: " + emps[x].getID());
         x++;
      }
      
      // Print the total pay
      
      for(int i = 0; i < x; i++) {
    	  System.out.println(emps[i].toString());
    	  System.out.println();
      }
      System.out.println  ("\nTotal pay: " + Employee.getTotalPay());
      System.out.println("\nFull Time Total pay: " + Employee.getFullTimePay());
      System.out.println("\nPart Time Total pay: " + Employee.getPartTimePay());
      
      
      
   }
}   
         

