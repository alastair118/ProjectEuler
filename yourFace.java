
public class yourFace{

  static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
           return 0;

        // base case
        else if (a == b)
            return a;

        // a is greater
        else if (a > b)
            return gcd(a-b, b);
        else
            return gcd(a, b-a);
    }

  public static void main(String[] args) {

    int[] numerators = new int[4];
    int[] denominators = new int[4];
    int count = 0;

    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        for (int k = 1; k < 10; k++) {
          float a = (float) i;
          float b = (float) j;
          float c = (float) k;
          if(!(i == j && j == k)){
	    if ((10*a+b)/(10*b+c) == a/c && a/c < 1) {
              System.out.println(i+""+j+"/"+j+""+k +" = "+i+"/"+k);
              numerators[count] = i;
              denominators[count] = k;
              count++;
            }
          }
        }
      }
    }
    int num = 1;
    int den = 1;
    for(int i = 0; i < 4; i++){
      num *= numerators[i];
      den *= denominators[i];
    }
    int hcf = gcd(num,den);
    num /= hcf;
    den /= hcf;
    System.out.println();
    System.out.println("The answer is " + den);
  }
}
