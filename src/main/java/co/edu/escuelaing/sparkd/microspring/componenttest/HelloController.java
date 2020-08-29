package co.edu.escuelaing.sparkd.microspring.componenttest;

import co.edu.escuelaing.sparkd.microspring.RequestMapping;
public class HelloController {

	@RequestMapping("/hello")
	public static String greetings() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/valorPi")
	public static String getPi() {
		String s = "Pi: " + Math.PI; 
		return s ;
	}

	@RequestMapping("/valorE")
	public static String getE() {
		String s = "Euler: " + Math.E; 
		return s ;
	}

	
}