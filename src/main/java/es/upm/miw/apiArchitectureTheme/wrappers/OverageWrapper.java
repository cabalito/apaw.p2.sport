package es.upm.miw.apiArchitectureTheme.wrappers;

public class OverageWrapper {
	private double overage;

	public OverageWrapper(double overage) {
		this.setOverage(overage);
	}

	public double getOverage() {
		return overage;
	}

	public void setOverage(double overage) {
		this.overage = overage;
	}

	@Override
	public String toString() {
		return "{\"overage\":" + overage + "}";
	}

}