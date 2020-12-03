package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //セッションIDを生成して、リクエストスコープにセット
        //CSRF攻撃対策
        String _token = request.getSession().getId();
        request.setAttribute("_token", _token);

        //フォームの内容にDTO型のデータを渡す必要があるので、初期値からのデータを生成
        Task task = new Task();
        request.setAttribute("task", task);

        request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp").forward(request, response);
    }

}
