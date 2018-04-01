package com.workitem.workitem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.services.task.lifecycle.listeners.TaskLifeCycleEventListener;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.kie.api.task.TaskEvent;
import org.kie.api.task.model.Content;


public class SlackEventHandler implements TaskLifeCycleEventListener {

	private static Map<String, Object> initialize(Content content) {
		Map<String, Object> contentMap = null;
		Object unmarshalledContent = ContentMarshallerHelper.unmarshall(content.getContent(), null);
		if (unmarshalledContent != null && unmarshalledContent instanceof Map) {
			System.out.println("unmarshelled value is not null");
			contentMap = (Map<String, Object>) unmarshalledContent;
		}
		return contentMap;
	}
	
	@Override
	public void beforeTaskActivatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskClaimedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskSkippedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskStartedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskStoppedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskCompletedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskFailedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskAddedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskExitedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskReleasedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskResumedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskSuspendedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskForwardedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskDelegatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskNominatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskActivatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskClaimedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskSkippedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskStartedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskStoppedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskCompletedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskFailedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskAddedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		//call stack api to send notification
		
		//
		System.out.println("afterTaskAddedEvent triggered");
		Long id = event.getTask().getId();
		System.out.println("afterTaskAddedEvent triggered Task id " + id);
		String tskName = event.getTask().getName();
		
		System.out.println("afterTaskAddedEvent triggered Task name" + tskName);
		
		/*Task task = event.getTask();
		org.jbpm.services.task.commands.TaskContext context = (org.jbpm.services.task.commands.TaskContext) event.getTaskContext();
		TaskContentService contentService = context.getTaskContentService();
		Content contentById = contentService.getContentById(task.getTaskData().getDocumentContentId());
		
		Map<String,Object> inputParams  = initialize(contentById);
		System.out.println("key:value");
		for (String key: inputParams.keySet()) {
			
			System.out.println("key:"+key );
			System.out.println(" value:"+inputParams.get(key) );
		}*/
		//event.getTaskContext().loadTaskVariables(task);
		Map<String , Object> inputPars = event.getTask().getTaskData().getTaskInputVariables();
		//event.getTask().getTaskData().get
		//ExpenseClaim expenseClaim = null;
		String body= tskName + "( " +id + " ) "+  " has been assigned to you. Please review and approve. "  ;
		String subject = "The Approval reauest for the service catalog  ( Task id " + id + " ) ";
		String sms ="16083584153";
		String to = "jpaulraj@redhat.com";
		
		List<String> messages = new ArrayList<String>();
		messages.add(to);
		messages.add(body);
		messages.add(subject);
		
		 try {
			 TwilioSMS twilioSMS = new TwilioSMS();
				
				twilioSMS.sendSMS(sms, body);
				
			} catch (Exception e) {
				//result.put("smsStatus", "unable to send SMS the given mobile " + tophone);
				e.printStackTrace();
				//manager.abortWorkItem(workitem.getId());
			}
		   try {
				
				EmailService emailService = new EmailService();
				emailService.sendEmailNotification(messages);	
			} catch (Exception e) {
				//result.put("smsStatus", "unable to send SMS the given mobile " + tophone);
				e.printStackTrace();
				//manager.abortWorkItem(workitem.getId());
			}
	}

	@Override
	public void afterTaskExitedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskReleasedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskResumedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskSuspendedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskForwardedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskDelegatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskNominatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskUpdatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskUpdatedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskReassignedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskReassignedEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTaskNotificationEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskNotificationEvent(TaskEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskInputVariableChangedEvent(TaskEvent event, Map<String, Object> variables) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTaskOutputVariableChangedEvent(TaskEvent event, Map<String, Object> variables) {
		// TODO Auto-generated method stub
		
	}
	
	

}
