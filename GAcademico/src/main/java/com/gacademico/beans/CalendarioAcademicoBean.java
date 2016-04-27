package com.gacademico.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import com.gacademico.entities.Periodo;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.PeriodoService;

@Named
@ViewScoped
public class CalendarioAcademicoBean implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 
	 private ScheduleModel eventModel;
	 private ScheduleEvent event = new DefaultScheduleEvent();
	 private List<Periodo> periodos;

	 @Inject
	 private PeriodoService service;
	 
	 @PostConstruct
	 public void init() {
		 try {
			 periodos = service.getAll();
		 } catch (DacaServiceException e) {
			 e.printStackTrace();
		 }
	     eventModel = new DefaultScheduleModel();
	     for (Periodo p : periodos){
	    	 eventModel.addEvent(new DefaultScheduleEvent(p.getNome(), p.getDataDeInicio(), p.getDataDeTermino()));
	     }
	 }

	 public Date getRandomDate(Date base) {
	     Calendar date = Calendar.getInstance();
	     date.setTime(base);
	     date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);

	     return date.getTime();
	 }


	 public Date getInitialDate() {
	     Calendar calendar = Calendar.getInstance();
	     calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

	     return calendar.getTime();
	 }

	 public ScheduleModel getEventModel() {
	     return eventModel;
	 }

	     public ScheduleEvent getEvent() {
	     return event;
	 }

	 public void setEvent(ScheduleEvent event) {
	     this.event = event;
	 }

	 public void addEvent(ActionEvent actionEvent) {
	     if(event.getId() == null)
	         eventModel.addEvent(event);
	     else
	         eventModel.updateEvent(event);

	     event = new DefaultScheduleEvent();
	 }

	 public void onEventSelect(SelectEvent selectEvent) {
	     event = (ScheduleEvent) selectEvent.getObject();
	 }

	 public void onDateSelect(SelectEvent selectEvent) {
	     event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	 }

	 public void onEventMove(ScheduleEntryMoveEvent event) {
	     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

	     addMessage(message);
	 }

	 public void onEventResize(ScheduleEntryResizeEvent event) {
	     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

	     addMessage(message);
	 }

	 private void addMessage(FacesMessage message) {
	     FacesContext.getCurrentInstance().addMessage(null, message);
	 }   
}