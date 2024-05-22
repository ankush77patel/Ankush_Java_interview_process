package com.interview.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {

	private double temp;
	private double humidity;
	private List<Observer> observers=new ArrayList<>();


	public void setWeatherData(double temp, double humidity) {
		this.temp = temp;
		this.humidity = humidity;
		notifyObserver();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);

	}
	

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	@Override
	public void notifyObserver() {
		for (Observer o : observers) {
			o.update(this.temp,this.humidity);
		}

	}

}
