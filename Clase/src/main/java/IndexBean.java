
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import database.DataBase;
import model.User;



@ManagedBean
@ApplicationScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = -4901741514584007341L;	
	private List<User> usersList;
	private DataBase database = DataBase.getInstance();

	@PostConstruct
	public void init() {
        usersList = database.getUsers();
    }

	public List<User> getUsersList() {
		return usersList;
	}


	

	
}