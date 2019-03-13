/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.stereotype.Controller;

/**
 * @author 656579
 *
 */
@Controller
public class ProcessController {/*

	@Autowired
	ProcessorService processorService;
	
	*//**
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/process/processrequest/{empprojid}", method = RequestMethod.GET)
	public String generateRequestProcessForm(@ModelAttribute("employee") EmployeeProjHist employee,
			@PathVariable String empprojid, ModelMap model,Principal principal) {
		String processor; 
		try {
			processor = "429992";
			employee = processorService.getEmployeetoProcess(processor,empprojid);
			if(employee != null){
				System.out.println(employee.toString());
				model.addAttribute("employee", employee);
				return "process/requestProcessingForm";
			}else{
				model.addAttribute("employee", employee);
				return "commons/resourceNotAvailable";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	*//**
	 * @param employeeJson
	 * @return
	 *//*
	@PostMapping(value = "/process/processupdate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeProjHist assignProject(@RequestBody EmployeeProjHist employeeProjJson) {
		try {
			System.out.println(employeeProjJson.toString());
			return processorService.processAnEmployee(employeeProjJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(value = "/process/processlist", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String getAllEmployeestoProcess(ModelMap model) {
		int processorId = 227822;
		try {
			model.addAttribute("resources", processorService.getRecordsPerProcessor(processorId));
			return "resourcedetails/processList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
*/}
