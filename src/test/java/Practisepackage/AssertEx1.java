package Practisepackage;

import static org.testng.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class AssertEx1 {
	/*
@Test

public void verifyString() {
	System.out.println("testscript-01");
	System.out.println("testscript-02");
	String eString="Soogle";
	String aString="google";
	assertEquals(eString,aString);
	System.out.println("hello");		
	}
	*/
	public static void main(String[]args) {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dt=new Date();
		String getDateandTime = dateformat.format(dt);
		getDateandTime.replace(":", "-");
		System.out.println(getDateandTime);
		
	}
}