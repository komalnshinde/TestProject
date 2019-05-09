package com.AutomationConceptsPractice;

public enum LogStatus {
	PASS, FAIL, FATAL, ERROR, WARNING, INFO, SKIP, UNKNOWN;

	@Override
	public String toString() {

		switch (this) {
		case PASS:
			return "pass";
		case FAIL:
			return "fail";
		case ERROR:
			return "error";
		case WARNING:
			return "warning";
		case INFO:
			return "info";
		case SKIP:
			return "skip";
		default:
			return "unknown";
		}

	}
}
