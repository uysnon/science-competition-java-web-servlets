package ru.rsreu.sciencecompetition.datalayer.dao;

public class DBTypeException extends RuntimeException {
	public DBTypeException() {
		super();
	}

	public DBTypeException(String message) {
		super(message);
	}
}
