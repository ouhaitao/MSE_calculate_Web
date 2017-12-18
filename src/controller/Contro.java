package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Dao.MainDao;

@Controller
public class Contro {

	@Autowired
	private MainDao mainDao;
	
	@RequestMapping("/calculator.do")
	public String calculator(Model model, int flagNumber){
		model.addAttribute("formula", mainDao.calculator(flagNumber));
		return "formula";
	}


	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	
}
