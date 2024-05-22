package com.interview.designpatterns.observer;

public interface Observable {
void registerObserver(Observer o);
void removeObserver(Observer o);
void notifyObserver();
}
