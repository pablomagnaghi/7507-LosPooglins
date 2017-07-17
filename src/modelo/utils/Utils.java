package modelo.utils;

import java.util.Collection;

public class Utils {
	
	private Utils(){}
	
	public static <T> T OR(T... params){
		for (T param : params){
			if (! isNull(param))
				return param; 
		}
		return params.length > 0  ? params[params.length-1] : null;
	}
	
	public static <T> T AND(T... params){
		for (T param : params){
			if (isNull(param))
				return param; 
		}
		return params.length > 0  ? params[params.length-1] : null;
	}
	
	private static boolean isNull(Object param){
		if (param == null) return true;
		
		if (param instanceof Collection<?>)
			return ((Collection<?>) param).isEmpty();
		if (param instanceof String)
			return "".equals(((String)param).trim());
		if (param instanceof Boolean)
			return (Boolean)param;
		
		return false;
	}

	public static boolean equal(Number n1, Number n2, Integer rounding){
		double d1 = n1.doubleValue();
		double d2 = n2.doubleValue();
		return Math.abs(d1 - d2) <= (rounding == null ? 0 : Math.pow(10, -1 * rounding)); 
	}
	
	public static boolean equal(Number n1, Number n2){
		return equal(n1, n2, null); 
	}
	
	public static void sleep(Long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e){}
	}

}
