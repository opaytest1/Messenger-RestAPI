package org.koushik.javabrains.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	 @QueryParam("year") int year;
	 @QueryParam("start") int start;
	 @QueryParam("size") int size;
}
