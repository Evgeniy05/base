package com.exmaples.factory;

import java.io.IOException;

public class AddElementException extends IOException {
	public AddElementException() {
	}

	public AddElementException(String gripe) {
		super(gripe);
	}

}
