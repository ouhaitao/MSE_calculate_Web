package Dao;

import java.util.Stack;

public class Calculator {

	static char[][] operation = { { '*', '+' }, { '/', '-' } };
	
	/**
	 * 
	 * @param a
	 *            操作符a
	 * @param b
	 *            操作符b
	 * @return 1:a优先级高于b 0:b优先级等于a -1:a优先级小于b
	 */
	private static int priority(char a, char b) {
		if (b == ')' || b == '(')
			return 1;
		int a1 = -1, b1 = -1;
		for (int i = 0; i < operation.length; i++)
			for (int j = 0; j < operation[i].length; j++) {
				if (operation[i][j] == a)
					a1 = j;
				if (operation[i][j] == b)
					b1 = j;
			}

		if (a1 < b1)
			return 1;
		else if (a1 == b1)
			return 0;
		else
			return -1;
	}
	
	private static Stack<Object> toLast(String a) {
		Stack<Character> s1 = new Stack<>();
		Stack<Object> s2 = new Stack<>();
		//匹配字符串中的数字
		String[] param=a.split("[^0-99]");
		//以字符串中的数字为分隔符(会有空字符串产生)
		String[] temp=a.split("[0-99]");
		int size=param.length;
		String[] flag=new String[size-1];
		int i=0;
		for (String string : temp) {
			if(!string.isEmpty())
				flag[i++]=string;
		}
		s2.push(param[0]);
		for(i=1;i<size;i++){
			while(true){
				if(s1.isEmpty()){
					s1.push(flag[i-1].charAt(0));
					break;
				}
				char b=s1.peek();
				char f=flag[i-1].charAt(0);
				if(priority(f, b)==1){
					s1.push(f);
					break;
				}else
					s2.push(s1.pop());
			}
			s2.push(param[i]);
		}
		while (!s1.isEmpty())
			s2.push(s1.pop());
		return s2;
	}
	
	public static float Calculation_last(String formula){
		Stack<Object> stack=toLast(formula);
		int size=stack.size();
		Stack<Object> s=new Stack<>();
		for(int i=0;i<size;i++)
			s.push(stack.pop());
		Stack<Float> s1=new Stack<>();
		
		while(!s.isEmpty()){
			while(true){
				if(!(s.peek() instanceof Character)){
					s1.push(Float.parseFloat((String)s.pop()));
					continue;
				}else
					break;
			}
			float a=s1.pop();
			float b=s1.pop();
			char c=(Character)s.pop();
			switch(c){
			case '+':
				s1.push(a+b);
				break;
			case '-':
				s1.push(b-a);
				break;
			case '*':
				s1.push(a*b);
				break;
			case '/':
				s1.push(b/a);
				break;
			}
		}
		return s1.pop();
	}	
}
