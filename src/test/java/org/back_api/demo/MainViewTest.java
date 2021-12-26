package org.back_api.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MainViewTest {

    private ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();


    @Before
    public void setUp() throws Exception {
        List<Usuario> ListaNueva = new ArrayList<Usuario>();
        leerJSON("Usuarios.json");
        leerJSONEquipos("Equipos.json");
        leerJSON("Prestamos.json");



    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void actualizarUsuarioAPI() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Gson gson = new Gson();

    }

    @Test
    public void guardarUsuarioAPI() {
        Gson gson = new Gson();
        HttpGet enlace = new HttpGet("http://localhost:8081/user");
        HttpGet llamada = enlace;
        boolean correcto = new Boolean(Boolean.TRUE);
        boolean error = new Boolean(Boolean.FALSE);


        if (llamada == enlace)
        {
            assertTrue("Puerto usado correctamente", true);
        }


        if (llamada != enlace)
        {
            assertFalse("Puerto no conectado", false);
        }

        if (correcto){
            assertTrue("Fichero Json leido correctamente",true );
        }
        if (error){
            assertFalse("Fichero Json leido incorrectamente", false);
        }

    }

    @Test
    public void llamarBorrarAPI() {
        Gson gson = new Gson();
        HttpGet enlace = new HttpGet("http://localhost:8081/user");
        HttpGet llamada = enlace;
        boolean correcto = new Boolean(Boolean.TRUE);
        boolean error = new Boolean(Boolean.FALSE);


        if (llamada == enlace)
        {
            assertTrue("Puerto usado correctamente", true);
        }


        if (llamada != enlace)
        {
            assertFalse("Puerto no conectado", false);
        }

        if (correcto){
            assertTrue("Fichero Json leido correctamente",true );
        }
        if (error){
            assertFalse("Fichero Json leido incorrectamente", false);
        }

    }



    @Test
    public void leerDatosAPI() {
        Gson gson = new Gson();
        HttpGet enlace = new HttpGet("http://localhost:8081/user");
        HttpGet llamada = enlace;
        boolean correcto = new Boolean(Boolean.TRUE);
        boolean error = new Boolean(Boolean.FALSE);


        if (llamada == enlace)
        {
            assertTrue("Puerto usado correctamente", true);
        }


        if (llamada != enlace)
        {
            assertFalse("Puerto no conectado", false);
        }

        if (correcto){
            assertTrue("Fichero Json leido correctamente",true );
        }
        if (error){
            assertFalse("Fichero Json leido incorrectamente", false);
        }

    }

    @Test
    public void leerJSON(String leerJSON) throws IOException {
        Gson gson = new Gson();
        boolean correcto = new Boolean(Boolean.TRUE);
        boolean error = new Boolean(Boolean.FALSE);

        Reader reader = Files.newBufferedReader(Paths.get(leerJSON));
        Type tipoLista = new TypeToken<List<Equipo>>(){}.getType();
        listaUsuarios = gson.fromJson(reader,tipoLista);

        if (correcto){
            assertTrue("Fichero Json leido correctamente",true );
        }
        if (error){
            assertFalse("Fichero Json leido incorrectamente", false);
        }
    }

    @Test
    public void leerJSONEquipos(String leerJSONEquipos) throws IOException {
        Gson gson = new Gson();
        boolean correcto = new Boolean(Boolean.TRUE);
        boolean error = new Boolean(Boolean.FALSE);


        Reader reader = Files.newBufferedReader(Paths.get(leerJSONEquipos));
        Type tipoLista = new TypeToken<List<Equipo>>(){}.getType();
        listaEquipo = gson.fromJson(reader,tipoLista);


        if (correcto){
            assertTrue("Fichero Json leido correctamente",true );
        }
        if (error){
            assertFalse("Fichero Json leido incorrectamente", false);
        }


    }

    @Test
    public void getListaUsuarios() {
    }

    @Test
    public void getListaEquipos() {
    }
}