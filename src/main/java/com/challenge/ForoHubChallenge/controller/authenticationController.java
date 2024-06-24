package com.challenge.ForoHubChallenge.controller;

import com.challenge.ForoHubChallenge.domain.Usuario.Usuario;
import com.challenge.ForoHubChallenge.domain.Usuario.datosUsuario;
import com.challenge.ForoHubChallenge.infra.Security.DatosJWTToken;
import com.challenge.ForoHubChallenge.infra.Security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/login")
public class authenticationController {

        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private TokenService tokenService;
        @PostMapping
        public ResponseEntity autenticarUsuario(@RequestBody @Valid datosUsuario datosUsuario){

            Authentication authtoken = new UsernamePasswordAuthenticationToken(datosUsuario.login(), datosUsuario.clave());
            var usuarioAutenticado = authenticationManager.authenticate(authtoken);
            var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
        }
    }
