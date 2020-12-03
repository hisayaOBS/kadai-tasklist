package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 永続エンティティ接続情報を取得
        EntityManager em = DBUtil.createEntityManager();

        // リクエストパラメータから主キーIDを取得
        int id = Integer.parseInt(request.getParameter("id"));

        // DBからレコード1件を取得する
        Task task = em.find(Task.class, id);
        em.close();

        // リクエストスコープに1件分のレコードをセットし、show.jspにフォワード
        request.setAttribute("task", task);
        request.getRequestDispatcher("/WEB-INF/views/tasks/show.jsp").forward(request, response);

    }

}
