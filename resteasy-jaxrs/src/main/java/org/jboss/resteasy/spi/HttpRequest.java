package org.jboss.resteasy.spi;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.io.InputStream;

/**
 * Bridge interface between the base Resteasy JAX-RS implementation and the actual HTTP transport (i.e. a servlet container)
 *
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public interface HttpRequest
{
   HttpHeaders getHttpHeaders();

   InputStream getInputStream();

   UriInfo getUri();

   String getHttpMethod();

   /**
    * Encoded preprocessed path with extension mappings and matrix parameters removed
    *
    * @return
    */
   String getPreprocessedPath();

   public void setPreprocessedPath(String path);

   /**
    * application/x-www-form-urlencoded parameters
    * <p/>
    * This is here because @FormParam needs it.
    *
    * @return null if no parameters, this is encoded map
    */
   MultivaluedMap<String, String> getFormParameters();

   MultivaluedMap<String, String> getDecodedFormParameters();


   /**
    * Asynchronous HTTP support.  Mirrors Servlet 3.0 API
    */
   public void suspend();

   /**
    * Asynchronous HTTP support.  Mirrors Servlet 3.0 API
    */
   public void suspend(long timeout);

   /**
    * Asynchronous HTTP support.  Mirrors Servlet 3.0 API
    */
   public void complete();

   /**
    * Asynchronous HTTP support.  Mirrors Servlet 3.0 API
    */
   public boolean isInitial();

   /**
    * Asynchronous HTTP support.  Mirrors Servlet 3.0 API
    */
   public boolean isSuspended();

   /**
    * Asynchronous HTTP support.  Mirrors Servlet 3.0 API
    */
   public boolean isTimeout();


}