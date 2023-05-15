package com.kh.app;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@GetMapping("chat")
	public String chat(HttpSession session) {
		Object nick = session.getAttribute("nick");
		if(nick == null) {
			return "redirect:error-page~~~";
		}
		return "chat";
	}

}









