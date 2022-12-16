
public class Pascal {
	public static void main(String args[])
	{
	    int r, i, k, number=1, j;
	
		r = 80;
		
		for(i=0;i<r;i++)
		{
			for(k=r; k>i; k--)
			{
				System.out.print(" ");
			}
            number = 1;
			for(j=0;j<=i;j++)
			{
				if(number % 2 == 0) {
					System.out.print(" ");
				}
				else {
					System.out.print(".");
				}
				// System.out.print(number+ " ");
                 number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}
}
