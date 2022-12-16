package chapter7;
/**
   A class that finds the LUP-decomposition of an invertible matrix
   @author Andrew Ensor
*/

public class LUPDecomposition
{
   private double[][] triangular; // combined upper and lower matrices
   private int[] permutation; // index of each non-zero entry in rows
   private int n;
   
   // determines the LUP-decomposition for the matrix, without
   // modifying the parameter
   public LUPDecomposition(double[][] matrix)
   {  if (matrix == null)
         throw new IllegalArgumentException("No matrix to decompose");
      n = matrix.length;
      // copy matrix to triangular so matrix not modified
      triangular = new double[n][n];
      permutation = new int[n];
      for (int i=0; i<n; i++)
      {  if (matrix[i].length != n)
            throw new IllegalArgumentException("Matrix not square");
         for (int j=0; j<n; j++)
            triangular[i][j] = matrix[i][j];
         permutation[i] = i;
      }
      for (int k=0; k<n; k++)
      {  // find the largest entry from row k to row n-1 in column k
         double p = Math.abs(triangular[k][k]); // largest entry found
         int kPrime = k; // row of largest entry found
         for (int i=k+1; i<n; i++)
         {  if (Math.abs(triangular[i][k]) > p)
            {  p = Math.abs(triangular[i][k]);
               kPrime = i;
            }
         }
         if (p == 0.0)
            throw new IllegalArgumentException
               ("Matrix not invertible");
         // swap row k with row kPrime
         int tempIndex = permutation[k];
         permutation[k] = permutation[kPrime];
         permutation[kPrime] = tempIndex;
         for (int j=0; j<n; j++)
         {  double tempEntry = triangular[k][j];
            triangular[k][j] = triangular[kPrime][j];
            triangular[kPrime][j] = tempEntry;
         }
         for (int i=k+1; i<n; i++)
         {  // subtract multiple of row k from row i
            triangular[i][k] /= triangular[k][k]; // update lower
            for (int j=k+1; j<n; j++)
               triangular[i][j] -= triangular[i][k]*triangular[k][j];
         }
      }
   }
   
   public double[][] getTriangularMatrices()
   {
      return triangular;
   }
   
   public int[] getPermutationMatrix()
   {
      return permutation;
   }
   
   public static void main(String[] args)
   {  double[][] matrix = {{4,-5,6}, {8,-6,7}, {12,-7,12}};
      LUPDecomposition lup = new LUPDecomposition(matrix);
      double[][] triangular = lup.getTriangularMatrices();
      System.out.println("Combined triangular matrices");
      for (int i=0; i<lup.n; i++)
      {  for (int j=0; j<lup.n; j++)
         {  System.out.print(" " + triangular[i][j]);
         }
         System.out.println();
      }
      int[] permutation = lup.getPermutationMatrix();
      System.out.println("Permutation matrix (non-zero entries)");
      for (int i=0; i<lup.n; i++)
         System.out.print(" " + permutation[i]);
      System.out.println();
   }
}
