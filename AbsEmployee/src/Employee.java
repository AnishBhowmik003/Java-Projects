abstract public class Employee {

// Protected Instance Variables:  
   protected String name;  
   protected double rate;  
   protected int hours;
   protected int id;
   protected double pay;
   protected static double ptpay = 0;
   protected static double ftpay = 0;
     
// Public Methods:  
   public Employee(){
      name = "";
      rate = 0;
      hours = 0;
   }
   
   
  
   public boolean setName(String nm){
      if (nm.equals(""))
         return false;
      else{
         name = nm;
         return true;
      }
   }
        
   public boolean setRate(double rt){
      if (!(LOW_RATE <= rt && rt <= HIGH_RATE))
         return false;
      else{
         rate = rt;
         return true;
      }
   }
   
   public String toString() {
	   String output = "";
	   output = name + "\nID: " + id + "\nHours: " + hours + "\nRate: $" + rate + "\nPay: $" + pay;
	   if(this instanceof FullTimeEmployee) {
		   output += "\nFull Time"; 
	   }
	   else {
		   output += "\nPart Time";
	   }
	   return output;
   }
   
   protected void setID(int num) {
	   id  = num;
   }
   
   public int getID() {
	   return id;
   }
   
   public boolean setHours(int hrs){
      if (!(LOW_HOURS <= hrs && hrs <= HIGH_HOURS))
         return false;
      else{
         hours = hrs;
         return true;
      }
   }
  
   public String getName(){
      return name;
   }
   
   protected static void addToPay(Employee emp, double pay) {
	   if(emp instanceof FullTimeEmployee) {
		   ftpay += pay;
	   }
	   else {
		   ptpay += pay;
	   }
   }
   
   public static double getFullTimePay() {
	   return ftpay;
   }
   
   public static double getPartTimePay() {
	   return ptpay;
   }
   
   abstract public double getPay();
   
   //---------------------------------------
   
   public static double LOW_RATE = 6.75;
   public static double HIGH_RATE = 30.50;
   public static double LOW_HOURS = 1;
   public static double HIGH_HOURS = 60;
   
   protected static int idnum = 100000;
   
   protected static double totalPay = 0;
   
   public static String getNameRules() {
      return "nonblank";
   }
   
   public static String getTypeRules() {
      return "1 or 2";
   }
   
   public static String getRateRules() {
      return getRule (LOW_RATE, HIGH_RATE);
   }
   
   public static String getHoursRules() {
      return getRule (LOW_HOURS, HIGH_HOURS);
   }

   public static boolean typeOK (int type) {
      return type == 1 || type == 2;
   }
   
   public static double getTotalPay() {
      return totalPay;
   }
   
   private static String getRule (double low, double high) {
         return "between " + low + " and " + high + ", inclusive";
   }
}

