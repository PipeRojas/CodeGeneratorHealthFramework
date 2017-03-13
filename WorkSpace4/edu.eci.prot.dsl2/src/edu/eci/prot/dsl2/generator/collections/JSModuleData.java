package edu.eci.prot.dsl2.generator.collections;

public class JSModuleData {
	private String uriString;
	private String JSAppModuleString;
	private String HtmlSRCString;
	
	
	
	public JSModuleData() {
		
	}
	public JSModuleData(String uriString, String jSAppModuleString, String htmlSRCString) {
		super();
		this.uriString = uriString;
		JSAppModuleString = jSAppModuleString;
		HtmlSRCString = htmlSRCString;
	}
	public String getUriString() {
		return uriString;
	}
	public void setUriString(String uriString) {
		this.uriString = uriString;
	}
	public String getJSAppModuleString() {
		return JSAppModuleString;
	}
	public void setJSAppModuleString(String jSAppModuleString) {
		JSAppModuleString = jSAppModuleString;
	}
	public String getHtmlSRCString() {
		return HtmlSRCString;
	}
	public void setHtmlSRCString(String htmlSRCString) {
		HtmlSRCString = htmlSRCString;
	}
	
	
}
