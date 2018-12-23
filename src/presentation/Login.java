package presentation;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.*;  
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import business.User;
import persistance.Persist;

@ManagedBean
@SessionScoped
public class Login {
	private String Id;
	private File file;
	@PostConstruct
	private void init() {
	
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

}
