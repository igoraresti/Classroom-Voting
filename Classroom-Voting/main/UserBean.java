
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.DataBase;
import model.User;
import service.SessionIPController;


@ManagedBean
@SessionScoped
public class UserBean implements Serializable  {
	
	private static final long serialVersionUID = 8514272896487427409L;
	private User user = new User();
	private DataBase database = DataBase.getInstance();
	
	@PostConstruct
	public void init(){
		user.setFirstName("Usuario");
		user.setLastName("Anonimo");
		user.setIp(SessionIPController.setIP());
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void add(){
		database.addUser(user);
	}
	
	
	public String getWelcomeMessage(){
		if(user.isVoted() == false){
			return "Puedes votar";
		}
		else
			return "Ya has votado";
	}
	
	public void vote(){
		if(user.isVoted() == false){
			if(database.sumVote(user.getTime()))
				user.setVoted(true);
			database.addUser(user);
		}
	}
	
}
