package org.snowman.keycloak.controller;

import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ProductController {

	/**
	 * <p>此处如果需要认证权限需要添加配置文件</p>
	 * <code>
	 * keycloak.security-constraints[0].authRoles[0]=user
     * keycloak.security-constraints[0].securityCollections[0].patterns[0]=/products/*
	 * <code>
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/products")
	public String getProducts(Model model){
		model.addAttribute("products", Arrays.asList("iPad","iPhone","iPod"));
		return "products";
	}

	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/";
	}
}
