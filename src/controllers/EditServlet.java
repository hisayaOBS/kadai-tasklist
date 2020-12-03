package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストパラメータからIDを取得し、セッションにセット(リクエストスコープはリクエストごとにリセットされるため)
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        String _token = session.getId();

        // DBからレコードを1件取得する
        EntityManager em = DBUtil.createEntityManager();
        Task task = em.find(Task.class, id);

        request.setAttribute("task", task);
        request.setAttribute("_token", _token);

        request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp").forward(request, response);

    }

}
