package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class ApiApplicationTests {

	   private static ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();
	   private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	   private static ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();


	    @Before
	    public void setUp() throws Exception {
	        leerJSON("Usuario.json");
	        leerJSON("Equipo.json");
	        leerJSON("Prestamo.json");
	    }

	    @Test
	    public void leerUsuariosAPI() {
	    	
	        try{
        		setUp();	
	            CloseableHttpClient httpClient = HttpClients.createDefault();
	            HttpGet request = new HttpGet("https://ainalua.herokuapp.com/user");


	            try (CloseableHttpResponse response = httpClient.execute(request)) {

	                // Get HttpResponse Status
	                System.out.println(response.getStatusLine().toString());

	                HttpEntity entity = response.getEntity();
	                Header headers = entity.getContentType();
	                System.out.println(headers);

	                if (entity != null) {
	                    // return it as a String
	                    String result = EntityUtils.toString(entity);
	                    System.out.println(result);

	                    Gson gson = new Gson();
	                    Type tipoLista = new TypeToken<List<Usuario>>() {}.getType();
	                    ArrayList<Usuario> aux = gson.fromJson(result, tipoLista);

	                    System.out.println(aux.size()+"-----"+ listaUsuarios.size());
	                    //chequear que los usuarios de aux son los mismos de listaUsuarios
	                    assertTrue(aux.size() == listaUsuarios.size(),"Lista de usuarios correcta");



	                }
	            }catch (Exception e){

	            }
	        }catch (Exception e){

	        }
	    }


	    @Test
	    public void leerPrestamosAPI() {
	        try{
	        	setUp();
	            CloseableHttpClient httpClient = HttpClients.createDefault();
	            HttpGet request = new HttpGet("https://ainalua.herokuapp.com/prestamo");


	            try (CloseableHttpResponse response = httpClient.execute(request)) {

	                // Get HttpResponse Status
	                System.out.println(response.getStatusLine().toString());

	                HttpEntity entity = response.getEntity();
	                Header headers = entity.getContentType();
	                System.out.println(headers);

	                if (entity != null) {
	                    // return it as a String
	                    String result = EntityUtils.toString(entity);
	                    System.out.println(result);

	                    Gson gson = new Gson();
	                    Type tipoLista = new TypeToken<List<Prestamo>>() {}.getType();
	                    ArrayList<Prestamo> aux = gson.fromJson(result, tipoLista);

	                    System.out.println(aux.size()+"-----"+ listaPrestamos.size());
	                    //chequear que los usuarios de aux son los mismos de listaUsuarios
	                    assertTrue( aux.size() == listaPrestamos.size(),"Lista de prestamos correcta");
	                }
	            }catch (Exception e){

	            }
	        }catch (Exception e){

	        }
	    }

	    @Test
	    public void leerEquipoAPI() {
	    	
	        try{
	        	setUp();
	            CloseableHttpClient httpClient = HttpClients.createDefault();
	            HttpGet request = new HttpGet("https://ainalua.herokuapp.com/equipo");


	            try (CloseableHttpResponse response = httpClient.execute(request)) {

	                // Get HttpResponse Status
	                System.out.println(response.getStatusLine().toString());

	                HttpEntity entity = response.getEntity();
	                Header headers = entity.getContentType();
	                System.out.println(headers);

	                if (entity != null) {
	                    // return it as a String
	                    String result = EntityUtils.toString(entity);
	                    System.out.println(result);

	                    Gson gson = new Gson();
	                    Type tipoLista = new TypeToken<List<Equipo>>() {}.getType();
	                    ArrayList<Equipo> aux = gson.fromJson(result, tipoLista);

	                    System.out.println(aux.size()+"-----"+ listaEquipo.size());
	                    //chequear que los usuarios de aux son los mismos de listaUsuarios
	                    assertTrue(aux.size() == listaEquipo.size(),"Lista de Equipo correcta");
	                }
	            }catch (Exception e){

	            }
	        }catch (Exception e){

	        }
	    }


	   /* @Test
	    public void guardarUsuarioAPI(){
	    	try {
				setUp();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	        Usuario u = new Usuario(77,"pepe","midep","124","aaa@gmail.com","madrid");
	        listaUsuarios.add(u);

	        //guardo en remoto
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        HttpPost request = new HttpPost("https://ainalua.herokuapp.com/user");
	        request.setHeader("Content-Type", "application/json");

	        Gson gson = new Gson();
	        try{
	            HttpEntity entity = new ByteArrayEntity(gson.toJson(u).getBytes("UTF-8"));
	            request.setEntity(entity);

	            CloseableHttpResponse response = httpClient.execute(request);

	            // Get HttpResponse Status
	            System.out.println(response.getStatusLine().toString());

	            entity = response.getEntity();
	            Header headers = entity.getContentType();
	            System.out.println(headers);

	            if (entity != null) {
	                // return it as a String
	                String result = EntityUtils.toString(entity);
	                System.out.println(result);

	                Type tipoLista = new TypeToken<List<Usuario>>(){}.getType();
	                //listaPersonajes = gson.fromJson(result, tipoLista);
	            }

	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        leerUsuariosAPI();
	    }*/


	    private static void leerJSON(String leerJSON) {
	        try {
	        	// create Gson instance
	            Gson gson = new Gson();

	            // create a reader
	            Reader reader = Files.newBufferedReader(Paths.get(leerJSON));

	            // convert JSON file to map
	            //Videoteca v = gson.fromJson(reader, Videoteca.class);
	            Type tipoLista = new TypeToken<List<Usuario>>(){}.getType();
	            if(leerJSON.equals("Usuario.json") && listaUsuarios.size() == 0){
	                listaUsuarios = gson.fromJson(reader, tipoLista);
	                System.out.println(listaUsuarios);
	            }else if(leerJSON.equals("Prestamo.json")  && listaPrestamos.size() == 0){
	                listaPrestamos = gson.fromJson(reader, tipoLista);
	                System.out.println(listaPrestamos);
	            }else if(leerJSON.equals("Equipo.json")  && listaEquipo.size() == 0){
	                listaEquipo = gson.fromJson(reader, tipoLista);
	                System.out.println(listaEquipo);
	            }




	            // close reader
	            reader.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

}
