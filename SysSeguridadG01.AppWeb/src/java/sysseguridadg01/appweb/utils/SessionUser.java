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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sysseguridadg01.entidadesdenegocio.Usuario;

public class SessionUser {
    public static void autenticarUser (HttpServletRequest request, Usuario pUsuario){
        HttpSession session = (HttpSession) request.getSession();
        session.setMaxInactiveInterval(3600);
        session.setAttribute("auth", true);
        session.setAttribute("user", pUsuario.getLogin());
        session.setAttribute("rol", pUsuario.getRol().getNombre());
    }}