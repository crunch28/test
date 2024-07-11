package com.lgy.item_oracle.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.lgy.item_oracle.dao.ItemDAO;
import com.lgy.item_oracle.dto.ItemDTO;

public class ItemContentService implements ItemService {

	@Override
	public void excute(Model model) {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemDTO> list = dao.list();
		
		model.addAttribute("list", list);
	}
}