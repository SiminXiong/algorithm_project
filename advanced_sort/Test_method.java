package advanced_sort;

import advanced_sort.shell_sort.insertion;
import advanced_sort.shell_sort.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test_method {
    public static void main(String[] args) throws Exception{
       //create an array for saving data
        ArrayList<Integer> list=new ArrayList<>();
        //2.read data and save it
        BufferedReader reader=new BufferedReader(new InputStreamReader(Test_method.class.getClassLoader().getResourceAsStream("")));
        String line=null;
        while((line=reader.readLine())!=null){
            int i=Integer.parseInt(line);
            list.add(i);
        }
        reader.close();
        //3.change arraylist to array
        Integer[] a=new Integer[list.size()];
        list.toArray(a);

        //4.call code
        testinsertion(a);
        testshell(a);
    }

    //tset shell sort
    public static void testshell(Integer[] a){
        //1.get start time
        long start = System.currentTimeMillis();

        //2.excecute
        shell.sort(a);

        //3.get time after excecuting
        long end=System.currentTimeMillis();

        //4.get excecute time
        System.out.println("shell sort time："+(end-start));

    }

    //test insertion sort
    public static void testinsertion(Integer[] a){

        long start = System.currentTimeMillis();


        insertion.sort(a);


        long end=System.currentTimeMillis();


        System.out.println("insertion sort time："+(end-start));

    }

    //test merge sort
    public static void testmerge(Integer[] a){
        long start1 = System.currentTimeMillis();


        insertion.sort(a);


        long end1=System.currentTimeMillis();


        System.out.println("merge sort time："+(end1-start1));

    }
}
