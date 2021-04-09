import java.util.*;

class Student{
  private int id;
  private String tel;
  public Student(int id,String tel){this.id=id;this.tel=tel;}
  public int getId(){return id;}
  public String getTel(){return tel;}
}

public class Main{
  public static void main(String[] args) {
    //(학생이름,Student객체)를 저장하는 해시맵 생성.
    var map=new HashMap<String,Student>();
    map.put("황기태",new Student(1,"010-1111-2222"));
    map.put("곽삼칠",new Student(2,"010-2222-3333"));
    map.put("최춘식",new Student(3,"010-3333-4444"));

    // Scanner scanner=new Scanner(System.in);
    // while(true){
    //   System.out.print("검색할 이름은?");
    //   String name=scanner.nextLine();//사용자로부터 이름 입력.
    //   if(name.equals("exit")) break;
    //   Student student=map.get(name);//이름에 해당하는 Student객체 검색.
    //   if(student==null) System.out.println(name+"은 없는 사람입니다.");
    //   else System.out.println("id: "+student.getId()+", 전화: "+student.getTel());
    // }
    // scanner.close();

    Set<String>keys=map.keySet();
    
    Iterator<String>it=keys.iterator();
    Vector<String> v=new Vector<String>();
    while(it.hasNext()){
      String name=it.next();
      v.add(name);
    }
    Collections.sort(v);
    it=v.iterator();
    while(it.hasNext()){
      String name=it.next();
 
    
    
      Student student=map.get(name);//이름에 해당하는 Student객체 검색.
    
      System.out.println("id: "+student.getId()+", 전화: "+student.getTel());
    }

  }
}
