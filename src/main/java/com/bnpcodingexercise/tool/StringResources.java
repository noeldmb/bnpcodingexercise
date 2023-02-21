package com.bnpcodingexercise.tool;

import java.util.Deque;
import java.util.LinkedList;

import com.bnpcodingexercise.dto.ParamValidateStringDto;

public class StringResources {

	public static String VALID = "valid";
	public static String NOT_VALID = "not-valid";
	public static String NOT_VALID_PARAMS = "Neither the string, nor the username, nor the symbols can be null or empty";

	private static String symbolsAllowed = "{}[]()";

	public static boolean validBraketsInString(ParamValidateStringDto params) {
		char openBraket = params.getBracketSymbols().getOpen().charAt(0);
		char closeBraket = params.getBracketSymbols().getClose().charAt(0);
		
		String sOpenBracket = params.getBracketSymbols().getOpen();
		String sCloseBracket = params.getBracketSymbols().getClose();
		
		String symbols = params.getBracketSymbols().getOpen().concat(params.getBracketSymbols().getClose());
		Deque<Character> deque = new LinkedList<>();

		if (symbolsAllowed.contains(symbols) && (params.getString().contains(sOpenBracket) || (params.getString().contains(sCloseBracket)))) {
			for (char ch : params.getString().toCharArray()) {
				if (ch == openBraket || ch == closeBraket) {
					if (ch == openBraket) {
						deque.addFirst(ch);
					} else {
						if (!deque.isEmpty() && ((deque.peekFirst() == openBraket && ch == closeBraket))) {
							deque.removeFirst();
						} else {
							return false;
						}
					}
				}
			}
		} else {
			return false;
		}

		return deque.isEmpty();
	}
	
	public static boolean checkParams(ParamValidateStringDto params) {
		boolean resp = true;
		String openBracket = params.getBracketSymbols().getOpen();
		String closeBracket = params.getBracketSymbols().getClose();

		if (openBracket == null || openBracket.isEmpty() || closeBracket == null || closeBracket.isEmpty()
				|| params.getString() == null || params.getString().isEmpty() || params.getUsername() == null
				|| params.getUsername().isEmpty())
			resp = false;

		return resp;
	}
}
