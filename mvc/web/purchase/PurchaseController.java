package com.model2.mvc.web.purchase;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	public PurchaseController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	@RequestMapping("/addPurchaseView.do")
	public String addPurchaseView(@RequestParam("prodNo") int prodNo ,HttpSession session, Model model) throws Exception {
		User user = (User)session.getAttribute("user");
		Product product =purchaseService.addPurchasView(prodNo);
		model.addAttribute("product",product);
		
		return "forward:/purchase/addPurchaseView.jsp";
	}
	
	@RequestMapping("/addPurchase")
	public String addPurchase(@ModelAttribute("purchase") Purchase purchase) throws Exception{		
		purchaseService.addPurchase(purchase);
		
		return "redirect:/listPurchase.do";
	}
	
	@RequestMapping("/getPurchase.do")
	public String getPruchase(@RequestParam("tranNo") int tranNo,Model model) throws Exception{
		Purchase purchase = purchaseService.getPurcahse(tranNo);
		model.addAttribute("purchase",purchase);
		
		return "forward:/purchase/getPurchase.jsp";
	}
	
	@RequestMapping("/updatePurchaseView.do")
	public String updatePurchaseView(@RequestParam("tranNo") int tranNo,Model model) throws Exception{
		Purchase purchase = purchaseService.getPurcahse(tranNo);
		model.addAttribute("purchase",purchase);
		
		return "forward:/purchase/updatePurchase.jsp";
	}
	
	@RequestMapping("/updatePurchase.do")
	public String updatePurchase(@ModelAttribute("purchase") Purchase purchase) throws Exception{
		purchaseService.updatePurchase(purchase);
		
		return "redirect:/listPurchase.do";
	}
	
	@RequestMapping("/updateTranCode.do")
	public String updateTranCode(@ModelAttribute("purchase") Purchase purchase,@RequestParam("menu") String menu, @RequestParam("con") String con) throws Exception{
		purchaseService.updateTranCode(purchase);
		
		if(con.equals("user")) {
			return "/listPurchase.do";
		} 
		System.out.println(menu);
		return "redirect:/listProduct.do?searchValue=0&menu="+menu;
	}
}
