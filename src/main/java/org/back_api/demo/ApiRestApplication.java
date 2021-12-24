package org.back_api.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
@RestController
public class ApiRestApplication {

    private static ArrayList<Usuario> mListaUsuarios = new ArrayList<Usuario>();
    private static ArrayList<Prestamo> mListaPrestamos = new ArrayList<Prestamo>();
    private static ArrayList<Equipo> mListaEquipos = new ArrayList<Equipo>();

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);

        leerJSON("usuarios.json");
        leerJSONEquipo("equipos.json");
        leerJSONPrestamo("prestamos.json");

    }



    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        Gson gson = new Gson();
        for (int i = 0; i < mListaUsuarios.size(); i++) {
            if(mListaUsuarios.get(i).getId() == id){
                return gson.toJson(mListaUsuarios.get(i));
            }
        }
        return null;
    }

    @GetMapping("/user")
    public String getUsers(){
        Gson gson = new Gson();
        return gson.toJson(mListaUsuarios);
    }

    @GetMapping("/prestamo")
    public String getPrestamo(){
        Gson gson = new Gson();
        return gson.toJson(mListaPrestamos);
    }
    @GetMapping("/equipo")
    public String getEquipo(){
        Gson gson = new Gson();
        return gson.toJson(mListaEquipos);
    }

    @PostMapping("/user")
    public String saveUser(@RequestBody Usuario user){
        Gson gson = new Gson();
        if(user != null){
            mListaUsuarios.add(user);

            guardarJSON();

            return gson.toJson(mListaUsuarios);
        }
        return gson.toJson(mListaUsuarios);
    }

    @PostMapping("/prestamo")
    public String savePrestamo(@RequestBody Prestamo prestamo){
        Gson gson = new Gson();
        if(prestamo != null){
            mListaPrestamos.add(prestamo);

            guardarJSONPrestamos();

            return gson.toJson(mListaPrestamos);
        }
        return gson.toJson(mListaPrestamos);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody Usuario user){
        Gson gson = new Gson();
        if(user != null){
            for (int i = 0; i < mListaUsuarios.size(); i++) {
                if(user.getId() == mListaUsuarios.get(i).getId()){
                    mListaUsuarios.set(i,user);

                    guardarJSON();

                    return gson.toJson(mListaUsuarios);
                }
            }
        }
        return gson.toJson(mListaUsuarios);
    }

    @PutMapping("/prestamo")
    public String updatePrestamo(@RequestBody Prestamo prestamo){
        Gson gson = new Gson();
        if(prestamo != null){
            for (int i = 0; i < mListaPrestamos.size(); i++) {
                if(prestamo.getId() == mListaPrestamos.get(i).getId()){
                    mListaPrestamos.set(i,prestamo);

                    guardarJSONPrestamos();

                    return gson.toJson(mListaPrestamos);
                }
            }
        }
        return gson.toJson(mListaPrestamos);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        Gson gson = new Gson();
        for (int i = 0; i < mListaUsuarios.size(); i++) {
            if(id == mListaUsuarios.get(i).getId()){
                mListaUsuarios.remove(i);

                guardarJSON();

                return gson.toJson(mListaUsuarios);
            }
        }
        return gson.toJson(mListaUsuarios);
    }

    private static void guardarJSON(){
        try {
            Gson gson = new Gson();
            FileWriter fw = new FileWriter("usuarios.json");
            gson.toJson(mListaUsuarios,fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerJSON(String leerJSON) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(leerJSON));

            // convert JSON file to map
            //Videoteca v = gson.fromJson(reader, Videoteca.class);
            Type tipoLista = new TypeToken<List<Usuario>>(){}.getType();
            mListaUsuarios = gson.fromJson(reader, tipoLista);
            System.out.println(mListaUsuarios);


            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void guardarJSONPrestamos(){
        try {
            Gson gson = new Gson();
            FileWriter fw = new FileWriter("prestamos.json");
            gson.toJson(mListaPrestamos,fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerJSONPrestamo(String leerJSON) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(leerJSON));

            // convert JSON file to map
            //Videoteca v = gson.fromJson(reader, Videoteca.class);
            Type tipoLista = new TypeToken<List<Prestamo>>(){}.getType();
            mListaPrestamos = gson.fromJson(reader, tipoLista);
            System.out.println(mListaPrestamos);


            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static void leerJSONEquipo(String leerJSON) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(leerJSON));

            // convert JSON file to map
            //Videoteca v = gson.fromJson(reader, Videoteca.class);
            Type tipoLista = new TypeToken<List<Equipo>>(){}.getType();
            mListaEquipos = gson.fromJson(reader, tipoLista);
            System.out.println(mListaEquipos);


            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
