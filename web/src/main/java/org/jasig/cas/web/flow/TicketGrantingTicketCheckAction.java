//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.jasig.cas.web.flow;

import javax.validation.constraints.NotNull;
import org.jasig.cas.ticket.Ticket;
import org.jasig.cas.ticket.registry.TicketRegistry;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.util.StringUtils;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class TicketGrantingTicketCheckAction {
  public static final String NOT_EXISTS = "notExists";
  public static final String INVALID = "invalid";
  public static final String VALID = "valid";
  @NotNull
  private final TicketRegistry ticketRegistry;

  public TicketGrantingTicketCheckAction(TicketRegistry registry) {
    this.ticketRegistry = registry;
  }

  public Event checkValidity(RequestContext requestContext) {
    String tgtId = WebUtils.getTicketGrantingTicketId(requestContext);
    if(!StringUtils.hasText(tgtId)) {
      return new Event(this, "notExists");
    } else {
      Ticket ticket = this.ticketRegistry.getTicket(tgtId);
      return new Event(this, ticket != null && !ticket.isExpired()?"valid":"invalid");
    }
  }
}
