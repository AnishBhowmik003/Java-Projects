public class FullTimeEmployee extends Employee {

   public FullTimeEmployee(){
      super();
      idnum++;
      setID(idnum);
   }
  
   public double getPay() {
      //double pay;
      
      if (hours <= 40)
         pay = rate * hours;
      else
         pay = rate * 40 +  rate * 2 * (hours - 40);

      totalPay += pay;
      addToPay(this, pay);
      
      return pay;
      
   }
}