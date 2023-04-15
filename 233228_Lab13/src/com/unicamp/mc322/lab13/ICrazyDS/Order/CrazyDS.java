package com.unicamp.mc322.lab13.ICrazyDS.Order;

import java.util.LinkedList;
import com.unicamp.mc322.lab13.ICrazyDS.Strategy.*;
import com.unicamp.mc322.lab13.ICrazyDS.Exceptions.*;

public class CrazyDS implements ICrazyDS {

	private LinkedList<IOrder> priorityQueue;
	private IOrderingStrategy strategy;
	
	public CrazyDS(IOrderingStrategy strategy) {
		
		this.priorityQueue = new LinkedList<IOrder>();
		this.strategy = strategy;
	}
	
	public void addOrder(IOrder x) {
		
		if(this.priorityQueue.isEmpty()) {
			
			this.priorityQueue.add(x);
			return;
		}
		
		for(int i = 0; i < this.priorityQueue.size(); i++) {
				
			if(strategy.calculatePriorityPoints(x) > this.priorityQueue.get(i).getPriorityPoints()) {
				
				int newPos = i+1;
				IOrder aux1 = this.priorityQueue.get(i);
				IOrder aux2 = null;
				
				this.priorityQueue.add(i, x);
				
				while(true) {
					
					if(this.priorityQueue.get(newPos+1) != null) {
						
						aux2 = this.priorityQueue.get(newPos+1);
						this.priorityQueue.add(newPos, aux1);
						aux1 = aux2;
						newPos++;
					}
					else {
						break;
					}
				}
				break;
			}
		
		}
		
		if(!this.priorityQueue.contains(x)) {
			
			this.priorityQueue.add(x);
		}
	}
	
	public void remOrder(IOrder x) {
		
		if(this.priorityQueue.isEmpty()) {
			throw new EmptyQueueException("A lista está vazia");
		}
		else {
			
			if(this.priorityQueue.contains(x)) {
				
				for(int i = 0; i < this.priorityQueue.size(); i++) {
					
					if(this.priorityQueue.get(i).equals(x)) {
						
						this.priorityQueue.remove(i);
						break;
					}
				}
			}
			else {
				throw new NonexistentElementException("O elemento referido não existe na lista");
			}
		}
	}
	
	public IOrder getHigherPriority() {
		
		if(this.priorityQueue.isEmpty()) {
			throw new EmptyQueueException("A lista está vazia");
		}
		else {
			return this.priorityQueue.get(0);
		}
	}
	
	public void printOrders() {
		
		if(this.priorityQueue.isEmpty()) {
			throw new EmptyQueueException("A lista está vazia");
		}
		else {
			
			for(int i = 0; i < this.priorityQueue.size(); i++) {
				
				System.out.println(this.priorityQueue.get(i).getPartClientInformation() + " " + this.priorityQueue.get(i).getId() + " " + this.priorityQueue.get(i).getPriorityPoints());
			}
		}
	}
}
