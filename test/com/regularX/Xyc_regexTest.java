package com.regularX;

import static org.junit.Assert.*;

import org.junit.Test;

public class Xyc_regexTest {

	@Test
	public void testIs19xx() {
		assertTrue(Xyc_regex.is19xx("1923"));
		
		assertFalse(Xyc_regex.is19xx("18  "));
	}
	
	@Test
	public void testIsValidtel() {
//		assertTrue(Xyc_regex.isValidTel("123-12345678"));
//		assertTrue(Xyc_regex.isValidTel("123-0123456"));

//		assertFalse(Xyc_regex.isValidTel("010#12345678"));
//		assertFalse(Xyc_regex.isValidTel("010X12345678"));
		assertFalse(Xyc_regex.isValidTel("01-12345678"));
	}
	
	@Test
	public void testIsValidQQ() {
		assertTrue(Xyc_regex.isValidQQ("99999"));
		assertTrue(Xyc_regex.isValidQQ("1234567890"));
		assertTrue(Xyc_regex.isValidQQ("9999999999"));

		assertFalse(Xyc_regex.isValidQQ("00001"));
		assertFalse(Xyc_regex.isValidQQ("099999"));
	}
}
