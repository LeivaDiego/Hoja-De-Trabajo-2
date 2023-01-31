import java.util.ArrayList;
import java.util.Arrays;

public class PostfixCalculator implements IPostfixCalculator{
    private Stack<String> stack;
    private String[] digits;
    private String[] operators;

    public PostfixCalculator(){
        digits = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        operators = new String[]{"-","+","*","/"};

    }
    @Override
    public int Calculate(ArrayList postfix_expression) throws Exception {
        stack = new Stack<String>();
        int total=0;
        boolean flag = false;

        try {
            for (Object line: postfix_expression){
                String[] var = line.toString().split(" ");
                for(int i=0;i<var.length;i++) {
                    if(Arrays.stream(digits).anyMatch(var[i]::equals)) {
                        stack.push(var[i]);
                    }else if(Arrays.stream(operators).anyMatch(var[i]::equals)) {
                        if(stack.count()>=2) {
                            int n2 = Integer.parseInt((String) stack.pull());
                            int n1 = Integer.parseInt((String) stack.pull());
                            int result = 0;
                            switch (var[i]) {
                                case "-":
                                    result = n1-n2;
                                    break;
                                case "+":
                                    result = n1+n2;
                                    break;
                                case "*":
                                    result = n1*n2;
                                    break;
                                case "/":
                                    result = n1/n2;
                                    break;
                                default:
                                    break;
                            }
                            stack.push(result+"");
                        } else {
                            System.out.println("La estructura de la operacion no es correcta, faltan operandos para realizar la operacion");
                            flag = true;
                        }
                    }else {
                        System.out.println("La estructura de la operacion no es correcta, caracteres invalidos");
                    }
                }
                if(stack.count()==1) {
                    total = Integer.parseInt((String) stack.pull());
                }else {
                    System.out.println("La estructura de la operacion no es correcta, faltan operadores");
                }
                if (flag) return 0;
                else return total;
            }

        }catch (Exception e){
            System.out.println("MATH ERROR");
            e.printStackTrace();
        }
        return total;
    }
}
