package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.model.SalaDeTeatro;
import br.ufscar.dc.dsw.dao.DAOSalaDeTeatro;
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
                    try {
                        if ( !AuthController.canAccess(request, response, "admin") )
                            return;
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                        response.sendRedirect("/projeto1_dsw/500.jsp");
                        return;
                    }
                    insere(request, response);
                    break;
                case "lista":
                    lista(request, response);
                    break;
                case "gerenciar":
                    try {
                        if ( !AuthController.canAccess(request, response, "admin") )
                            return;
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                        response.sendRedirect("/projeto1_dsw/500.jsp");
                        return;
                    }
                    listaGerenciar(request, response);
                    break;
                default:
                    lista(request, response);
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
                    try {
                        if ( !AuthController.canAccess(request, response, "admin") )
                            return;
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                        response.sendRedirect("/projeto1_dsw/500.jsp");
                        return;
                    }
                    apresentaFormCadastro(request, response);
                    break;
                case "gerenciar":
                    try {
                        if ( !AuthController.canAccess(request, response, "admin") )
                            return;
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                        response.sendRedirect("/projeto1_dsw/500.jsp");
                        return;
                    }
                    listaGerenciar(request, response);
                    break;
                case "edicao_form":
                    try {
                        if ( !AuthController.canAccess(request, response, "admin") )
                            return;
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                        response.sendRedirect("/projeto1_dsw/500.jsp");
                        return;
                    }
                    apresentaFormEdicao(request, response);
                    break;
                case "edicao":
                    try {
                        if ( !AuthController.canAccess(request, response, "admin") )
                            return;
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                        response.sendRedirect("/projeto1_dsw/500.jsp");
                        return;
                    }
                    atualize(request, response);
                    break;
                case "remocao":
                    try {
                        if ( !AuthController.canAccess(request, response, "admin") )
                            return;
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                        response.sendRedirect("/projeto1_dsw/500.jsp");
                        return;
                    }
                    remove(request, response);
                    break;
                case "lista":
                    lista(request, response);
                    break;
                default:
                    lista(request, response);
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
            List<SalaDeTeatro> listaSites = new DAOSalaDeTeatro().getAll();
            request.setAttribute("listaTeatros", listaSites);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_sala_de_teatro/cadastro.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/403.jsp");

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

    private void listaGerenciar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        if (new AuthController().hasRole(request, "admin") || new AuthController().hasRole(request, "gerenciar_promocao")) {

            if (request.getParameter("busca") != null) {
                List<SalaDeTeatro> lista = dao.getByName(String.valueOf(request.getParameter("busca")));
                request.setAttribute("lista", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_sala_de_teatro/gerenciar.jsp");
                dispatcher.forward(request, response);
            } else {
                List<SalaDeTeatro> lista = dao.getAll();
                request.setAttribute("listaTeatros", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_sala_de_teatro/gerenciar.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("/403.jsp");
        }
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        SalaDeTeatro teatro = dao.get(request.getParameter("id"));
        request.setAttribute("teatro", teatro);
        request.setAttribute("listaTeatros", new DAOSalaDeTeatro().getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_sala_de_teatro/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        try {
            String email = request.getParameter("email");
            String cnpj = request.getParameter("cnpj");
            String cidade = request.getParameter("cidade");
            String senha = request.getParameter("password");
            String nome = request.getParameter("nome");
            String site_de_venda_email = request.getParameter("site_de_venda_email");
            SalaDeTeatro sala = new SalaDeTeatro(email, senha, cnpj, nome, cidade, site_de_venda_email);
            dao.update(sala);
            response.sendRedirect("listaGerenciar");
            
            }
            catch (Exception e) {
            request.setAttribute("erro", "Erro ao fazer o cadastro! Confira a integridade dos dados.");
            request.setAttribute("listaTeatros", new DAOSalaDeTeatro().getAll());
            request.setAttribute("editar", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_promocao/edicao.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        dao.delete(request.getParameter("cnpj"));
        response.sendRedirect("gerenciar");
    }

}
