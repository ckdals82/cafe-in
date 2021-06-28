package vo;

public class ProductVo {
   
   int    p_idx;
   String p_category;
   String p_num;
   String p_name;
   String p_company;
   int    p_price;
   int    p_saleprice;
   String p_image_s;
   String p_image_l;
   String p_content;
   String p_regdate;
   
   int sale_rate; // 할인율
   
   public ProductVo() {
      // TODO Auto-generated constructor stub
   }
   
   

   public ProductVo(String p_category, String p_num, String p_name, String p_company, int p_price, int p_saleprice,
         String p_image_s, String p_image_l, String p_content) {
      super();
      this.p_category = p_category;
      this.p_num = p_num;
      this.p_name = p_name;
      this.p_company = p_company;
      this.p_price = p_price;
      this.p_saleprice = p_saleprice;
      this.p_image_s = p_image_s;
      this.p_image_l = p_image_l;
      this.p_content = p_content;
   }









   public int getSale_rate() {
      
      //할인율 = (정가-할인가)/정가 * 100
      if(p_price==0) return 0;
      
      
      return (int)((double)(p_price-p_saleprice)/p_price * 100); //형변환해야지 소수점나옴 
   }
   
   
   public int getP_idx() {
      return p_idx;
   }
   public void setP_idx(int p_idx) {
      this.p_idx = p_idx;
   }
   public String getP_category() {
      return p_category;
   }
   public void setP_category(String p_category) {
      this.p_category = p_category;
   }
   public String getP_num() {
      return p_num;
   }
   public void setP_num(String p_num) {
      this.p_num = p_num;
   }
   public String getP_name() {
      return p_name;
   }
   public void setP_name(String p_name) {
      this.p_name = p_name;
   }
   public String getP_company() {
      return p_company;
   }
   public void setP_company(String p_company) {
      this.p_company = p_company;
   }
   public int getP_price() {
      return p_price;
   }
   public void setP_price(int p_price) {
      this.p_price = p_price;
   }
   public int getP_saleprice() {
      return p_saleprice;
   }
   public void setP_saleprice(int p_saleprice) {
      this.p_saleprice = p_saleprice;
   }
   public String getP_image_s() {
      return p_image_s;
   }
   public void setP_image_s(String p_image_s) {
      this.p_image_s = p_image_s;
   }
   public String getP_image_l() {
      return p_image_l;
   }
   public void setP_image_l(String p_image_l) {
      this.p_image_l = p_image_l;
   }
   public String getP_content() {
      return p_content;
   }
   public void setP_content(String p_content) {
      this.p_content = p_content;
   }
   public String getP_regdate() {
      return p_regdate;
   }
   public void setP_regdate(String p_regdate) {
      this.p_regdate = p_regdate;
   }
   
   
}