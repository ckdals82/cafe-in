package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.TestDao;

@Controller
public class TestController {

   TestDao test_dao;

   public void setTest_dao(TestDao test_dao) {
      this.test_dao = test_dao;
   }
   
   @RequestMapping("/test1.do")
   @ResponseBody
   public String test1() {
      
      test_dao.test1();
      
      //test_dao.test1(10);
      
      //test_dao.test2();
      
      return "call test1";
   }
}