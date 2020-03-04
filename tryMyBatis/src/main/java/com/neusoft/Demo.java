package com.neusoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args){
        Student st = new Student(1,"张三",55.6,"2012-12-12");
        String name = st.getName();
        System.out.println(name);

        String s = "This is example";
        int len = s.length();
        System.out.println(len);
        int index = s.indexOf("i");
        System.out.println(index);
        String s1 = s.substring(3,9);
        System.out.println(s1);

        int[] arr = new int[4];
        int[] arr1 = {1,2,3,4};
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
        for(int k:arr1){
            System.out.print(k);
        }

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for(String s2:list){
            System.out.println(s2);
        }

        String s3 = list.get(1);
        int size = list.size();

        List<Student> list1 = new ArrayList<Student>();

        //<key,value>
        Map<String,Object> hm = new HashMap<String,Object>();
        hm.put("name","张三");
        hm.put("age",22);

        String name1 = (String)hm.get("name");
        int age = (Integer)hm.get("age");

    }

}
