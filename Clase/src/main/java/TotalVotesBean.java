import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import database.DataBase;
import model.FreeTime;
import model.User;


@ManagedBean
@ApplicationScoped
public class TotalVotesBean implements Serializable {

	private static final long serialVersionUID = -49017415584007341L;	
	private List<FreeTime> votesList;
	private DataBase database = DataBase.getInstance();

	@PostConstruct
	public void init() {
        votesList = database.getVotes();
    }

	public List<FreeTime> getVotesList() {
		return votesList;
	}
	
	public List<User> getWhoVotedList(){
		List <User> users = new ArrayList<User>();
		for(User u:database.getUsers())
		{
			if(u.isVoted()==true){
				users.add(u);
			}
		}
		return users;
	}


	

	
}