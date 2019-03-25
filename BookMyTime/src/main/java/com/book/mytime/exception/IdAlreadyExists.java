package com.book.mytime.exception;

public class IdAlreadyExists extends RuntimeException{

	private static final long serialVersionUID = 1L;

		public IdAlreadyExists(String exception)
		{
			super(exception);
		}
	}
