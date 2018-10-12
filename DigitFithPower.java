public class DigitFithPower {
  public static void main(String[] args){
    int total = 0;
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        for(int k = 0; k < 10; k++){
          for(int l = 0; l < 10; l++){
            for(int m = 0; m < 10; m++){
              for(int n = 0; n < 10; n++){
              if(100000*i+10000*j+1000*k+100*l+10*m+n == Math.pow(i,5)+Math.pow(j,5)+Math.pow(k,5)+Math.pow(l,5)+Math.pow(m,5)+Math.pow(n,5) && 100000*i+10000*j+1000*k+100*l+10*m+n != 1 && 100000*i+10000*j+1000*k+100*l+10*m+n != 0){
                System.out.println(100000*i+10000*j+1000*k+100*l+10*m+n);
                total += 100000*i+10000*j+1000*k+100*l+10*m+n;
              }
              //System.out.println(10000*i+1000*j+100*k+10*l+m);
              //System.out.println(""+i+"/"+j+"/"+k+"/"+l+"/"+m);
            }
          }
        }
        }
        //System.out.println(""+i+""+j+"000");
      }
    }
    //int test = Character.getNumericValue("123".charAt(1));
    System.out.println("The answer is: " + total);
  }
}
