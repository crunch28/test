package com.lgy.item_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_oracle.service.ItemContentService;
import com.lgy.item_oracle.service.ItemService;
import com.lgy.item_oracle.service.ItemWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService service;
	
	@RequestMapping("/item_write")
	public String write(Model model) {
		log.info("@# item_write");
		
		return "item_write";
	}
	
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result");
		model.addAttribute("request", request);
		service = new ItemWriteService();
		service.excute(model);
		
		return "write_result";
	}
	
	@RequestMapping("/content")
	public String content() {
		log.info("@# content");
		return "redirect:content_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(Model model) {
		log.info("@# content_view");
		service = new ItemContentService();
		service.excute(model);
		
		return "content_view";
	}
}