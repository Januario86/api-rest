//package org.fj.minhaapi.rest.filter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.ext.Provider;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//
//@Provider
//public class LogFilter implements ContainerRequestFilter, ContainerResponseFilter {
//	private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);
//
//	private String headers(ContainerRequestContext request) {
//		MultivaluedMap<String, String> headers = request.getHeaders();
//		if (headers != null) {
//			StringBuilder bld = new StringBuilder("PROPERTIES = {");
//			for (String k : headers.keySet()) {
//				bld.append(k).append(":");
//				List<String> vs = headers.get(k);
//				if (vs != null) {
//					for (String v : vs) {
//						bld.append(v);
//					}
//				} else {
//					bld.append("null");
//				}
//				bld.append(",");
//			}
//			bld.append("}");
//			return bld.toString();
//		} else {
//			return "{}";
//		}
//	}
//
//	private String properties(ContainerRequestContext request) {
//		StringBuilder bld = new StringBuilder("HEADERS = {");
//		for (String p : request.getPropertyNames()) {
//			bld.append(p).append(":").append(request.getProperty(p)).append(", ");
//		}
//		bld.append("}");
//		return bld.toString();
//	}
//
//	@Override
//	public void filter(ContainerRequestContext request) {
//		logger.trace("[REQUEST] " + properties(request) + ";" + request.getMethod() + ";" + headers(request) + request.getUriInfo().getPath() + ";" + " "
//				             + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
//	}
//
//	@Override
//	public void filter(ContainerRequestContext request, ContainerResponseContext response) {
//		logger.trace("[RESPONSE]" + properties(request) + ";" + ";" + request.getMethod() + ";" + request.getUriInfo().getPath() + ";" + headers(request) + response.getStatusInfo()
//				             + ";" + " " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
//	}
//
//}
