package com.picacodigo.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picacodigo.model.Usuario;
import com.picacodigo.service.UsuarioService;
import com.picacodigo.util.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    //@Autowired
    //private PersonaService personaService;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtil jwtUtil;
    
    /***@PostMapping
	public ResponseEntity<?> createtoken(@RequestBody Persona personaDetalle){
		List<Persona> persona = personaService.findAdminById(personaDetalle.getIdpersona());
		if(persona!=null && persona.size()>0) {
			String tokenJwt = jwtUtil.getJWTToken(persona.get(0).getIdpersona()+"");
            return ResponseEntity.ok(new JSONObject().put("access", tokenJwt.replace("Bearer ", "")).toString());
		} 
		return ResponseEntity.notFound().build();
	}***/
    @PostMapping
    public ResponseEntity<?> createtoken(@RequestBody Usuario usuarioDetalle){
		List<Usuario> usuario = usuarioService.findAdminById(usuarioDetalle.getIdusuario());
		if(usuario!=null && usuario.size()>0) {
			String tokenJwt = jwtUtil.getJWTToken(usuario.get(0).getIdusuario()+"");
            return ResponseEntity.ok(new JSONObject().put("access", tokenJwt.replace("Bearer ", "")).toString());
		} 
		return ResponseEntity.notFound().build();
	}
}