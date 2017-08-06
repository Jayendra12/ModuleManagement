package org.seed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	Module module = new Module();
	ModuleModel model = new ModuleModel();

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

		String fvname = request.getParameter("updateForm");
		String vname = request.getParameter("viewName");
		System.out.println(fvname + " " + vname);
		/* if (fvname != null||vname!=null) { */

		if (fvname != null) {
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
		if (vname != null) {
			if (vname.equals("viewModule")) {
				List<Module> modules = model.fetchModules();
				request.setAttribute("Modules", modules);
				RequestDispatcher rd = request.getRequestDispatcher("/ViewModule.jsp");
				rd.forward(request, response);

			}
		}
	}
	/* } */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("registerForm");
		if (fname.equals("registerForm")) {
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
	}

}
