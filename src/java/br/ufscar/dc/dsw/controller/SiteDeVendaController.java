package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.model.SiteDeVenda;
import br.ufscar.dc.dsw.dao.DAOSiteDeVenda;
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

@WebServlet(urlPatterns = "/site-de-venda/*")
public class SiteDeVendaController extends HttpServlet {

    private DAOSiteDeVenda dao;

    @Override
    public void init() {
        dao = new DAOSiteDeVenda();
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
            Logger.getLogger(SiteDeVendaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SiteDeVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        List<SiteDeVenda> lista = dao.getAll();
        request.setAttribute("listaUsuario", lista);
        // TODO: Criar templates para SiteDeVenda
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_usuario/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: Criar templates para SiteDeVenda
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_usuario/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String url = request.getParameter("url");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("password");
        String nome = request.getParameter("nome");
        SiteDeVenda sala = new SiteDeVenda(email, senha, url, nome, telefone);
        dao.insert(sala);
        System.out.println("Inserido.");
        response.sendRedirect("lista");
    }

}
