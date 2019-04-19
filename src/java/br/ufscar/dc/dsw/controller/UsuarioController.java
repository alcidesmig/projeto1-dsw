package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.model.Usuario;
import br.ufscar.dc.dsw.dao.DAOUsuario;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/usuario/*")
public class UsuarioController extends HttpServlet {

    private DAOUsuario dao;

    @Override
    public void init() {
        dao = new DAOUsuario();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getRequestURI();
        action = action.split("/")[action.split("/").length - 1];
        try {
            switch (action) {
                case "cadastro":
                    insere(request, response);
                    break;
                default:
                    apresentaFormCadastro(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getRequestURI();
        action = action.split("/")[action.split("/").length - 1];
        try {
            switch (action) {
                case "cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "lista":
                    lista(request, response);
                    break;
                default:
                    apresentaFormCadastro(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        List<Usuario> lista = dao.getAll();
        request.setAttribute("listaUsuario", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_usuario/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_usuario/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        request.setCharacterEncoding("UTF-8");
        String nickname = request.getParameter("usuario_id");
        String nome = request.getParameter("name");
        int papel_id = 0;
        String senha = request.getParameter("password");
        Usuario user = new Usuario(nickname, nome, papel_id, senha, new Date(System.currentTimeMillis()));
        dao.insert(user);
        System.out.println("Inserido.");
        response.sendRedirect("lista");
    }

}
