package com.example.harta2;
import android.content.Context;


public class MyContext {

	 private static Context myContext= null;
	 
	 
    public static Context getContext() { 
       return myContext;
     }
 
    public static void setContext(Context context) {
    	MyContext.myContext = context;
	 }
}
