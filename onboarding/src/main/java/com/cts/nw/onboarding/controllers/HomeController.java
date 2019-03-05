/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 656579
 *
 */
@Controller
public class HomeController {
	@GetMapping("/")
	  public String index(Model model, Principal principal) {
	    model.addAttribute("message", "You are logged in as " + principal.getName());
	    return "index";
	  }
}
