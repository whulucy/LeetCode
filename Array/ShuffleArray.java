class ShuffleArray {
  /*
   实现shuffle array, 从最后一个数开始调换
   i = arrar.length - 1,  random.nextInt(0, i), i 会不停的减小
  */

   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
   }

   public static int[] getProductExceptSelf(int[] array){
      int[] left = new int[array.length];
      //int[] right = new int[array.length];
      int product = 1;
      for (int i = 0; i < array.length; i++){
         left[i] = product;
         product *= array[i];
      }

      product = 1;
      for (int i = array.length - 1; i >= 0; i--){
         left[i] *= product;
         product *= right[i];
      }
      return left;
   }

   //

   public static void shuffleArray(int [] array){

      Random random = new Random();
      for (int i = array.length  - 1; i >= 0; i--){
         int num = random.nextInt(i);
         int temp = array[i];
         array[i] = array[num];
         array[num] = temp;
      }

   }

}

public class RandomDemo {
   public static void main( String args[] ){
   // create random object
   Random randomno = new Random();

   // check next int value
   System.out.println("Next int value: " + randomno.nextInt(10000));
   }
}

//Random random.nextInt(n),

//index

// 0  (0, n - 1)
// 1  (1, n - 1)

//index = n - 1   (0, index) index--
//
index i  -- index random
