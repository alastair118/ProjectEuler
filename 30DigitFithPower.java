public class 30DigitFithPower {
  public static void main(String[] args){
    for(int i = 0; i < 10; i++){
      for(int j = 0; i < 10; i++){
        for(int k = 0; i < 10; i++){
          for(int l = 0; i < 10; i++){
            if(1000*i+100*j+10*k+l == Math.pow(i,5)+Math.pow(j,5)+Math.pow(k,5)+Math.pow(l,5)){
              System.out.println(1000*i+100*j+10*k+l);
            }
          }
        }
      }
    }
  }
}
