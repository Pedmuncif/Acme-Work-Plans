package acme.features.authenticated.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.entities.tasks.TaskStatus;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedTaskShowService implements AbstractShowService<Authenticated, Task>{

		
		@Autowired
		protected AuthenticatedShowRepository repository;

		@Override
		public boolean authorise(final Request<Task> request) {
			assert request != null;
			
			boolean result;
			Task task;
			int taskId;
			
			taskId = request.getModel().getInteger("id");
			task = this.repository.findOneTaskById(taskId);
			result = task.getStatus().equals(TaskStatus.PUBLIC);
			return result;
		}

		@Override
		public void unbind(final Request<Task> request, final Task entity, final Model model) {

			assert request != null;
			assert entity != null;
			assert model != null;
			
			request.unbind(entity, model, "title", "description",
				"startMoment", "finishMoment", "workload", "link", "status");
			
		}

		@Override
		public Task findOne(final Request<Task> request) {
			assert request != null;
			
			Task result;
			int id;
			
			id = request.getModel().getInteger("id");
			result = this.repository.findOneTaskById(id);
			
			return result;
		}

}
