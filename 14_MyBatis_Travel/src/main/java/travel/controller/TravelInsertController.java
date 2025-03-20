package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {

	private final String command = "insert.tv";
	private String gotoPage = "redirect:/list.tv";
	private final String getPage = "travelInsertForm";
	
	@Autowired
	TravelDao tdao;
	
	// travelList.jsp���� �߰��ϱ� Ŭ��
	// travelList.jsp���� �߰��ϱ� Ŭ��
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	// �����ϰ� ���� �߰�
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doActionPost(@ModelAttribute("travel") @Valid TravelBean travel, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = tdao.insertTravel(travel);
		
		mav.setViewName(gotoPage);
		return mav;
	}
}
