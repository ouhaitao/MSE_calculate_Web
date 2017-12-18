package Dao;

import java.util.List;

import po.Formula;

public interface MainDao {
	public static final char plus = '+';
	public static final char minus = '-';
	public static final char multiplication = '*';
	public static final char division = '/';
	char[] flag = { plus, minus, multiplication, division };
	
	public List<Formula> calculator(int flagNumber);
}
