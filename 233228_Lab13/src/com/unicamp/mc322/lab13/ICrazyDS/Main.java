package com.unicamp.mc322.lab13.ICrazyDS;

import java.time.Month;
import com.unicamp.mc322.lab13.ICrazyDS.Date.BirthDate;
import com.unicamp.mc322.lab13.ICrazyDS.Order.*;
import com.unicamp.mc322.lab13.ICrazyDS.Exceptions.*;
import com.unicamp.mc322.lab13.ICrazyDS.Strategy.*;

public class Main {
	
	public static void main(String[] args) {
		
		//ICrazyDS crazyDS = new CrazyDS(new PriorityScore());
		ICrazyDS crazyDS = new CrazyDS(new PriorityScorePlus());
		IOrder order1 = new InternetOrder(new PersonPT(new BirthDate(1985, Month.JANUARY, 1), "CPF1", "name1"), "ABC-123");
		IOrder order2 = new InternetOrder(new PersonPT(new BirthDate(1986, Month.JANUARY, 2), "CPF2", "name2"), "DEF-456");
		IOrder order3 = new InternetOrder(new PersonPT(new BirthDate(1987, Month.JANUARY, 3), "CPF3", "name3"), "GHI-789");
		
		crazyDS.addOrder(order1);
		crazyDS.addOrder(order2);
		crazyDS.addOrder(order3);
		
		System.out.println("---- A: Elements ----");
		crazyDS.printOrders();
		
		System.out.println("---- B: Getting and removing the element with highest priority ----");
		IOrder p1 = null;
		try {
			p1 = crazyDS.getHigherPriority();
			System.out.println("-selected element");
			p1.getClient();
			crazyDS.remOrder(p1);
			System.out.println("-elements");
			crazyDS.printOrders();
			
		} 
		catch (NonexistentElementException e) {
			e.printStackTrace();
			e.getNonexistentElement(p1);
		}
		catch (EmptyQueueException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("---- C: Adding an old person ----");
		IOrder order4 = new InternetOrder(new PersonPT(new BirthDate(1880, Month.JUNE, 1), "CPF", "name3"), "XYZ-999");
		crazyDS.addOrder(order4);
		crazyDS.printOrders();
		
		System.out.println("-selected element");
		IOrder p2 = crazyDS.getHigherPriority();
		p2.getTotalClientInformation();
		
		/*
		System.out.println("---- D: Checking an exception ----");
		try {	
			IOrder p3 = crazyDS.getElementAt(1000);
		} catch (CrazyDSException e) {
			//e.printStackTrace();
			System.out.println("-ok: Show error in logs");
		}
		*/
	}
}
