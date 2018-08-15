package com.cq.interview.algorithm;

import java.util.*;

/**
 * @Auther: caoqsq
 * @Date: 2018/8/15 15:54
 * @Description: list对象根据某个字段分组输出
 */
public class ListGroup {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(17,"aa"));
        list.add(new Student(15,"bb"));
        list.add(new Student(16,"cc"));
        list.add(new Student(15,"dd"));
        list.add(new Student(16,"ee"));
        list.add(new Student(17,"ff"));

        Map<Integer, List<Student>> map = new HashMap<>();
        for (Student stu : list) {
            List<Student> tempList = map.get(stu.getAge());
            if (tempList == null) {
                tempList = new ArrayList<>();
                tempList.add(stu);
                map.put(stu.getAge(), tempList);
            } else {
                tempList.add(stu);
            }
        }

        for(Integer age : map.keySet()){
            System.out.println(map.get(age));
        }
       /* List<List<Student>> list2 = dividerList(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 按年龄分组,这里注意一点，返回的值为0，就会认为这两个Studeng是一组的，返回其他值，则认为不是，所以下面的-1可以替换为任意非0数字
                return o1.getAge() == o2.getAge() ? 0:-1;
                //也可以按照姓名分组，返回结果如下，因为是比较两个值是否相等，所以先后是没有区别的
                //return o1.getName().compareTo(o1.getName())
            }
        });

        for(List<Student> stList: list2){
            stList.forEach(a -> System.out.println(a.getName()+":"+a.getAge()));
            System.out.println("=========================================");
        }*/

    }

    /**
     * 创建比较器
     */
    public static <T> List<List<T>> dividerList(List<T> list,Comparator<? super T> comparator) {
        List<List<T>> lists = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            boolean isContain = false;
            for (int j = 0; j < lists.size(); j++) {
                if (lists.get(j).size() == 0||comparator.compare(lists.get(j).get(0),list.get(i)) == 0) {
                    lists.get(j).add(list.get(i));
                    isContain = true;
                    break;
                }
            }
            if (!isContain) {
                List<T> newList = new ArrayList<>();
                newList.add(list.get(i));
                lists.add(newList);
            }
        }
        return lists;
    }
}
