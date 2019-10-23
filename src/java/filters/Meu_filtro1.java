/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Win7
 */
public class Meu_filtro1 implements Filter{

    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (filterConfig==null){
            return ;
        }
        PrintWriter out = response.getWriter();
        CharResponseWrapper wrapper = new CharResponseWrapper(
                    (HttpServletResponse) response);
        chain.doFilter(request, wrapper);
        
        CharArrayWriter caw = new CharArrayWriter();
        caw.write(
                wrapper.toString().substring(
                        0,
                        wrapper.toString().indexOf("</body>") - 1));
        caw.write(
                "<a href='Meu_Projeto1'>Meu Projeto 122</a>");
        caw.write("\n</body></html>");
        response.setContentLength(caw.toString()
                                     .getBytes().length);
        out.write(caw.toString());
        out.close();
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.filterConfig = null;
    }
    
}
