package Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import po.Formula;

@Service
public class Main implements MainDao{
	
	public List<Formula> calculator(int flagNumber) {
		List<Formula> formula=new ArrayList<>();
		int i = 0;
		while (i < 10) {
			List<Integer> number = new ArrayList<>();

			// ���ɲ���
			for (int j = 0; j < flagNumber; j++) 
				number.add((int) (Math.random() * 99 + 1));
			
			int flagNum = 1;
			List<Character> flags = new ArrayList<>();

			// ���ɷ���
			do {
				int j = (int) (Math.random() * 4);
				flags.add(flag[j]);
				flagNum++;
			} while (flagNum < flagNumber);

			// ������ʽ
			StringBuffer formulaString=new StringBuffer(""+number.get(0));
			for (int x = 1; x < number.size(); x++) {
				int n = number.get(x);
				char f = flags.get(x - 1);
				formulaString.append(f+String.valueOf(n));
			}
			//����ֵ
			float result=Calculator.Calculation_last(formulaString.toString());
			formula.add(new Formula(result, formulaString.toString()));
			i++;
		}
		return formula;
	}
}
