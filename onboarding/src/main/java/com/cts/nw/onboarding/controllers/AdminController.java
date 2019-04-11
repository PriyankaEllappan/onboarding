/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bean.AjaxResponse;
import com.cts.nw.onboarding.bean.User;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.AdminService;

/**
 * @author 656579
 *
 */
@Controller
public class AdminController extends AbstractController{

	Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	/**
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/admin/register", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelView;
		try {
			modelView = bindViewwithUserInfo("admin/registerUser");
		} catch (Exception e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e.getMessage());
		}
		return modelView;
	}
	
    @PostMapping(value = "/admin/register", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody AjaxResponse registerUser(@RequestBody User user, ModelMap model) {
           AjaxResponse ajaxResponse = new AjaxResponse();
           try {
                  adminService.registerUser(user);
                  ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
                  ajaxResponse.setStatusMessage(AppConstants.DETAILS_SAVED);
           } catch (CustomException e) {
                  ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
                  ajaxResponse.setStatusMessage(ErrorConstants.USERALREADYEXISTS);
           }
           return ajaxResponse;
    }

	
}
