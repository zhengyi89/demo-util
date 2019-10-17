package com.demo.regex;

import java.util.regex.Pattern;

import org.junit.Test;

public class TestDate {
	@Test
	public void Testregexp() {
		Pattern p = Pattern
				.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?"
						+ "[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))"
						+ "|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|"
						+ "(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12"
						+ "35679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))"
						+ "[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))"
						+ "[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?["
						+ "1-9])|(1[0-9])|(2[0-8]))))))");

		String s = "2003-02-20";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004/02/29";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004/04/31";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004/04/30";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004/04/30";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004/09/30";
		System.out.println(s + " " + p.matcher(s).matches());

	}

	@Test
	public void Testexp() {

		Pattern p = Pattern
				.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");

		String s = "2003-02-29 23:59:59";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004-02-29 23:59:59";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004-04-31 0:59:59";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004-04-30 01:11:0";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004-04-30 0:0:0";
		System.out.println(s + " " + p.matcher(s).matches());

		s = "2004-04-30 00:00:59";
		System.out.println(s + " " + p.matcher(s).matches());
	}
}
