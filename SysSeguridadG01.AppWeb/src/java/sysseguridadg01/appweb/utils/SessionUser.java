package sysseguridadg01.appweb.utils;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sysseguridadg01.entidadesdenegocio.Usuario;

public class SessionUser {
    public static void autenticarUser(HttpServletRequest request, Usuario pUsuario) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3600);
        session.setAttribute("auth", true);
        session.setAttribute("user", pUsuario.getLogin());
        session.setAttribute("rol", pUsuario.getRol().getNombre());
    }

    public static boolean isAuth(HttpServletRequest request) {
        HttpSession session = request.getSession();
        boolean auth = session.getAttribute("auth") != null ? (boolean) session.getAttribute("auth") : false;
        return auth;
    }

    public static String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user = "";
        if (SessionUser.isAuth(request)) {
            user = session.getAttribute("user") != null ? (String) session.getAttribute("user") : "";
        }
        return user;
    }

    public static String getRol(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String rol = "";
        if (SessionUser.isAuth(request)) {
            rol = session.getAttribute("rol") != null ? (String) session.getAttribute("rol") : "";
        }
        return rol;
    }
    public static void authorize(HttpServletRequest request,
            HttpServletResponse response,
            IAuthorize pIAuthorize) throws ServletException,
            IOException
            {
                if(SessionUser.isAuth(request))
                {
                    pIAuthorize.authorize();
                }
                else
                {
                    response.sendRedirect("Usuario?accion=login");
                }
            }
    public static void cerrarSession (HttpServletRequest request)
    {
        HttpSsession = (HttpSession) request.getSession();
        session.invalidate();
    }
}
