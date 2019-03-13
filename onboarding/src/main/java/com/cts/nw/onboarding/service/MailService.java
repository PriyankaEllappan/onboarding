package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;

public interface MailService {
    public void sendRequestEmail(EmployeeProjHist mailInfo);
    public void sendInProgressEmail(EmployeeProjHist mailInfo);
    public void sendCompletionEmail(EmployeeProjHist mailInfo);
    public void releaseInitiatedEmail(EmployeeProjHist mailInfo);
    public void resourceOffBoardingEmail(EmployeeProjHist mailInfo);
}
