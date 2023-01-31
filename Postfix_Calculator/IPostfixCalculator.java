/**
 * @author Seccion 40
 * Interfaz para las operaciones postfix
 */

public interface IPostfixCalculator<T> {

	/**
	 * Metodo de operaciones
	 * @param postfix_expression un arraylist generico
	 * @return un valor de tipo int con el resultado de la operacion
	 * @throws Exception
	 */
	public int Calculate(java.util.ArrayList<T> postfix_expression) throws Exception;
	
}