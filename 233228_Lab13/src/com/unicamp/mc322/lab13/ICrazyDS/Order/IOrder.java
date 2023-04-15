package com.unicamp.mc322.lab13.ICrazyDS.Order;

import com.unicamp.mc322.lab13.ICrazyDS.PersonPT;

public interface IOrder {

	public int getShifts();
	public String getId();
	public double getPriorityPoints();
	public void setPriorityPoints(double points);
	public String getPartClientInformation();
	public void getTotalClientInformation();
	public PersonPT getClient();
	public int getCustomPriority();
}
