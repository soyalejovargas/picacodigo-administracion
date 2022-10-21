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

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping
	public ResponseEntity<?> createtoken(@RequestBody Usuario usuarioDetalle){
		List<Usuario> usuario = usuarioService.verificacionUsuario(usuarioDetalle.getPassword(), usuarioDetalle.getUsuario());
		if(usuario!=null && usuario.size()>0) {
			String tokenJwt = jwtUtil.getJWTToken(usuario.get(0).getPassword()+"");
            return ResponseEntity.ok(new JSONObject().put("access", tokenJwt.replace("Bearer ", "")).put("usuario", usuarioService.verificacionUsuario(usuarioDetalle.getPassword(), usuarioDetalle.getUsuario())).toString());
		} 
		return ResponseEntity.notFound().build();
	}
}