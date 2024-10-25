package com.accenture.lkm.exceptions;

@SuppressWarnings("serial")
public class InvalidUpdateOperationException extends Exception {
	public InvalidUpdateOperationException() {
		super("Entered Task doesn't exist, Please give a valid taskId to Update");
	}

}
