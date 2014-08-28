package com.github.nioto.snippets;

import javax.inject.Singleton;

@Singleton
public class MySingleton {

	public MySingleton() {
		System.out.println( "Creating sngleton");
	}
	
	public void test(){
		System.out.println( "test");
	}
}
