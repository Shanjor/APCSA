
public class Reverse
{
   public static final String SECRET_PASSWORD = "DABOB";
   
   
   
   
   static String obfuscate(String input)
   {
       return input.replace('B','Y').replace('A','I');
   }
   public static void main(String [] args)
   {
      if (args.length != 1)
      {
         System.out.println("Wrong! You to run this program with one argument:\njava Reverse <argument>");
         return;
      }
      
      if(args[0].equals(SECRET_PASSWORD))
      {
          System.out.println("You win! EPIC!");
      }
      else
      {
          System.out.println("Wrong password. Try again hacker.");
      }
   }
}

