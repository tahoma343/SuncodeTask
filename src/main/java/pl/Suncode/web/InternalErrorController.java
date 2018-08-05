package pl.Suncode.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class InternalErrorController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mv = new ModelAndView("redirect:/main");
		mv.addObject("error", "url not found");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		
	    ModelAndView mav = new ModelAndView("redirect:/mainerror");
	    mav.addObject("error", ex.getMessage());
	    return mav;
	  }
}
