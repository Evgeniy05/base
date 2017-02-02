package com.exmaples.factory;

public class EngineCreator extends ItemCreator<Engine> {
	private String name;

	public EngineCreator(String name) {
		super(name);

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Engine create() {
		Engine engine = new Engine(super.getName(), super.generateId());
		return engine;
	}
}
