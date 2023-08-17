package helpdesk.facades.impl;

import java.util.PriorityQueue;
import java.util.Queue;

import helpdesk.enteties.SupportTicket;
import helpdesk.facades.HelpDeskFacade;
import helpdesk.utils.CustomSupportTicketsComparator;

public class DefaultHelpDeskFacade implements HelpDeskFacade {

	private Queue<SupportTicket> tickets;

	{
		tickets = new PriorityQueue<SupportTicket>(new CustomSupportTicketsComparator());
	}

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {
		tickets.offer(supportTicket);

	}

	@Override
	public SupportTicket getNextSupportTicket() {
		return tickets.poll();
	}

	@Override
	public int getNumberOfTickets() {
		return tickets.size();
	}

}
