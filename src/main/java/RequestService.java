import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/* Para el ejemplo se usara el siguiente recurso
*  https://www.googleapis.com/books/v1/volumes/?q=isbn:9706434526&fields=totalItems,items(id,volumeInfo(title,publishedDate))
* */

class Alumno
{
	String code;
	String first_name;
	String last_name;
	String github_user;
	
	
	Alumno()
	{
		code = "123";
		first_name = "probando";
		last_name = "jersey";
		github_user = "wiii";
	}
}

public class RequestService {
	private Client alumno;
	private static final String URL_NOTITAS = "http://notitas.herokuapp.com";
	private static final String RESOURCE_DATOS_ALUMNOS = "student";
	private static final String Token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	

	public RequestService()
	{
		this.alumno = Client.create();
		
	}
	
	public ClientResponse getDatosAlumno()
	{
		WebResource recurso = this.alumno.resource(URL_NOTITAS).path(RESOURCE_DATOS_ALUMNOS);
		WebResource.Builder builder = recurso.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + Token);
		ClientResponse response = builder.get(ClientResponse.class);
		return response;
	}
	
	

	public void PostDatosAlumno(String a)
	{
		WebResource recurso = this.alumno.resource(URL_NOTITAS).path(RESOURCE_DATOS_ALUMNOS);
		WebResource.Builder builder = recurso.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + Token);
		ClientResponse response = builder.put(ClientResponse.class, a);
	}
	
	/*
    private Client client;
    private static final String API_GOOGLE = "https://www.googleapis.com/books/v1";
    private static final String RESOURCE = "volumes";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
        //En la documentacion se puede ver como al cliente agregarle un ClientConfig
        //para agregarle filtros en las respuestas (por ejemplo, para loguear).
    }

    //Prueba de concepto de un parametro y los mensajes por separado para identificar los tipos de datos.
    public ClientResponse getBookByFilter(String filter, String value){
        WebResource recurso = this.client.resource(API_GOOGLE).path(RESOURCE);
        WebResource recursoConParametros = recurso.queryParam("q",filter + ":" + value);
        WebResource.Builder builder = recursoConParametros.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        return response;
    }

    //Prueba de concepto de envio de dos parametros, y el envio de mensajes juntos.
    public ClientResponse getBookByFilter(String filter, String value, String fields){
        ClientResponse response = this.client.resource(API_GOOGLE).path(RESOURCE)
                .queryParam("q",filter + ":" + value).queryParam("fields",fields)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        return response;
    }

    //Prueba de concepto del envio de un request con un header.
    public ClientResponse getBookAndSendHeader(String filter, String value, String header, String headerValue){
        ClientResponse response = this.client.resource(API_GOOGLE).path(RESOURCE)
                .queryParam("q",filter + ":" + value).header(header, headerValue)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        return response;
    }
    
    */
}
