package de.kreth.clubhelper.model.controller;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController
{
   @GetMapping
   public String index(Principal principal)
   {
      return principal == null ? "Welcome to Clubhelper Rest" : "Welcome to Clubhelper Rest, " + principal.getName();
   }

   @GetMapping("/login")
   @PreAuthorize("isAuthenticated()")
   public String login(Principal principal)
   {
      return principal == null ? "null" : principal.getName();
   }

   @GetMapping(path = "/logout")
   public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException
   {
      request.logout();
      try {
         response.sendRedirect("/");
      }
      catch (IOException e) {
         throw new UncheckedIOException("Redirect failed", e);
      }
   }
}
