package helpdesk.enteties.impl;

import helpdesk.enteties.Priority;
import helpdesk.enteties.RequestType;
import helpdesk.enteties.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {

	private int counter;

	private RequestType requestType;
	private int sequentialNumber;
	{
		sequentialNumber = ++counter;
	}

	public DefaultSupportTicket() {
	}

	public DefaultSupportTicket(RequestType requestType) {
		this.requestType = requestType;
	}

	@Override
	public Priority getPriority() {
		if (requestType == null)
			return null;
		return this.requestType.getPriority();
	}

	@Override
	public int getSequencialNumber() {
		return this.sequentialNumber;
	}

	@Override
	public RequestType getRequestType() {
		return this.requestType;
	}

}
