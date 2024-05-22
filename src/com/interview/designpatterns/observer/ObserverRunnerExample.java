package com.interview.designpatterns.observer;

public class ObserverRunnerExample {
	public static void main(String[] args) {
		System.out.println("Start Weather reporting :\n");
		WeatherStation weatherStation = new WeatherStation();
		DisplayUnit displayUnit1 = new DisplayUnit();
		weatherStation.registerObserver(displayUnit1);
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5;i++) {

			        weatherStation.setWeatherData(Math.random()*(100-50), Math.random()*(100-50));
			        try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		t.start();
		System.out.println("End Weather reporting :\n");
	}
}
