/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bean.User;
import com.cts.nw.onboarding.dao.AdminDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.AdminService;

/**
 * @author 656579
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;

    @Override
    public void registerUser(User user) throws CustomException {
           try {
                  adminDAO.registerUser(user);
           } catch (CustomException e) {
                  throw new CustomException(e.getMessage());
           }
    }

}
