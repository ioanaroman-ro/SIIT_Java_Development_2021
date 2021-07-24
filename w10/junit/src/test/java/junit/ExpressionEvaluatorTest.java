package junit;

import static org.siit.BinaryOperator.ADD;
import static org.siit.BinaryOperator.DIVIDE;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.siit.Expression;
import org.siit.ExpressionEvaluator;
import org.siit.ValidationException;

public class ExpressionEvaluatorTest {

	private static int evaluate(Object... elem) {
		List<Object> elements = Arrays.asList(elem);
		Expression expr = Mockito.mock(Expression.class);
		Mockito.when(expr.getElements()).thenReturn(elements);
		return ExpressionEvaluator.evaluate(expr);
	}
	
	@Test
	public void testZeroConstant() {
		Assert.assertEquals(
				0, evaluate(0));
	}
	
	@Test
	public void testFiveConstant() {
		Assert.assertEquals(
				5, evaluate(5));
	}
	
	@Test
	public void testMultiDigitConstant() {
		Assert.assertEquals(
				44232, evaluate(44232));
	}
	
	@Test
	public void testSimpleAddition() {
		Assert.assertEquals(
				5, evaluate(3, ADD, 2));
	}

	@Test(expected = ValidationException.class)
	public void divisionByZeroThrowsException() {
		Assert.assertEquals(
				0, evaluate(3, DIVIDE, 0));
	}
	
}
