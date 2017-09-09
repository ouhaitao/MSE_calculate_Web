package po;

import java.util.List;

public class Formula {

	private List<Integer> number;
	private List<String> flag;
	private float result;
	private String formulaString;

	public List<Integer> getNumber() {
		return number;
	}


	@Override
	public String toString() {
		return formulaString + "=";
	}


	public void setNumber(List<Integer> number) {
		this.number = number;
	}

	public List<String> getFlag() {
		return flag;
	}

	public void setFlag(List<String> flag) {
		this.flag = flag;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + Float.floatToIntBits(this.result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formula other = (Formula) obj;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (Float.floatToIntBits(result) != Float.floatToIntBits(other.result))
			return false;
		return true;
	}

	public String getFormulaString() {
		return formulaString;
	}

	public void setFormulaString(String formulaString) {
		this.formulaString = formulaString;
	}

}
