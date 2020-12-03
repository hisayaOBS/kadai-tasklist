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
 * Servlet implementation class Deleteservlet
 */
@WebServlet("/delete")
public class DestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {

            //主キーIDを取得しDBから削除対象のレコード1件取得
            int id = (Integer) (request.getSession().getAttribute("id"));

            EntityManager em = DBUtil.createEntityManager();

            Task task = em.find(Task.class, id);

            //DBから該当するレコード1件を削除
            em.getTransaction().begin();
            em.remove(task);// SQLのdeleteと同じ
            em.getTransaction().commit();
            em.close();

            //indexにリダイレクト
            response.sendRedirect(request.getContextPath() + "/index");

        }
    }

}
