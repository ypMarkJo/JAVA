import java.util.*;


public class Main{
  public static void main(String[] args) {
   //이름과 점수를 저장할 HashMap컬렉션 생성.
   HashMap<String,Integer> scoreMap=new HashMap<String,Integer>();
   //var scoreMap=new HashMap<String,Integer>();로 간략히 써도 됨

   //5개의 점수 저장.
   scoreMap.put("김성동",97);
   scoreMap.put("박광철",88);
   scoreMap.put("최칠두",65);
   scoreMap.put("이창권",81);
   scoreMap.put("곽삼철",92);

   System.out.println("HashMap의 요소 개수 : "+scoreMap.size());

   //모든 사람의 점수 출력. scoreMap에 들어있는 모든(key,value)쌍 출력.
   Set<String>keys=scoreMap.keySet();//모든 key를 가진 Set컬렉션 리턴.
   Iterator<String>it=keys.iterator();//Set에 있는 모든 key를 순서대로 검색하는  Iterator리턴.

   while(it.hasNext()){
     String name=it.next();//다음 키.학생 이름.
     int score=scoreMap.get(name);//점수 알아내기.
     System.out.println(name+" : "+score);
    }
  }
}
