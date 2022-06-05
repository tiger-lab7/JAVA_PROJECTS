import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String... args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.setHostname("localhost");
        String appBase = ".";
        tomcat.getHost().setAppBase(appBase);

        File docBase = new File(System.getProperty("java.io.tmpdir"));
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        Class servletClass = MyServlet.class;
        Tomcat.addServlet(
                context, servletClass.getSimpleName(), servletClass.getName());
        context.addServletMappingDecoded(
                "/my-servlet/*", servletClass.getSimpleName());

/*
        Class filterClass = MyFilter.class;
        FilterDef myFilterDef = new FilterDef();
        myFilterDef.setFilterClass(filterClass.getName());
        myFilterDef.setFilterName(filterClass.getSimpleName());
        context.addFilterDef(myFilterDef);

        FilterMap myFilterMap = new FilterMap();
        myFilterMap.setFilterName(filterClass.getSimpleName());
        myFilterMap.addURLPattern("/my-servlet/*");
        context.addFilterMap(myFilterMap);*/


        tomcat.start();
        tomcat.getServer().await();
    }
}


class MyServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("test");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}

class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        // ...
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.addHeader("myHeader", "myHeaderValue");
        chain.doFilter(request, httpResponse);
    }

    @Override
    public void destroy() {
        // ...
    }
}
