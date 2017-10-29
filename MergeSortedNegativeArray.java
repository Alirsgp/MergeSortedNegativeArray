public class MergeSortNegativeArrays {
      public static void main (String [] args) {
            System.out.println("lol");
            int[] arr = {-5, -4, -3, -2, -1, 0, 1, 2, 4, 6, 9};
            for (int i: arr) {
                  System.out.print(i + "; ");
            }
            System.out.println();

            int [] answer = squareArrSortMerge(arr);
            for (int i: answer) {
                  System.out.print(i + "; ");
            }
            System.out.println();
            


      }

      public static int[] squareArrSortMerge(int [] arrInput) {
            //Input is {-5, -4, -3, -2, -1, 0, 1, 2, 4, 6, 9}
            int arrLength = arrInput.length;
            int negLength = 0;
            boolean isZeroOrPositive = false;
            int i = 0;
            for (i = 0; i < arrInput.length - 1 && isZeroOrPositive == false; i++) {
                  if (arrInput[i] >= 0) {
                        isZeroOrPositive = true;
                  } else {
                  negLength++;
                  }
            }
            
            int [] arrayOne = new int[arrLength - negLength];
            int [] arrayTwo = new int[negLength];
            int [] arrayAnswer = new int[arrLength];
            int counter = 0;
            int j = 0;
            for (j = i - 1; j < arrLength; j++) {
                  arrayOne[counter] = arrInput[j];
                  counter++;
            }
            for (int k = 0; k < arrayOne.length; k++) {
                  arrayOne[k] = arrayOne[k] * arrayOne[k];
            }
            //At this point, we have our positive values sorted and squared.
            for (int m = 0; m < i - 1; m++) {
                  arrayTwo[m] = arrInput[m];
                  arrayTwo[m] = arrayTwo[m] * arrayTwo[m];
            }


            int u = arrayOne.length;
            int v = arrayTwo.length;
            int x = 0;
            int y = v - 1;
            int z = 0;

           while (x < u && y >= 0) {
                  if (arrayOne[x] <= arrayTwo[y]) {
                        arrayAnswer[z] = arrayOne[x];
                        x++;
                  } else {
                        arrayAnswer[z] = arrayTwo[y];
                        y--;
                  }
                  z++;


           }

            if (x < u) {
                  for (int p = x; p < u; p++) {
                        arrayAnswer[z] = arrayOne[p];
                        z++;
                  }
            } else {
                  for (int p = y; p < v; p++) {
                        arrayAnswer[z] = arrayTwo[p];
                        z++;
                  }
            }


            return arrayAnswer;

      }
}
