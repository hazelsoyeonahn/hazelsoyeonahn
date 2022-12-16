package exercises;
import java.util.ArrayList;
import java.util.Scanner;

public class SparkPlugApp {
	public static void main(String[] argv)
    {

      Scanner sc = new Scanner(System.in);

      int ichoice = -1;
      ArrayList<Standard> packages = new ArrayList<Standard>();
      Standard stdPkg = new Standard(10, 5);
      packages.add(stdPkg);

      Lite lpkg = new Lite(10, 5, 15);
      packages.add(lpkg);

      Heavy hpkg = new Heavy(10, 0, 25);
      packages.add(hpkg);
      boolean flag = true;
      while (flag){
    	  int i = 0;
          for (i = 0; i < packages.size(); i++){
        	  
               System.out.format(" %d: %s \n", i,packages.get(i));}
               System.out.format(" %d: stop.\n", i);

               ichoice = sc.nextInt();
               sc.nextLine();
               if (ichoice == i)
            	   flag = false;

               else{
            	   int ichoice1 = -1;
                   while (ichoice1 != 4){
                	   
                       System.out.format(" 1. Talk 2. Text 3. Data 4. Choose another plan \n");
                       ichoice1 = sc.nextInt();
                       sc.nextLine();
                       if (ichoice1 == 4)
                          break;
                       else{
                         if (ichoice1 == 1)
                          packages.get(ichoice).talk(16);
                         else if (ichoice1 == 2)
                          packages.get(ichoice).sendTexts(16);
                         else if (ichoice1 == 3){
                           if (packages.get(ichoice) instanceof Data){
                              ((Data) packages.get(ichoice)).transfer(301);
                              }
                            } else{
                              System.out.format("Invalid choice, try again ..\n");
                              continue;}
                           
                        System.out.format(" %s %s %.2f \n",packages.get(ichoice),"Amount owing on account is : $",packages.get(ichoice).getTotal());

                            }
                   }
               }
      	}
    }
}
