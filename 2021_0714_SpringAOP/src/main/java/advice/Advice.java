package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice {
	
	//자동생성시에는 request auto injection시켜준다.
	//수동생성시 <context: annotation-config/> 설정해야 Injection시켜준다.
	@Autowired
	HttpServletRequest request;
	
	public void before(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		System.out.println("----before:" + s.toString());
		
		//현재시간을 1/1000초 단위로 구해온다.
		long start = System.currentTimeMillis();
		
		request.setAttribute("start", start);
	}
	
	public void after(JoinPoint jp){
		Signature s =  jp.getSignature();
		System.out.println("----after:" + s.toString());
		
		long start = (Long)request.getAttribute("start");
		
		long end = System.currentTimeMillis();
		
		System.out.printf("수행시간 : %d(ms)\n", (end-start));
		//System.out.println("----after:" + s.toLongString());
		//System.out.println("----after:" + s.toShortString());
		
	}
}
