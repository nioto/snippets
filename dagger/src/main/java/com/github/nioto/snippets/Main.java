package com.github.nioto.snippets;

import javax.inject.Inject;

import dagger.ObjectGraph;


/**
 * Hello world!
 *
 */


public class Main 
{
	@Inject JuiceDrinker jd;
	
	public void drink(){
		jd.drink();
	}
	
    public static void main( String[] args )
    {
    	ObjectGraph objectGraph = ObjectGraph.create(OrangeJuiceModule.class);
    	Main app = objectGraph.get( Main.class );
    	app.drink();
    	objectGraph =  ObjectGraph.create(AppleJuiceModule.class);
    	app = objectGraph.get( Main.class );
    	app.drink();
    }
}
