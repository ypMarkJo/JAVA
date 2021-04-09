// //출력
// InputStreamReader in=null;
//         FileInputStream fn=null;
//         try{
//             fn=new FileInputStream("/home/mark/바탕화면/text.txt");
//             in=new InputStreamReader(fn,"utf-8");
//             int c;
//             System.out.println("인코딩 문자 집합은 "+in.getEncoding());
//             while((c= in.read())!=-1) System.out.print((char)c);
//             in.close();
//             fn.close();
            
//         }
//         catch (IOException e){
//             System.out.println("입출력 오류");
//         }

// //입력
// Scanner scanner=new Scanner(System.in);
//       FileWriter fout=null;
//       int c;
//       try{
//           fout=new FileWriter("/home/mark/바탕화면/한글.txt");
//           while(true){
//               String line=scanner.nextLine();
//               if(line.length()==0) break;

//               fout.write(line,0,line.length());
//               fout.write("\r\n",0,2);
//           }
//           fout.close();
//       }catch (IOException e){
//           System.out.println("입출력 오류");
//       }
//       scanner.close();

// //바이트 스트림
// byte b[]={7,51,3,4,-1,24};

//         try{
//             FileOutputStream fout=new FileOutputStream("/home/mark/바탕화면/test.out");
//             for(int i=0;i<b.length;i++) fout.write(b[i]);
//             fout.close();
//         }catch (IOException e){
//             System.out.println("저장할 수 없습니다. 경로명을 확인해 주세요.");
//             return;
//         }
//         System.out.println("저장 완료");


//         package com.tuyano.gradle;


//교수님 요구사항 중복되는 이름 리스트 따로 저장하는 텍스트 생성.

package com.tuyano.gradle;


import java.io.*;
import java.nio.CharBuffer;
import java.util.*;


public class JAVAprac {
    public static void main(String[] args) {
        FileInputStream fn = null;
        InputStreamReader in = null;
        Vector<String> v1 = new Vector<String>();
        Vector<String> v2 = new Vector<String>();
        String str = "";
        //1번 파일 불러오기.
        try {
            fn = new FileInputStream("/home/mark/바탕화면/1.txt");
            int data = 0;
            while ((data = fn.read()) != -1) {
                str = str + (char) data;
            }
            fn.close();
        } catch (IOException e) {
            System.out.println("출력 오류");
        }
        StringTokenizer st = new StringTokenizer(str, "\n");
        while (st.hasMoreTokens()) v1.add(st.nextToken());


        //2번 파일 불러오기.
        str = "";
        try {
            fn = new FileInputStream("/home/mark/바탕화면/2.txt");
            int data = 0;
            while ((data = fn.read()) != -1) {
                str = str + (char) data;
            }
            fn.close();
        } catch (IOException e) {
            System.out.println("출력 오류");
        }
        st = new StringTokenizer(str, "\n");
        while (st.hasMoreTokens()) {
            String sx = st.nextToken();
            v2.add(sx);
        }

        //3번 파일에 저장하기.

        FileWriter fout = null;
        int cnt = 0;
        try {
            fout = new FileWriter("/home/mark/바탕화면/3.txt");
            while (cnt != v1.size()) {
                if (v2.contains(v1.get(cnt))) {
                    String a=v1.get(cnt);
                    fout.write(a);
                }
                cnt++;
            }
            fout.close();
        } catch (IOException e) {
            System.out.println("입력오류");
        }

        String s = new String();
        // 다시 3번 불러오기.
        StringBuffer sb = new StringBuffer();
        try {
            FileReader fn2 = new FileReader("/home/mark/바탕화면/3.txt");
            int data = 0;
            while ((data = fn2.read()) != -1) {
                if((char)data=='\r') s=s+'\n';
                s=s+(char)data;
            }
            System.out.print(s);
            fn2.close();
        } catch (IOException e) {
            System.out.println("출력 오류");
        }
    }
}







