package po;

public class Formula {

	private float result;
	private String formulaString;

	public Formula(float result, String formulaString) {
		super();
		this.result = result;
		this.formulaString = formulaString;
	}
	
	@Override
	public String toString() {
		return formulaString + "=";
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	public String getFormulaString() {
		return formulaString;
	}

	public void setFormulaString(String formulaString) {
		this.formulaString = formulaString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formulaString == null) ? 0 : formulaString.hashCode());
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
		if (formulaString == null) {
			if (other.formulaString != null)
				return false;
		} else if (!formulaString.equals(other.formulaString))
			return false;
		if (Float.floatToIntBits(result) != Float.floatToIntBits(other.result))
			return false;
		return true;
	}

}
