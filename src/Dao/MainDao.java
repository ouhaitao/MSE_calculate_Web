package Dao;

import java.util.List;

import po.Formula;

public interface MainDao {
	public static final String plus = "+";
	public static final String minus = "-";
	public static final String multiplication = "*";
	public static final String division = "/";
	String[] flag = { plus, minus, multiplication, division };
	
	public List<Formula> calculator(int flagNumber);
}
