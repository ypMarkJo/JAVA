interface PhoneInterface{//인터페이스 선언.
  static final int TIMEOUT=10000;//상수 필드,public static final 생략 가능.
  abstract void sendCall();//추상메소드,public abstract 생략가능 
  abstract void receiveCall();//추상메소드,public abstract 생략 가능
  default void printLogo(){//default 메소드,public생략가능.
    System.out.println("**Phone**");
  };//디폴트 메소드
}
class SamsungPhone implements PhoneInterface{//인터페이스 구현
  //PhoneInterface의 모든 메소드 구현
  @Override
  public void sendCall(){
    System.out.println("띠리리리리링");
  }
   @Override
  public void receiveCall(){
    System.out.println("전화가 왔습니다.");
  }
  public void flash(){
    System.out.println("전화기에 불이 켜졌습니다.");
  }
}
interface MobilePhoneInterface extends PhoneInterface{
  void sendSMS();
  void receiveSMS();
}
interface MP3Interface{
  void play();
  void stop();
}
interface MusicPhoneInterface extends MobilePhoneInterface,MP3Interface{
  void playMP3Ringtone();
}
class Main{
  public static void main(String[] args) {
    SamsungPhone phone=new SamsungPhone();
    phone.printLogo();
    phone.sendCall();
    phone.receiveCall();
    phone.flash();
  }
}
