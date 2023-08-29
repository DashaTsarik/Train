package com.training.project2.package1;

import java.util.Scanner;

public class TimetableMain {

	public static void main(String[] args) {
		
		Timetable trains = new Timetable();
		
		trains.addTrain(new Train("London", 15, 17, 15));
		trains.addTrain(new Train("Paris", 24, 13, 0));
		trains.addTrain(new Train("London", 9, 12, 45));
		trains.addTrain(new Train("Warsaw", 13, 14, 30));
		trains.addTrain(new Train("Paris", 22, 11, 0));
		
		System.out.println("---------------Расписание----------------");
		
		trains.sortByNumber();		
		print(trains);
		
		System.out.println("---------------Расписание----------------");
		
		trains.sortByDestinationAndTime();
		print(trains);
		
		printByNumberUserInput(trains);
		

	}
	
	public static void print(Timetable trains) {
		for( int i = 0; i<trains.getSizeOfTimetable(); i++) {
			Train t = trains.getTrain(i);
			if (t.getMin() < 10) {
				System.out.println("Поезд " + i + ":" + "\n\tПункт назначения: " + t.getDestination() +
				                  "\n\tНомер поезда: " + t.getNumberOfTrain() + "\n\tВремя отправления: "
						          + t.getHour() + ":" + "0" + t.getMin());
				System.out.println("-----------------------------------------");
			} else {
			    System.out.println("Поезд " + i + ":" + "\n\tПункт назначения: " + t.getDestination() +
			                      "\n\tНомер поезда: " + t.getNumberOfTrain() + "\n\tВремя отправления: "
			    		          + t.getHour() + ":" + t.getMin());
				System.out.println("-----------------------------------------");
			}
		}
	}
	
	public static void printByNumberUserInput (Timetable trains) {
		
		Train t = trains.findByNumberUserInput();
		if (t == null) {
			System.out.println("Такого поезда нет в расписании");
		}else if (t.getMin() < 10) {
			System.out.println("Пункт назначения: " + t.getDestination() + "\nНомер поезда: " + 
		                      t.getNumberOfTrain() + "\nВремя отправления: " + t.getHour() + ":" + 
				              "0" + t.getMin());
		} else {
			 System.out.println("Пункт назначения: " + t.getDestination() + "\nНомер поезда: " + 
		                      t.getNumberOfTrain() + "\nВремя отправления: " + t.getHour() + ":" + 
					          t.getMin());
		}
	}
	


}
