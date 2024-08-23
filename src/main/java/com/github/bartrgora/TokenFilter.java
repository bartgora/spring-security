package com.github.bartrgora;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class TokenFilter implements Filter {

  private static final String TOKEN = "token";
  private static final String TOKEN_VALUE = "ee977806d7286510da8b9a7492ba58e2484c0ecc";


  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    String token = request.getHeader(TOKEN);
    if (token != null && token.equals(TOKEN_VALUE)) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

  }
}
