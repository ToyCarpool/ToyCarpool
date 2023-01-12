package kt.carpool.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterImpl implements Filter {

	private static Logger logger = LoggerFactory.getLogger(CorsFilterImpl.class);

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		logger.info("\n================================================================================="
				+ "\nreqURI : " + request.getMethod() + ") : " + createRequestFullURI(request)
				+ "\n=================================================================================");

		// response.setHeader("Access-Control-Allow-Origin", "*");
		// response.setHeader("Access-Control-Allow-Methods", "POST, GET");
		// response.setHeader("Access-Control-Max-Age", "3600");
		// response.setHeader("Access-Control-Allow-Headers", "x-auth-token,
		// content-type");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

	private String createRequestFullURI(HttpServletRequest request) {
		StringBuffer paramBuffer = new StringBuffer();
		Enumeration enumeration = request.getParameterNames();

		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			if (paramBuffer.length() > 0) {
				paramBuffer.append("&");
			}
			paramBuffer.append(name);
			paramBuffer.append("=");
			paramBuffer.append(request.getParameter(name));
		}

		StringBuffer resultBuffer = new StringBuffer();
		resultBuffer.append(request.getRequestURI());
		if (paramBuffer.length() > 0) {
			resultBuffer.append("?");
			resultBuffer.append(paramBuffer.toString());

		}
		return resultBuffer.toString();
	}

}
