package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.bo.ProcessorsInfo;

public interface MailService {
    public void sendRequestEmail(EmployeeProjectInfo mailInfo);
    public void sendInProgressEmail(ProcessorsInfo mailInfo);
    public void sendCompletionEmail(ProcessorsInfo mailInfo);
    public void releaseInitiatedEmail(ProcessorsInfo mailInfo);
    public void resourceOffBoardingEmail(ProcessorsInfo mailInfo);
}
