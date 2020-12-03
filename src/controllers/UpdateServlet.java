package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;
import validators.TaskValidators;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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

            int id = (Integer) (request.getSession().getAttribute("id"));

            EntityManager em = DBUtil.createEntityManager();
            Task task = em.find(Task.class, id);

            //DBへ更新するデータを取得
            String content = request.getParameter("content");
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            task.setContent(content);
            task.setUpdated_at(currentTime);

            //バリデーション
            List<String> errors = TaskValidators.taskValidate(task);
            if (errors.size() > 0) {
                em.close();
                request.setAttribute("_token", _token);
                request.setAttribute("task", task);
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp").forward(request, response);
            } else {

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(task);
                transaction.commit();
                em.close();
                request.getSession().removeAttribute("id");
                response.sendRedirect(request.getContextPath() + "/index");
            }

        }
    }

}
