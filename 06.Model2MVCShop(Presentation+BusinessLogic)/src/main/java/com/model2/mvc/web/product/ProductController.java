package com.model2.mvc.web.product;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService	productService;
	
	public ProductController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	@RequestMapping("/addProduct.do")
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("manuDate") String manuDate) throws Exception{
		System.out.println("/addProduct");
		product.setManuDate(manuDate.replace("-", ""));
		productService.addProduct(product);
		
		return "forward:/product/addProduct.jsp";
	}
	
	@RequestMapping("/getProduct.do")
	public String getProduct(@RequestParam("prodNo") int prodNo, Model model, HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("/getProduct");
		Product product = productService.getProduct(prodNo);
		model.addAttribute("product",product);
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie =null;
		String history = null;		
		
		if (cookies!=null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				
				cookie = cookies[i];
				if (cookie.getName().equals("history")) {
					history =URLDecoder.decode(cookie.getValue(), "euc_kr")+","+request.getParameter("prodNo");
				}
			}
			if (history != null) {
				String[] h = history.split(",");
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < h.length; i++) {
					if (!h[i].equals("null")) {					
						if(!list.contains(h[i])){
							list.add(h[i]);
						}
					}
				}
				history = "";
				for(int i=list.size()-1; i >0; i--){
					history += list.get(i)+",";
				}
				history += list.get(0);
				cookie = new Cookie("history", URLEncoder.encode(history,"EUC_KR"));
				System.out.println(history);
			} else {
				cookie = new Cookie("history", URLEncoder.encode(Integer.toString(product.getProdNo()),"EUC_KR"));
			}
		}
		
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		return "forward:/product/getProduct.jsp";
	}
	
	@RequestMapping("/updateProductView.do")
	public String updateProductView(@RequestParam("prodNo") int prodNo, Model model) throws Exception {
		System.out.println("/updateProductView");
		Product product = productService.getProduct(prodNo);
		model.addAttribute("product",product);
		
		return "forward:/product/updateProduct.jsp";
	}
	
	@RequestMapping("/updateProduct.do")
	public String updateProduct(@ModelAttribute("product") Product product, Model model) throws Exception{
		System.out.println("/updateProduct");
		productService.updateProduct(product);
		
		return "forward:/getProduct.do?prodNo="+product.getProdNo();
	}
	
	@RequestMapping("/listProduct.do")
	public String listProduct(@ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception {
		System.out.println("/listProduct");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);		
		
		if(request.getParameter("searchValue").equals("5")) {
			String priceKeyword = request.getParameter("sPriceKeyword")+","+request.getParameter("bPriceKeyword");
			search.setSearchKeyword(priceKeyword);
			search.setSearchCondition("3");
		}
		
		// Business logic 수행
		Map<String , Object> map=productService.getProductList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/product/listProduct.jsp";
	}
}
