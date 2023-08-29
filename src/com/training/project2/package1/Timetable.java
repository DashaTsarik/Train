package com.training.project2.package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Timetable {
	
	private List<Train> trains;
	
	public Timetable() {
		trains = new ArrayList<Train>();
	}
	
	public Train getTrain(int i){
		return trains.get(i);
	}
	
	public int getSizeOfTimetable() {
		return trains.size();
	}
	
	public boolean addTrain(Train t) {
		return trains.add(t);
		
	}
	
	public Train findByNumberUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите номер поезда > ");
		while(!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.println("Вы ввели некорректные данные.");
			System.out.print("Введите номер поезда > ");
		}
		int number = scanner.nextInt();
		Train foundByNumber = findByNumber(number);
		if (foundByNumber != null) {
			return foundByNumber;
		}
		
		return null;
		
	}
	
	public Train findByNumber(int number) {
		for (int i = 0; i < trains.size(); i++) {
			Train t = trains.get(i);
			int numberOfTrain = t.getNumberOfTrain();
			if (number == numberOfTrain) {
				return t;
			}	
		} 
		return null;
	
	}
	
	public int findPosition(Train train) {
		int index = -1;
		for (int i = 0; i < trains.size(); i++) {
			Train t = trains.get(i);
			if (train.getNumberOfTrain() == t.getNumberOfTrain()){
				index = i;
			}
		}
		return index;
	}
	
	public void sortByNumber() {
		
		for (int i = 0; i < trains.size() - 1; i++) {
			Train minNumberTrain = trains.get(i);
			int minTrainNumberIndex = i;
			
			for(int j = i + 1; j < trains.size(); j++) {
				if (trains.get(j).getNumberOfTrain() < minNumberTrain.getNumberOfTrain()) {
					minNumberTrain = trains.get(j);
					minTrainNumberIndex = j;
				}
			}
			
			Train temp = trains.get(i);
			trains.set(i, minNumberTrain);
			trains.set(minTrainNumberIndex, temp);
		}
	}

	
	public void sortByDestinationAndTime() {
		
		for (int indexOfCurrentTrain = 0; indexOfCurrentTrain < trains.size(); indexOfCurrentTrain++) {
			Train currentTrain = trains.get(indexOfCurrentTrain);
			
			for (int indexOfOtherTrain = 1; indexOfOtherTrain < trains.size(); indexOfOtherTrain++) {
				Train otherTrain = trains.get(indexOfOtherTrain);
				
				if (currentTrain.getDestination().compareTo(otherTrain.getDestination()) == 0) {
					trains.add(indexOfCurrentTrain,trains.get(indexOfOtherTrain));
					trains.remove(indexOfOtherTrain+1);
					indexOfCurrentTrain++;
					indexOfOtherTrain++;
				}
			}
		} 
		sortByTime();
	}
		
	public void sortByTime() {
		
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < trains.size() - 1; i++) {
				Train currentTrain = trains.get(i);
				int indexOfCurrentTrain = i;
				
				Train nextTrain = trains.get(i+1);
				int indexOfNextTrain = i + 1;
				
				Train temp = trains.get(i);
				if (currentTrain.getDestination().compareTo(nextTrain.getDestination()) == 0) {
					if (currentTrain.getHour() > nextTrain.getHour()) {
						isSorted = false;
						trains.set(indexOfCurrentTrain, nextTrain);
						trains.set(indexOfNextTrain, temp);
					}
				    else if (nextTrain.getHour() == currentTrain.getHour()) {
				    	if (currentTrain.getMin() > nextTrain.getMin()) {
				    		isSorted = false;
				    		trains.set(indexOfCurrentTrain, nextTrain);
							trains.set(indexOfNextTrain, temp);
						} 
					}
		    	}
		    }
		}
	}
	
}



