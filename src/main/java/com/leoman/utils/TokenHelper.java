package com.leoman.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TokenHelper {

	private static Log LOG = LogFactory.getLog(TokenHelper.class);

	public static String TOKEN_KEY = "koala.token";

	public static String TOKEN_SESSION_KEY = "koala.token.key";

	/**
	 * 楠岃瘉璇乼oken
	 * 
	 * @param request
	 * @return
	 */
	public static boolean validToken(HttpServletRequest request) {
		HttpSession session = request.getSession();
		synchronized (session) {
			String token = getTokenValue(request);
			if (token == null) {
				if (LOG.isDebugEnabled()) {
					LOG.debug("no token found in " + request.getRequestURI());
				}
				return true;
			}
			List<String> tokens = getTokens(session);
			if (tokens.contains(token)) {
				removeToken(session, token);
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 鎶妕oken娣诲姞鍒� session涓�
	 * 
	 * @param session
	 * @param token
	 */
	public static void addToken(HttpSession session, String token) {
		@SuppressWarnings("unchecked")
		List<String> tokens = (List<String>) session.getAttribute(TOKEN_SESSION_KEY);
		if (tokens == null) {
			tokens = new ArrayList<String>();
		} else if (tokens.size() > 100) {
			tokens = tokens.subList(0, 100);
		}
		tokens.add(token);
		session.setAttribute(TOKEN_SESSION_KEY, tokens);
	}

	/**
	 * 鐢熸垚token骞舵坊鍔犲埌 session涓�
	 * 
	 * @param session
	 * @return
	 */
	public static String generateAndAddToken(HttpSession session) {
		String token = generateToken();
		addToken(session, token);
		return token;
	}

	/**
	 * 鐢熸垚token
	 * 
	 * @return
	 */
	public static String generateToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 鑾峰緱璇锋眰涓殑token
	 * 
	 * @param request
	 * @return
	 */
	private static String getTokenValue(HttpServletRequest request) {
		return request.getParameter(TOKEN_KEY);
	}

	/**
	 * 绉婚櫎Token
	 * 
	 * @param token
	 */
	private static void removeToken(HttpSession session, String token) {
		@SuppressWarnings("unchecked")
		List<String> tokens = (List<String>) session.getAttribute(TOKEN_SESSION_KEY);
		if (tokens != null && !tokens.isEmpty()) {
			session.setAttribute(TOKEN_SESSION_KEY, tokens);
		}
	}

	private static List<String> getTokens(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> tokens = (List<String>) session.getAttribute(TOKEN_SESSION_KEY);
		if (tokens == null) {
			tokens = new ArrayList<String>();
			session.setAttribute(TOKEN_SESSION_KEY, tokens);
		}
		return tokens;
	}
}
