package clienteweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/cliente", "/clienteServlet", "/clienteController"}) // Mapeado 3 formas de URL	
public class ClienteServlet extends HttpServlet {
	
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
		System.out.println("Chamou pelo método GET");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Chamou pelo método POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método POST");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Chamou pelo método POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método DELETE");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Chamou pelo método POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método PUT");
	}
	
	@Override
	public void destroy() {
		System.out.println("Passando pelo destroy....");
		super.destroy();
	}
}
