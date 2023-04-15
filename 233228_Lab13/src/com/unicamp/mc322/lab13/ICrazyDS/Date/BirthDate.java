package com.unicamp.mc322.lab13.ICrazyDS.Date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class BirthDate {
	
	private int birthYear, birthDay;
	private Month birthMonth;
	
	public BirthDate(int birthYear, Month birthMonth, int birthDay) {
		
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
	}
	
	public int getAge() {
		return Period.between(LocalDate.of(this.birthYear , this.birthMonth , this.birthDay ), LocalDate.now()).getYears();
	}
}
