/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.ProcessorsInfo;

/**
 * @author 656579
 *
 */
public interface ProcessorService {

	ProcessorsInfo getEmployeetoProcess(int processorId,int empProjId);

	ProcessorsInfo processAnEmployee(ProcessorsInfo employeeProjJson);

}
