package com.day11;

public class Circle {
	private static final double PI = 3.14;
	public double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void steRadius(double radius) {
		this.radius = radius;
	}
	public void draw() {
		System.out.println("반지름" + radius + "cm인 원을 그립니다.");
	}
}