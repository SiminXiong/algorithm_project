package data_Structure.stack;

public class test {
    public static void main(String[] args) {

        Stack<String> stack=new Stack<>();


        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        for(String item:stack){
            System.out.println(item);
        }
        System.out.println("-----------------");

        //测试弹栈
        String result=stack.pop();
        System.out.println("pop result is："+result);
        System.out.println(stack.size());
    }
}
