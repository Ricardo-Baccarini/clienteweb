package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MailcapCommandMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.service.ClienteService;

@WebServlet(urlPatterns = { "/cliente", "/clienteServlet", "/clienteController" }) // Mapeado 3 formas de URL
public class ClienteServlet extends HttpServlet {

	ClienteService clienteservice;

	public ClienteServlet() {
		System.out.println("Construindo o Servlet");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		clienteservice = new ClienteService();
		System.out.println("Iniciando Servlet....");
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("chamando o service....");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String i = req.getParameter("i");
		if ((i != null && i != "")) {
			clienteservice.excluir(Integer.parseInt(i));
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", clienteservice.getTodosClientes()); // Atribui ao requeste o objeto lista setando como
																		// nome "lista"
		dispatcher.forward(req, resp); // Encaminha para tela do do cliente
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Chamou pelo método POST");

		// Recebe o email
		resp.setCharacterEncoding("UTF-8");
		String email = req.getParameter("e-mail");

		// Instancia o cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);

		// Adiciona o cliente em uma lista
		clienteservice.cadastrar(cli);

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso");
		req.setAttribute("lista", clienteservice.getTodosClientes()); // Atribui ao requeste o objeto lista setando como
																		// nome "lista"
		dispatcher.forward(req, resp); // Encaminha para tela do do cliente

		// resp.sendRedirect("cliente"); // Refaz requisição para o Servidor

		// resp.setCharacterEncoding("UTF-8");
		// resp.getWriter().print("Chamou pelo método POST - E-mail " + email + "!");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Chamou pelo método POST");

		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método DELETE");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Chamou pelo método POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método PUT");
	}

	@Override
	public void destroy() {
		System.out.println("Passando pelo destroy....");
		super.destroy();
	}
}
