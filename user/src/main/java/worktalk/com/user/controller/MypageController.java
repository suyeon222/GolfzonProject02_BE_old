package worktalk.com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import worktalk.com.user.domain.Customer_center;
import worktalk.com.user.service.Customer_centerFileService;
import worktalk.com.user.service.Customer_centerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	Customer_centerService service;

	@Autowired
	Customer_centerFileService service_file;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/mypage/customercenter.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		logger.info("Welcome selectAll");
		
		List<Customer_center> cc_boardlist = service.selectAll();
		logger.info("cc_boardlist.size() : {}",cc_boardlist.size());
		
		model.addAttribute("cc_boardlist",cc_boardlist);
		

		return "mypage/selectAll";
	}
	
	@RequestMapping(value = "/mypage/customercenter_insert.do", method = RequestMethod.POST)
	public String insert(Customer_center customer_center) {
		logger.info("Welcome insertOK...");
		logger.info("{}", customer_center);
		// vo에 맵핑을 위한 빈 등록-root-context.xml << multipartResolver필요
		customer_center = service_file.getVO(customer_center);
		
		int result = service.insert(customer_center);
		logger.info("result : {}", result);
		if (result == 1) {
			return "redirect:customercenter.do";
		} else {
			return "redirect:customercenter.do";
		}
	}
	
	@RequestMapping(value = "/mypage/customercenter_update.do", method = RequestMethod.POST)
	public String update(Customer_center customer_center) {
		logger.info("Welcome updateOK");
		
		customer_center = service_file.getVO(customer_center);
		logger.info("{}",customer_center);
		
		int result = service.update(customer_center);
		logger.info("result : {}", result);
		if (result == 1) {
			return "redirect:customercenter.do";
		} else {
			return "redirect:customercenter.do";
		}

	}
	@RequestMapping(value = "/mypage/customercenter_delete.do", method = RequestMethod.GET)
	public String delete(Customer_center customer_center) {
		logger.info("Welcome deleteOK");

		int result = service.delete(customer_center);
		logger.info("result : {}", result);

		return "redirect:customercenter.do";
	}
	@RequestMapping(value = "/mypage/customercenter_searchList.do", method = RequestMethod.GET)
	public String searchList(Model model, String searchKey, String searchWord) {
		logger.info("Welcome searchList");
		logger.info("searchKey:{}", searchKey);
		logger.info("searchWord:{}", searchWord);

		List<Customer_center> cc_boardlist = service.searchList(searchKey, searchWord);
		logger.info("result() : {}", cc_boardlist.size());
		model.addAttribute("cc_boardlist", cc_boardlist);
		return "mypage/selectAll";
	}

	
}
