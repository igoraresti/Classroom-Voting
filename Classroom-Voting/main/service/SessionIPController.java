package service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class SessionIPController {

	public static String setIP() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}

		return ipAddress;
	}

}
