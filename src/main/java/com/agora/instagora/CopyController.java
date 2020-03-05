package com.agora.instagora;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CopyController {
	
	@GetMapping("/copy/{id}")
	public Copy getCopy(@PathVariable int id) {
		return new Copy();
	}

	@GetMapping("/copy")
	public String getCopy() {
		return "hello world";
	}
}
