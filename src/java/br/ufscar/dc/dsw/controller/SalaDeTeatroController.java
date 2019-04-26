package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.model.SalaDeTeatro;
import br.ufscar.dc.dsw.dao.DAOSalaDeTeatro;
import br.ufscar.dc.dsw.dao.DAOSiteDeVenda;
import br.ufscar.dc.dsw.model.SiteDeVenda;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/sala-de-teatro/*")
public class SalaDeTeatroController extends HttpServlet {

    private DAOSalaDeTeatro dao;

    @Override
    public void init() {
        dao = new DAOSalaDeTeatro();
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
            Logger.getLogger(SalaDeTeatroController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalaDeTeatroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        List<SalaDeTeatro> lista = dao.getAll();
        request.setAttribute("listaTeatros", lista);
        // TODO: Criar templates para SalaDeTeatro
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_sala_de_teatro/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        // TODO: Criar templates para SalaDeTeatro
        if (new AuthController().hasRole(request, "admin")) {
            List<SiteDeVenda> listaSites = new DAOSiteDeVenda().getAll();
            request.setAttribute("listaSites", listaSites);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_sala_de_teatro/cadastro.jsp");
            dispatcher.forward(request, response);
        } else {
        }
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String cnpj = request.getParameter("cnpj");
        String cidade = request.getParameter("cidade");
        String senha = request.getParameter("password");
        String nome = request.getParameter("nome");
        String site_de_venda_email = request.getParameter("site_de_venda_email");
        SalaDeTeatro sala = new SalaDeTeatro(email, senha, cnpj, nome, cidade, site_de_venda_email);
        dao.insert(sala);
        response.sendRedirect("lista");
    }

}
