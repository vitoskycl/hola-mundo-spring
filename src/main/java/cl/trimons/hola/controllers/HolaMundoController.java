/**
 * 
 */
package cl.trimons.hola.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.trimons.hola.vo.Persona;

/**
 * 
 */
@RestController
public class HolaMundoController {

	@GetMapping("/hola")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hola Mundo!", HttpStatus.OK);
	}
    @GetMapping("/data")
    public ResponseEntity<Object> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> getPersonas() throws ParseException {
    	DateFormat dF = new SimpleDateFormat("yyyy/MM/dd");
    	Persona p1 = new Persona();
    	p1.setId(1);p1.setName("Trini");p1.setFechaNacimiento(dF.parse("2016/02/01"));
    	Persona p2 = new Persona();
    	p2.setId(2);p2.setName("Monse");p2.setFechaNacimiento(dF.parse("2018/02/14"));
     	
    	List<Persona> listado = new ArrayList<Persona>();
    	listado.add(p1);
    	listado.add(p2);
    	return new ResponseEntity<List<Persona>>(listado, HttpStatus.OK);
    }
}
