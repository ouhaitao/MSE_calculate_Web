package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import po.Formula;

@Service
public class Main implements MainDao{
	
	public List<Formula> calculator(int flagNumber) {
		List<Formula> FormulaList = new ArrayList<>();// 生成的算式
		int i = 0;
		while (i < 10) {
			Formula formula = new Formula();
			List<Integer> number = new ArrayList<>();
			
			// 生成参数
			for (int j = 0; j < flagNumber; j++) {
				number.add((int) (Math.random() * 99 + 1));
			}
			int j = 0;
			int flagNum = 1;
			List<String> flags = new ArrayList<>();
			
			// 生成符号
			do {
				j = (int) (Math.random() * 4);
				if (j != 4) {
					flags.add(flag[j]);
					flagNum++;
				}
			} while (j == 4 || flagNum < flagNumber);
			
			// 连接算式
			String formulaString = number.get(0).toString();
			for (int x = 1; x < number.size(); x++) {
				int n = number.get(x);
				String f = flags.get(x - 1);
				formulaString = formulaString + f + Integer.toString(n);
			}
			System.out.println(formulaString);
			float result = 0;
			Stack<Float> is = new Stack<>();
			Stack<String> ss = new Stack<>();

			// 计算算式中的乘除法
			is.push(number.get(0).floatValue());
			for (int x = 0; x < flags.size(); x++) {
				String f = flags.get(x);
				if (f.equals("*") || f.equals("/")) {
					if (f.equals("*"))
						is.push(is.pop() * number.get(x + 1));
					else
						is.push(is.pop() / number.get(x + 1));
				} else {
					ss.push(f);
					is.push(number.get(x + 1).floatValue());
				}
			}

			// 计算算式的中的加减法
			result = is.pop();
			while (!is.empty() && !ss.isEmpty()) {
				float n = is.pop();
				String f = ss.pop();
				if (f.equals("-"))
					result = n - result;
				else
					result += n;
			}

			formula.setFlag(flags);
			formula.setNumber(number);
			formula.setResult(result);
			formula.setFormulaString(formulaString);
			if (!FormulaList.contains(formula)) {
				FormulaList.add(formula);
				i++;
			}
		}
		return FormulaList;
	}
}
