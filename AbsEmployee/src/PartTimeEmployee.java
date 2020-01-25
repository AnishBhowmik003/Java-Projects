public class PartTimeEmployee extends Employee {

   public PartTimeEmployee() {
      super();
      idnum++;
      setID(idnum);
   }
  
   public double getPay() {
      //double pay;
      pay = rate * hours;
      totalPay += pay;
      addToPay(this, pay);
      return pay;
      
   }
}

