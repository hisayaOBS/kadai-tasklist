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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //CSRF対策
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {

            Task task = new Task();

            //リクエストスコープからデータを取得し、DBへ登録
            String content = request.getParameter("content");
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            task.setContent(content);
            task.setCreated_at(currentTime);
            task.setUpdated_at(currentTime);

            //バリデーション実行
            List<String> errors = TaskValidators.taskValidate(task);

            if (errors.size() > 0) {
                //入力エラー有り:入力画面にフォワードするため、再度トークンも含めリクエストスコープへセットする
                request.setAttribute("task", task);
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("WEB-INF/views/tasks/new.jsp").forward(request, response);
            } else {
                EntityManager em = DBUtil.createEntityManager();//永続エンティティ取得
                EntityTransaction transaction = em.getTransaction();//永続トランザクション所得
                transaction.begin(); //トランザクション開始

                em.persist(task); //INSERT INTO
                transaction.commit(); // DB更新確定
                em.close();

                response.sendRedirect(request.getContextPath() + "/index");
            }

        }
    }

}
