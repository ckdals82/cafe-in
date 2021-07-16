package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ProductService;
import vo.ProductVo;

@Controller
@RequestMapping("/product/")
public class ProductController {

   
   ProductService product_service;
   
   
   public void setProduct_service(ProductService product_service) {
      this.product_service = product_service;
   }


   @RequestMapping("list.do")
   public String list(Model model) {
      
      Map map = product_service.selectList();
      
      //결과적으로...  request binding
      model.addAttribute("map", map);
      
      return "product/product_list";
   }
   
   //  /product/insert_in.do?name=TV&cnt=11
   //입고처리
   @RequestMapping("insert_in.do")
   public String insert_in(ProductVo vo) {
      
      try {
         
         product_service.insert_in(vo);
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "redirect:list.do";
   }
   
   
   //입고처리 취소
   // /tx/product/delete_in.do?idx=10&idx=11&idx=12
   @RequestMapping("delete_in.do")
   public String delete_in(int [] idx) {
      
      try {
         
         product_service.delete_in(idx);
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "redirect:list.do";
   }
   
   
   
   
   
   // /product/insert_out.do?name=TV&cnt=10
   //출고처리
   @RequestMapping("insert_out.do")
   public String insert_out(ProductVo vo,Model model) {
      
      try {
         
         product_service.insert_out(vo);
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         //e.printStackTrace();
         String message = e.getMessage();
         //System.out.println(message);
         model.addAttribute("error", message);
         
         //Model용도(누가=> ?? )
         //1.forward시 request binding
         //2.redirect시에는 요청parameter(query)로 이용
         //  redirect:list.do=> response.sendRedirect("list.do?error=remain_not");
      }
      
      return "redirect:list.do";
   }
   
   
   
   
   
   
   
   
}