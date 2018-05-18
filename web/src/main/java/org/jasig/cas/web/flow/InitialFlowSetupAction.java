//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.jasig.cas.web.flow;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.jasig.cas.authentication.principal.WebApplicationService;
import org.jasig.cas.web.support.ArgumentExtractor;
import org.jasig.cas.web.support.CookieRetrievingCookieGenerator;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.util.StringUtils;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public final class InitialFlowSetupAction extends AbstractAction {
  @NotNull
  private CookieRetrievingCookieGenerator warnCookieGenerator;
  @NotNull
  private CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator;
  @NotNull
  @Size(
      min = 1
  )
  private List<ArgumentExtractor> argumentExtractors;
  private boolean pathPopulated = false;

  public InitialFlowSetupAction() {
  }

  protected Event doExecute(RequestContext context) throws Exception {
    HttpServletRequest request = WebUtils.getHttpServletRequest(context);
    if(!this.pathPopulated) {
      String service = context.getExternalContext().getContextPath();
      String cookiePath = StringUtils.hasText(service)?service + "/":"/";
      this.logger.info("Setting path for cookies to: " + cookiePath);
      this.warnCookieGenerator.setCookiePath(cookiePath);
      this.ticketGrantingTicketCookieGenerator.setCookiePath(cookiePath);
      this.pathPopulated = true;
    }

    context.getFlowScope().put("ticketGrantingTicketId", this.ticketGrantingTicketCookieGenerator.retrieveCookieValue(request));
    context.getFlowScope().put("warnCookieValue", Boolean.valueOf(this.warnCookieGenerator.retrieveCookieValue(request)));
    WebApplicationService service1 = WebUtils.getService(this.argumentExtractors, context);
    if(service1 != null && this.logger.isDebugEnabled()) {
      this.logger.debug("Placing service in FlowScope: " + service1.getId());
    }

    context.getFlowScope().put("service", service1);
    return this.result("success");
  }

  public void setTicketGrantingTicketCookieGenerator(CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator) {
    this.ticketGrantingTicketCookieGenerator = ticketGrantingTicketCookieGenerator;
  }

  public void setWarnCookieGenerator(CookieRetrievingCookieGenerator warnCookieGenerator) {
    this.warnCookieGenerator = warnCookieGenerator;
  }

  public void setArgumentExtractors(List<ArgumentExtractor> argumentExtractors) {
    this.argumentExtractors = argumentExtractors;
  }
}
