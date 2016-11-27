
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.DataBase;
import model.User;


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
			database.sumVote(user.getTime());
			database.addUser(user);
			user.setVoted(true);
		}
	}
	
}
