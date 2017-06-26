/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafael.barreto
 */
public class PessoaServlet extends HttpServlet {

    @Override    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       ArrayList<String> nomes = new ArrayList<>();
       resp.setContentType("text/html");
       try (final PrintWriter out = resp.getWriter();) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            
            out.append("<form>");
                out.append("<label>");
                    out.append("nome");
                out.append("</label>");
            out.append("</form>");    
           
            out.append("<table>");
                out.append("<tr>");
                    out.append("<td>");
                        nomes.forEach(n -> out.append(n));
                    out.append("</td>");
                out.append("</tr>");
            out.append("</table>");
            
            out.append("</html>");
        }           
    }    
}
