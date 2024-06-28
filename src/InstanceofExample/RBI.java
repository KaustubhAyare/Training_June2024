package InstanceofExample;

public class RBI {
	double interest=5.5;
	public double getInterest()
	{
		return 0;
	}
}
class SBI extends RBI
{
	double interest=super.interest+4.5;
	public double getInterest()
	{
		return interest;
	}
	public void setInterest(double interest)
	{
	this.interest=interest;
	}
}
class BOI extends RBI
{
	double interest=super.interest+1.5;
	public double getInterest()
	{
		return interest;
	}
	public void setInterest(double interest)
	{
	this.interest=interest;
	}
}