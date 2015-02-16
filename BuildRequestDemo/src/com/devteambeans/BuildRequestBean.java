package com.devteambeans;

import java.util.*;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.dbQueries.DataInsertionClass;
import com.login.LoginBean;

public class BuildRequestBean {
	private List<SelectItem> environments = new ArrayList<SelectItem>();
	private String requesttype = null;
	private String requestdate = null;
	private String requesttime = null;
	private String requirements = null;
	private String defects = null;
	private String remarks = null;
	private String selectedTeam = null;
	private String selectedEnv = null;
	private String reqname = null;

	public String getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}

	public BuildRequestBean(){
		environments.add(new SelectItem(0, "DEV"));
		environments.add(new SelectItem(1, "QAT"));
		environments.add(new SelectItem(2, "UAT"));
	}
	
	public List<SelectItem> getEnvironments() {
		return environments;
	}

	public void setEnvironments(List<SelectItem> environments) {
		this.environments = environments;
	}

	public String getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}

	public String getRequesttime() {
		return requesttime;
	}

	public void setRequesttime(String requesttime) {
		this.requesttime = requesttime;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getDefects() {
		return defects;
	}

	public void setDefects(String defects) {
		this.defects = defects;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String raiseDeploymentRequest(){
		DataInsertionClass ds = new DataInsertionClass();
		String result = ds.insertBuildRequest(this);
		return result;
	}
	
	public void onSelectTeam(ValueChangeEvent event){
		String str = event.getNewValue().toString();
		if (str != null) {
			setSelectedTeam(str);
		}
	}

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public String getSelectedEnv() {
		return selectedEnv;
	}

	public void setSelectedEnv(String selectedEnv) {
		this.selectedEnv = selectedEnv;
	}
	
	public void onSelectEnv(ValueChangeEvent event){
		String str = event.getNewValue().toString();
		if (str != null) {
			setSelectedEnv(str);
		}
	}

	public String getReqname() {
		return reqname;
	}

	public void setReqname(String reqname) {
		this.reqname = reqname;
	}
}