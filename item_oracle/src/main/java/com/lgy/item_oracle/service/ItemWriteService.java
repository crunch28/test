package com.lgy.item_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.item_oracle.dao.ItemDAO;
import com.lgy.item_oracle.dto.ItemDTO;

public class ItemWriteService implements ItemService {

	@Override
	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		ItemDAO dao = new ItemDAO();
		ItemDTO dto = new ItemDTO();
		int price = Integer.parseInt(request.getParameter("price"));
		
		dto.setName(request.getParameter("name"));
		dto.setPrice(price);
		dto.setDescription(request.getParameter("description"));
		
		dao.insert(dto);
	}
}