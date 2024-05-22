package com.interview.designpatterns.factory;

interface Pizza {
	String prepare();
}

class PizzaDecorator implements Pizza {
	protected Pizza pizza;

	PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String prepare() {

		return pizza.prepare();
	}

}

class PlainPizza implements Pizza {

	@Override
	public String prepare() {

		return "Plain Pizza";
	}

}

class CheeseDecorator extends PizzaDecorator {

	public CheeseDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String prepare() {
		return super.prepare() + " with Cheese";
	}
}

class PepperoniDecorator extends PizzaDecorator {

	PepperoniDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String prepare() {
		return super.prepare() + " with Pepperoni";
	}
}

class VeggieDecorator extends PizzaDecorator {

	VeggieDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String prepare() {

		return super.prepare();
	}
}

public class DecorateDesignPattern {
	public static void main(String[] args) {
		// Create a plain pizza
		Pizza pizza = new PlainPizza();
		System.out.println("Base Pizza: " + pizza.prepare());

		// Add cheese topping
		pizza = new CheeseDecorator(pizza);
		System.out.println("Pizza with Cheese: " + pizza.prepare());

		// Add pepperoni topping
		pizza = new PepperoniDecorator(pizza);
		System.out.println("Pizza with Pepperoni: " + pizza.prepare());

		// Add veggie topping
		pizza = new VeggieDecorator(pizza);
		System.out.println("Pizza with Veggies: " + pizza.prepare());

		// Add multiple toppings
		pizza = new VeggieDecorator(new CheeseDecorator(new PepperoniDecorator(new PlainPizza())));
		System.out.println("Deluxe Pizza: " + pizza.prepare());
	}
}
