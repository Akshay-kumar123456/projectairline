package com.airlinereservationsystem.main.dto;







public class PassengerDto {

	private String name;
	private int age;
	private String gender;
	private String seatNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	@Override
	public String toString() {
		return "PassengerDto [name=" + name + ", age=" + age + ", gender=" + gender + ", seatNumber=" + seatNumber
				+ "]";
	}
	
	
	
}
