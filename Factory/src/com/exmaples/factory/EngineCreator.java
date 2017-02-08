package com.exmaples.factory;

public class EngineCreator extends ItemCreator<Engine> {

	public EngineCreator(String name) {
		super(name);

	}

	@Override
	public Engine create() {
		Engine engine = new Engine(super.getName(), super.generateId());
		return engine;
	}
}
