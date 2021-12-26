package org.back_api.demo;

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
import org.back_api.demo.Equipo;
import org.back_api.demo.Prestamo;
import org.back_api.demo.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainViewTest{


    private ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();


    @Before
    public void setUp() throws Exception {
        List<Usuario> ListaNueva = new ArrayList<Usuario>();
        leerJSON("usuario.json");
        leerJSON("equipo.json");
        leerJSON("prestamo.json");
    }

    @Test
    public void leerUsuariosAPI() {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("http://localhost:8081/user");


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

                    //chequear que los usuarios de aux son los mismos de listaUsuarios
                    assertTrue("Lista de usuarios correcta", aux.size() == listaUsuarios.size());



                }
            }catch (Exception e){

            }
        }catch (Exception e){

        }
    }


    @Test
    public void leerPrestamosAPI() {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("http://localhost:8081/prestamo");


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

                    //chequear que los usuarios de aux son los mismos de listaUsuarios
                    assertTrue("Lista de usuarios correcta", aux.size() == listaPrestamos.size());
                }
            }catch (Exception e){

            }
        }catch (Exception e){

        }
    }

    @Test
    public void leerEquipoAPI() {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("http://localhost:8081/equipo");


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

                    //chequear que los usuarios de aux son los mismos de listaUsuarios
                    assertTrue("Lista de Equipo correcta", aux.size() == listaEquipo.size());
                }
            }catch (Exception e){

            }
        }catch (Exception e){

        }
    }


    @Test
    public void guardarUsuarioAPI(){
        Usuario u = new Usuario(77,"pepe","midep","124","aaa@gmail.com","madrid");
        listaUsuarios.add(u);

        //guardo en remoto
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost("http://localhost:8081/user");
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
    }


    private void leerJSON(String leerJSON) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(leerJSON));

            // convert JSON file to map
            //Videoteca v = gson.fromJson(reader, Videoteca.class);
            Type tipoLista = new TypeToken<List<Usuario>>(){}.getType();
            if(leerJSON.equals("usuario.json")){
                listaUsuarios = gson.fromJson(reader, tipoLista);
                System.out.println(listaUsuarios);
            }else if(leerJSON.equals("prestamo.json")){
                listaPrestamos = gson.fromJson(reader, tipoLista);
                System.out.println(listaPrestamos);
            }else if(leerJSON.equals("equipo.json")){
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
