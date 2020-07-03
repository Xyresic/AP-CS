public class RationalNumber extends RealNumber{
  private int numerator, denominator;
  public RationalNumber(){
    numerator = 0;
    denominator = 1;
  }
  public RationalNumber(int num, int den){
    if(den==0){
      numerator=0;
      denominator=1;
    }
    else if(den<0){
      numerator=-num;
      denominator=-den;
    }
    else{
      denominator = den;
      numerator = num;
    }
    int factor = RationalNumber.gcd(numerator,denominator);
    numerator/=factor;
    denominator/=factor;
  }
  public int getNumerator(){
    return numerator;
  }
  public int getDenominator(){
    return denominator;
  }
  public double getValue(){
    return ((double)numerator)/denominator;
  }
  public RationalNumber add(RationalNumber other){
    int newden = RationalNumber.lcm(denominator,other.denominator);
    int newnum1 = newden/denominator*numerator;
    int newnum2 = newden/other.denominator*other.numerator;
    return (new RationalNumber(newnum1+newnum2,newden)).reduce();
  }
  public RationalNumber subtract(RationalNumber other){
    return this.add(new RationalNumber(-(other.numerator), other.denominator));
  }
  public RationalNumber multiply(RationalNumber other){
    return (new RationalNumber(numerator*other.numerator,denominator*other.denominator)).reduce();
  }
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator,numerator);
  }
  public boolean equals(RationalNumber other){
    return numerator*other.getDenominator()==denominator*other.getNumerator();
  }
  private static int gcd(int a, int b){
    if(a<0){
      a*=-1;
    }
    if(b<0){
      b*=-1;
    }
    int smaller = a<=b? a:b;
    for(int x = smaller; x > 0; x--){
      if(a%x==0 && b%x==0){
        return x;
      }
    }
    return 1;
  }
  private static int lcm(int a, int b){
    int smaller = a<=b? a:b;
    for(int x = smaller; x < a*b; x+=smaller){
      if(x%a==0 && x%b==0){
        return x;
      }
    }
    return a*b;
  }
  private RationalNumber reduce(){
    int factor = RationalNumber.gcd(numerator,denominator);
    return new RationalNumber(numerator/factor,denominator/factor);
  }
  public String toString(){
    return numerator==0? "0":numerator+(denominator==1? "":"/"+denominator);
  }
}
