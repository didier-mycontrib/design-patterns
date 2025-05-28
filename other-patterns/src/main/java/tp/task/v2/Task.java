package tp.task.v2;

import java.util.List;

// V2 = version améliorée avec combinaison de 2 patterns:
// composite et chain of responsibility pour récupérer (de parent en parent) la meilleure description possible


public abstract class Task {
	private Task parentTask = null;
	private String description = null;
	//public void execute();
	public List<Object> execute(Object ...args){ return null;}

	public Task getParentTask() {
		return parentTask;
	}

	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String recupererDescription(){
		String descriptionAuMieux = this.description;
		if(descriptionAuMieux==null && this.parentTask!=null){
			descriptionAuMieux = this.parentTask.recupererDescription();
		}
		return descriptionAuMieux;
	}
}
