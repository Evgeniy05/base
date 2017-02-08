
package com.exmaples.factory;

public class BodyCreator extends ItemCreator<Body> {

	public BodyCreator(String name) {
		super(name);

	}

	@Override
	public Body create() {
		Body body = new Body(super.getName(), super.generateId());
		// System.out.println("Create body");
		return body;

	}
}
