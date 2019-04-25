/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.DAOTokenLogin;
import br.ufscar.dc.dsw.dao.DAOUsuario;
import br.ufscar.dc.dsw.model.Papel;
import br.ufscar.dc.dsw.model.TokenLogin;
import br.ufscar.dc.dsw.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igor
 */
@WebServlet(urlPatterns = "/auth/")
public class AuthController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        response.setContentType("application/json");
        String username = request.getParameter("username");
        String senha = request.getParameter("password");
        DAOUsuario daoUser = new DAOUsuario();
        Usuario user = null;
        String json;
        try {
            user = daoUser.get(username);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ( user == null ) {
            response.setStatus(422);
            json = "{\"error\": \"username or password incorrect\"}";
            System.out.println(json);
            return;
        }
        if ( !user.getSenha().equals(senha) ) {
            response.setStatus(422);
            json = "{\"error\": \"username or password incorrect\"}";
            System.out.println(json);
            return;
        }
        TokenLogin token = new TokenLogin(user.getEmail()); 
        DAOTokenLogin daoToken = new DAOTokenLogin();
        try {
            daoToken.insert(token);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(500);
            json = "{\"error\": \"an error occurred\"}";
            System.out.println(json);
            return;
        }
        Cookie loginToken = new Cookie("token", token.getToken());
        response.setStatus(200);
        response.addCookie(loginToken);
        json = "{\"success\": \"success\"}";
        System.out.println(json);
    }
    
    public static boolean hasRole(HttpServletRequest request, String role) throws NoSuchAlgorithmException {
        DAOTokenLogin daoToken = new DAOTokenLogin();
        Cookie[] cookies =  request.getCookies();
        int i = 0;
        while (i < cookies.length - 1 && !cookies[i].getName().equalsIgnoreCase("token")) i++;
        if ( !cookies[i].getName().equalsIgnoreCase("token") ) {
            return false;
        }
        TokenLogin token = daoToken.getToken(cookies[i].getValue());
        if ( token == null ) {
            return false;
        }
        Usuario user = token.getUsuario();
        if ( user == null ) {
            return false;
        }
        List<Papel> papeis = user.getPapeis();
        Papel papel = new Papel(role);
        return papeis.contains(papel);
    } 
}
