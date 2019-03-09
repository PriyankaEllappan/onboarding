package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.EmployeeProjectInfo;

public interface MailService {
    public void sendRequestEmail(EmployeeProjectInfo mailInfo);
    public void sendInProgressEmail(EmployeeProjectInfo mailInfo);
    public void sendCompletionEmail(EmployeeProjectInfo mailInfo);
}
