package org.seed.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seed.bean.Module;
import org.seed.model.ModuleModel;

/**
 * Servlet implementation class ModuleRegisterAndViewServlet
 */
public class ModuleRegisterAndViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModuleRegisterAndViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Module module = new Module();
		ModuleModel model = new ModuleModel();

		String fname = request.getParameter("htmlFormName");
		String fvname = request.getParameter("updateForm");
		if (fname.equals("myForm")) {
			String mcode = request.getParameter("mcode");
			String mname = request.getParameter("mname");
			String hours = request.getParameter("mhours");
			String check = request.getParameter("status");
			module.setModuleCode(mcode);
			module.setModuleName(mname);
			module.setNoOfHours(Integer.parseInt(hours));
			module.setStatus(check);
			model.insertModule(module);
		}
		if (fvname.equals("updateForm")) {
			String mcode = request.getParameter("mcode");
			String mname = request.getParameter("mname");
			String hours = request.getParameter("mhours");
			String check = request.getParameter("status");
			module.setModuleCode(mcode);
			module.setModuleName(mname);
			module.setNoOfHours(Integer.parseInt(hours));
			module.setStatus(check);
			model.updateModule(module);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
