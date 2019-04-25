package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.DAOPromocao;
import br.ufscar.dc.dsw.dao.DAOSalaDeTeatro;
import br.ufscar.dc.dsw.model.Promocao;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/promocao/*")
public class PromocaoController extends HttpServlet {

    private DAOPromocao dao;

    @Override
    public void init() {
        dao = new DAOPromocao();
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
                case "lista":
                    lista(request, response);
                    break;
                case "gerenciar":
                    listaGerenciar(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PromocaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PromocaoController.class.getName()).log(Level.SEVERE, null, ex);
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
                case "gerenciar":
                    listaGerenciar(request, response);
                    break;
                case "edicao_form":
                    apresentaFormEdicao(request, response);
                    break;
                case "edicao":
                    atualize(request, response);
                    break;
                case "remocao":
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
            Logger.getLogger(PromocaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        if (request.getMethod().equals("POST")) {
            List<Promocao> lista = dao.getByCnpjTeatro(request.getParameter("busca"));
            request.setAttribute("listaPromocao", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_promocao/lista.jsp");
            dispatcher.forward(request, response);

        } else {
            List<Promocao> lista = dao.getAll();
            request.setAttribute("listaPromocao", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_promocao/lista.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void listaGerenciar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        if (request.getParameter("busca") != null) {
            List<Promocao> lista = dao.getByName(String.valueOf(request.getParameter("busca")));
            request.setAttribute("listaPromocao", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_promocao/gerenciar.jsp");
            dispatcher.forward(request, response);
        } else {
            List<Promocao> lista = dao.getAll();
            request.setAttribute("listaPromocao", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_promocao/gerenciar.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listaSalas", new DAOSalaDeTeatro().getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_promocao/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Promocao prom = dao.get(id);
        request.setAttribute("prom", prom);
        request.setAttribute("listaSalas", new DAOSalaDeTeatro().getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/templates_promocao/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException, ParseException {
        request.setCharacterEncoding("UTF-8");

        String endereco_url = request.getParameter("endereco_url");
        String nome_peca = request.getParameter("nome_peca");
        String datetime = request.getParameter("datetime");
        double preco = Double.valueOf(request.getParameter("preco"));
        String cnpj = request.getParameter("cnpj_teatro");
        String cnpj_teatro = cnpj;
        Promocao promocao = new Promocao(preco, datetime, endereco_url, cnpj_teatro, nome_peca);

        dao.insert(promocao);

        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String endereco_url = request.getParameter("endereco_url");
        String nome_peca = request.getParameter("nome_peca");
        String datetime = String.valueOf(request.getParameter("datetime"));
        int id_promocao = Integer.valueOf(request.getParameter("id_promocao"));
        double preco = Double.valueOf(request.getParameter("preco"));
        String cnpj_teatro = (request.getParameter("cnp_teatro"));

        Promocao promocao = new Promocao(id_promocao, preco, datetime, endereco_url, cnpj_teatro, nome_peca);

        dao.update(promocao);
        response.sendRedirect("listaGerenciar");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Promocao p = new Promocao(id);
        dao.delete(p);
        response.sendRedirect("gerenciar");
    }

}
