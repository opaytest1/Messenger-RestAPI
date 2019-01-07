package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotation(@MatrixParam("param") String matrixParam,
										   @HeaderParam("authSessionId") String authSessionId,
										   @CookieParam("name") String cookie){
		return "Matrix Param is: "+matrixParam + " and Auth Session ID is: "+authSessionId+ " and cookie param value is: "+cookie ;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String absolutePath = uriInfo.getAbsolutePath().toString();
		String baseUri = uriInfo.getBaseUri().toString();
		String path = uriInfo.getPath().toString();
		String queryParams = uriInfo.getQueryParameters().toString();
		
		String cookies = headers.getCookies().toString();
		String className = headers.getClass().toString();
		
		return "Absoute path is: "+absolutePath+
				"\nBase URI is: "+baseUri+
				"\nPath is: "+path+
				"\nQuery parameters are: "+queryParams+
				"\nClass is: "+className+
				"\nCookies are:"+cookies;
				
	}
}
