package controller;

import model.User;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import db.UserDB;

@Stateless
public class UserController {
	

	  @Inject
	  private UserDB db;
	  
	  public boolean isValid(String email, String password){
	  	for(User user : db.users){
	  		if(user.getEmail().equals(email) && user.getPassword().equals(password)){
	  	return true;		
	  		}
	  	}
	  return false;
	  }
	  
	  public boolean usernameExist(String email){
	  	for(User user : db.users){
	  		if(user.getEmail().equals(email) ){
	  	return true;		
	  }
	  	}
	  return false;
	  }
	  
	  public void register(User user){
	  	if(usernameExist(user.getEmail())){
	  		throw new RuntimeException("Usuario ya existe");		
	  }
	  	user.setId(db.nextId());
	  	db.users.add(user);
	  }
	  
	  public List<User> getUsers(){
		  return db.getUsers();
	  }

	

}
