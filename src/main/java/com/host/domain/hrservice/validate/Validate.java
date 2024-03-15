package com.host.domain.hrservice.validate;

public class Validate {
	static boolean isNullOrEmpty(String string) {
	    return string == null || string.trim().isEmpty();
	}
	static boolean isNullOrEmptyObject(Object obj) {
	    return obj == null || obj.equals("");
	}
	public static void main(String[] a) {
		String str1 = null;
		String str2 = "";
		System.out.println(isNullOrEmpty(str1));
		System.out.println(isNullOrEmpty(""));
		System.out.println(isNullOrEmpty(str2));
		
	}
}
