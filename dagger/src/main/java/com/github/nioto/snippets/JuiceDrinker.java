package com.github.nioto.snippets;

import javax.inject.Inject;

public class JuiceDrinker {

	@Inject Juice juice;
	@Inject MySingleton SING;
	
	public JuiceDrinker(){
		super();
	}
	
	public void drink(){
		System.out.println( "drinking some " + juice.getFruitName() + " ," + juice.getSome() );
		SING.test() ;
	}
	
}
