/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.MyAction;

/**
 *
 * @author Aleksandar Milicevic
 */
public class PrikaziAction implements MyAction {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/pages/main.jsp";
    }

}
