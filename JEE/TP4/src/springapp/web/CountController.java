package springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/count")
public class CountController {
	
	private int cpt = 0;
	
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(/*value = "/welcome",*/ method = RequestMethod.GET, params = {"increment"})
    public @ResponseBody ModelAndView sayHello(
    		@RequestParam(value = "increment") int increment
    		) {
        logger.info("Running " + this + "with a user-given increment");
        
        cpt += increment;
        
        return new ModelAndView("displayCpt", "cpt", cpt);
    }
    
    @RequestMapping(value = "/welcome2", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        logger.info("Running " + this);
        
        cpt ++;
        
        return new ModelAndView("displayCpt", "cpt", cpt);
    }

}