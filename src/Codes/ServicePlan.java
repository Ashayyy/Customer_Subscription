package Codes;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);

	private double plan;

	private ServicePlan(double plan) {
		this.plan = plan;
	}

	public double getPlan() {
		return plan;
	}

	public void setPlan(double plan) {
		this.plan = plan;
	}

}
