package controllers.follow;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Follow;
import utils.DBUtil;

/**
 * Servlet implementation class FollowServlet
 */
@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            EntityManager em=DBUtil.createEntityManager();

            Follow f=new Follow();

            //セッションスコープから取得した値をUser_idにセット
            f.setUser_id((Employee)request.getSession().getAttribute("login_employee"));

            //リクエストスコープから取得した値をfollower_idにセット
            Employee e=em.find(Employee.class,Integer.parseInt( request.getParameter("follower_id")));
            f.setFollower_id(e);

         //データベースに登録
           em.getTransaction().begin();
           em.persist(f);
           em.getTransaction().commit();
           em.close();


           response.sendRedirect(request.getContextPath()+"/reports/index");

    }

}
