package ca.simpleweb.mvc.helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlingCookies {

	/**
	 * Remove Cookies
	 */
	public void removeCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue(null);
				cookie.setPath(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		} 
	}

}
