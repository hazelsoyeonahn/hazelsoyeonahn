import java.util.*;
public class  Main 
{
    public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in); //create scanner object
       int j=1;
       while(j<=5)  //read 5 strings
       {
        String s=sc.next();  //read string
        Stack<Character>st=new Stack<>();  //create stack
        int flag=0;
       for(int i=0;i<s.length();i++)  //iterate through string
       {
           char k=s.charAt(i);  //get character at specified index
           if(k=='(' || k=='{' || k=='[' || k=='<') //if character is open one,push the element to stack
           {
               st.push(k);
           }
           else 
           {
               if(k==')')  //if character is ')'
               {
                   if(st.peek()=='(')  //if top of stack is '(',pop '('
                   st.pop();
                   else   //invalid matching,set flag and break
                   {
                       flag=1;  
                       break;
                   }
               }
               if(k=='}') //if character is '}'
               {
                   if(st.peek()=='{')  //if top is '{',pop '{'
                   st.pop();
                   else   //invalid matching
                   {
                       flag=1;  //set flag and break
                       break;
                   }
               }
               if(k==']')  //if top is ']',pop '['
               {
                   if(st.peek()=='[') 
                   st.pop();
                   else    //if invalid matching,set flag and break
                   {
                       flag=1;
                       break;
                   }
               }
               if(k=='>')  //if top is '<',pop '<'
               {
                   if(st.peek()=='<')
                   st.pop();
                   else   //if top is not '<',set flag to 1 and break
                   {
                       flag=1;
                       break;
                   }
               }
               
           }
       }
           if(flag==1 || st.empty()==false)  //if flag is set to 1 or stack is not empty,print not evaluated successfully
           System.out.println("Not evaluated successfully");
           else 
           //if stack is empty or flag is not set to 1,expression is Evaluated successfully
           System.out.println("Evaluated successfully");
        j+=1;
       }
       
    }
    
}

/*OUTPUT:

{((2*5)+(3*-2+5))}
Evaluated successfully
{(2*5)+(3*-2+5))}
Not evaluated successfully
List<List>
Evaluated successfully
List<List
Not evaluated successfully
{{<>}{}{..}(e(e)e){hello}}
Evaluated successfully*/