package com.interview.designpatterns.observer;

public class DisplayUnit implements Observer {

	private double temp;
	private double humidity;

	public DisplayUnit() {
		super();
	}

	@Override
	public void update(double temp,double humidity) {
		this.temp=temp;
		this.humidity=humidity;
		display();

	}

	public void display() {
		System.out.println("Temprature :" + this.temp + " Humidity :" + this.humidity);
	}

}
