import controller.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by easom on 2017/8/16.
 */
@WebServlet(urlPatterns = "/")
public class hello extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig)throws ServletException{

        //获取ServletContext对象（用于注册servlet）
        ServletContext servletContext=servletConfig.getServletContext();
        //注册处理JSP的servlet
     //  ServletRegistration jspServlet=servletContext.getServletRegistration("jsp");
     //  jspServlet.addMapping("/ckeditor/samples/home.jsp");
        //注册处理静态资源的默认Servlet
        ServletRegistration defaultServlet=servletContext.getServletRegistration("default");
        defaultServlet.addMapping("/assets/"+"*");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req,HttpServletResponse resp) throws Exception {

        req.setCharacterEncoding("UTF-8");//提前解决乱码问题
        String uri=req.getRequestURI(); //不包括？号以后
        System.out.println("hello.51:uri:"+uri+"  ");
        /*
         *  uri is in this form:/contextName/resourceName,
         *  for example: /app1/product_input.
         */ System.out.println(req.getParameter("bid"));
        int lastIndex =uri.lastIndexOf("/");
        String action=uri.substring(lastIndex +1);

     //   action=action.split("[?]")[0];
        String dispatchUrl=null;

        if(action.equals("list.action")){
            ListController controller =new ListController();
            dispatchUrl=controller.handleRequest(req,resp);
        }else if(action.equals("edit.action")){
            EditController controller=new EditController();
            dispatchUrl=controller.handleRequest(req,resp);
        }else if(action.equals("show.action")){
            ShowController controller=new ShowController();
            dispatchUrl=controller.handleRequest(req,resp);
        }else if(action.equals("delete.action")){
           DeleteController controller=new DeleteController();
            dispatchUrl=controller.handleRequest(req,resp);
        }
        else if(action.equals("save.action")){
            SaveController controller=new SaveController();
            dispatchUrl=controller.handleRequest(req,resp);
        }else if(action.equals("update.action")){
            UpdateController controller=new UpdateController();
            dispatchUrl=controller.handleRequest(req,resp);
        }

        if(dispatchUrl!=null){
            RequestDispatcher rd= req.getRequestDispatcher(dispatchUrl);
            rd.forward(req,resp);
        }

    }
}