package com.test.spring.el;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * spring el表达式
 * 
 * @author zhengy
 * @date: 2019年5月16日 下午5:18:24
 */
public class SpellParser {
	private static ExpressionParser parser = new SpelExpressionParser();

	public static String getKey(String key, String[] parameterNames, Object[] values) {

		// 1.将key字符串解析为el表达式
		Expression exp = parser.parseExpression(key);
		// 初始化赋值上下文
		EvaluationContext context = new StandardEvaluationContext();
		if (values.length < 1) {
			return "";
		}
		// 2.将形参和形参值配对，并配置到赋值上下文中
		for (int i = 0; i < values.length; i++) {
			context.setVariable(parameterNames[i], values[i]);
		}
		// 3.在上下文环境中运算el表达式
		return exp.getValue(context, String.class);
	}

	public static void main(String[] args) {
		String key = "#id+'   是   '+#name";
		String[] paramNames = { "id", "name", "a" };
		String[] values = { "11", "郑义", "aa" };
		String rst = getKey(key, paramNames, values);
		System.out.println(rst);
	}
}
