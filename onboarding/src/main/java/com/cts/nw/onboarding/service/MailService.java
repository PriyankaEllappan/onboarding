package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.bo.EmployeeProjHist;

public interface MailService {
    public void onBoardingInitiated(EmployeeProjHist mailInfo);
    public void onBoardingAcknowledged(EmployeeProjHist mailInfo);
    public void onBoardingCompleted(EmployeeProjHist mailInfo);
    public void offBoardingInitiated(EmployeeProjHist mailInfo);
    public void offBoardingCompleted(EmployeeProjHist mailInfo);
	public void onBoardingRejected(EmployeeProjHist employeeProjHist);
	public void sendMailPin(AuthenticationInfo authenticationInfo);
}
