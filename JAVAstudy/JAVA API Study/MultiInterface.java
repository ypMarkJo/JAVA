interface PhoneInterface{//인터페이스 선언.
  static final int TIMEOUT=10000;//상수 필드,public static final 생략 가능.
  abstract void sendCall();//추상메소드,public abstract 생략가능 
  abstract void receiveCall();//추상메소드,public abstract 생략 가능
  default void printLogo(){//default 메소드,public생략가능.
    System.out.println("**Phone**");
  };//디폴트 메소드
}
interface MobilePhoneInterface extends PhoneInterface{
  void sendSMS();
  void receiveSMS();
}
interface MP3Interface{
  void play();
  void stop();
}
class PDA{
  public int calculate(int x,int y){
    return x+y;
  }
}
//SmartPhone 클래스는 PDA를 상속받고, MobilePhoneInterface와 MP3Interface인터페이스에 선언된 추상 메소드를 모두 구현한다.
class SmartPhone extends PDA implements MobilePhoneInterface,MP3Interface{
  //MobilePhoneInterface의 모든 메소드 구현
  @Override
  public void sendCall(){
    System.out.println("띠리리리리링");
  }
   @Override
  public void receiveCall(){
    System.out.println("전화가 왔습니다.");
  }
    @Override
  public void sendSMS(){
    System.out.println("문자가 갑니다.");
  }
    @Override
  public void receiveSMS(){
    System.out.println("문자가 왔습니다.");
  }
  //MP3Interface 의 추상 메소드 구현.
    @Override
  public void play(){
    System.out.println("음악을 연주합니다.");
  }
    @Override
  public void stop(){
    System.out.println("음악을 중단합니다.");
  }
  public void schedule(){
    System.out.println("일정을 관리합니다.");
  }

}
class Main{
  public static void main(String[] args) {
    SmartPhone phone=new SmartPhone();
    phone.printLogo();
    phone.sendCall();
    phone.play();
    System.out.println("3과 5를 더하면"+phone.calculate(3, 5));
    phone.schedule();
  }
}
