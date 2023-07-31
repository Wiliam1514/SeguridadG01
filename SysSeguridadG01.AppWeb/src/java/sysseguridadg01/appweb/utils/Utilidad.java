/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sysseguridadg01.appweb.utils;

/**
 *
 * @author MINEDUCYT
 */
import java.io.IOException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import static javax.management.Query.value;
import sysseguridadg01.entidadesdenegocio.Usuario;
public class Utilidad {
    public static String getParameter(HttpServletRequest request, String pKey,
            String pDafault)
    {
        String result = "";
        String value = request.getParameter(pKey);
        if (value !=null && value.trim().length () > 0)
        {
            result = value;
        }
        else
        {
            result = pDafault;
        }
        return result;
    }
    public static void enviarError( String pError, HttpServletRequest request,
            HttpServletResponse response) throws
            ServletException, IOException
    {
        request.setAttribute(pError, pError);
        request.getRequestDispatcher("views/Share/error.jsp").
                forward(request, response);
    }
    public static String obtenerRuta (HttpServletRequest request, String pStrRuta)
    {
        return request.getContextPath()+ pStrRuta;
    }
    
}
