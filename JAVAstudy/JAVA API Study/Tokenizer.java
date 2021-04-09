String s="2+3+5+66+88+323";
        StringTokenizer st=new StringTokenizer(s,"+");
        int sum=0;
        while (st.hasMoreTokens()){
            int a=Integer.parseInt(st.nextToken());
            //int a=new Integer(st.nextToken());
            sum+= a;
        }
        System.out.println(sum);
