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

@WebServlet(urlPatterns = { "/cliente", "/clienteServlet", "/clienteController" }) // Mapeado 3 formas de URL
public class ClienteServlet extends HttpServlet {

	List<Cliente> lista = new ArrayList();

	public ClienteServlet() {
		System.out.println("Construindo o Servlet");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
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

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");

		req.setAttribute("lista", lista); // Atribui ao requeste o objeto lista setando como nome "lista"
		dispatcher.forward(req, resp); // Encaminha para tela do do cliente

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Chamou pelo m�todo POST");

		// Recebe o email
		resp.setCharacterEncoding("UTF-8");
		String email = req.getParameter("e-mail");

		// Instancia o cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);

		// Adiciona o cliente em uma lista
		lista.add(cli);

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso");
		req.setAttribute("lista", lista); // Atribui ao requeste o objeto lista setando como nome "lista"
		dispatcher.forward(req, resp); // Encaminha para tela do do cliente
		
		//resp.sendRedirect("cliente"); // Refaz requisi��o para o Servidor
		
		// resp.setCharacterEncoding("UTF-8");
		// resp.getWriter().print("Chamou pelo m�todo POST - E-mail " + email + "!");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Chamou pelo m�todo POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo m�todo DELETE");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Chamou pelo m�todo POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo m�todo PUT");
	}

	@Override
	public void destroy() {
		System.out.println("Passando pelo destroy....");
		super.destroy();
	}
}
