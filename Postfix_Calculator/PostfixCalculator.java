import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author diego leiva
 * @author pablo orellana
 */
public class PostfixCalculator implements IPostfixCalculator{
    private Stack<String> stack;    // variable que almacena el stack
    private String[] digits;        // variable que almacena los posibles digitos
    private String[] operators;     // variable que almacena los posibles operadores

    /**
     * Constructor de la calculadora Postfix
     */
    public PostfixCalculator(){
        digits = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        operators = new String[]{"-","+","*","/"};

    }

    /**
     *  Metodo implementado de la interface IPostfixCalculator
     * @param postfix_expression    arraylist que contiene las diferences operaciones
     * @return  valor de tipo int con el resultado final de la operacion realizada
     * @throws Exception    si existe algun error
     */
    @Override
    public int Calculate(ArrayList postfix_expression) throws Exception {
        stack = new Stack<String>(); // El stack con los valores a operar
        int total=0;                 // variable que almacena el valor total de la operacion
        boolean flag = false;        // bandera en caso de que la operacion no sea posible

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
                            switch (var[i]) {       // Switch para cada tipo de operacion
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
                            System.out.println("Faltan operandos para realizar la operacion correctamente");
                            flag = true;
                        }
                    }else {
                        System.out.println("Caracteres invalidos");
                    }
                }
                if(stack.count()==1) {
                    total = Integer.parseInt((String) stack.pull());
                }else {
                    System.out.println("faltan operadores para realizar la operacion correctamente");
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
