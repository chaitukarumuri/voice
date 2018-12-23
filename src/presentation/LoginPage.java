package presentation;



import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;

import java.util.Random;

import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;


import java.util.ArrayList;
import java.util.List;
import business.User;
import business.UserData;
import persistance.Persist;

@ManagedBean
@SessionScoped
public class LoginPage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String UserName;
	private String Password;
	private String Pass;
	private ArrayList<ArrayList<Integer>> Matrix;
private String Id;
private User user;
private UploadedFile file1;
private List<UserData> datas;
	private String FirstName;
	private String LastName;
	private String EmailId;
	private String Mobile;
	private String Address;
	private String City;
	private String State;
	private String Country;
	private Short PIN;
	private String AlternateEmail;
	private String SecurityQue;
	private String SecuirtyAns;
	public List<Integer> randomNumbers;
	@PostConstruct
	private void init() {
		
		this.Matrix = new ArrayList<ArrayList<Integer>>();
	    this.Matrix.add(new ArrayList<Integer>());
	    this.Matrix.add(new ArrayList<Integer>());
	    this.Matrix.add(new ArrayList<Integer>());
	    randomNumbers = new ArrayList<Integer>(); 

	    for (int i=0; i<3; i++) 
	    {    for(int j=0;j<3;j++){
	    	
	        int number;
Random r=new Random();
	        do number = r.nextInt(9)+1;
	        while (randomNumbers.contains(number));

	        randomNumbers.add(number);
	        this.Matrix.get(i).add(number);
	        
	    }
	    }
	    
	    
	    
	    
	    
	    
	    System.out.println("in init method end"); 
		
	}
	

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	




	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmailId() {
		return EmailId;
	}


	public void setEmailId(String emailId) {
		EmailId = emailId;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public Short getPIN() {
		return PIN;
	}


	public void setPIN(Short pIN) {
		PIN = pIN;
	}


	public String getAlternateEmail() {
		return AlternateEmail;
	}


	public void setAlternateEmail(String alternateEmail) {
		AlternateEmail = alternateEmail;
	}


	public String getSecurityQue() {
		return SecurityQue;
	}


	public void setSecurityQue(String securityQue) {
		SecurityQue = securityQue;
	}


	public String getSecuirtyAns() {
		return SecuirtyAns;
	}


	public void setSecuirtyAns(String secuirtyAns) {
		SecuirtyAns = secuirtyAns;
	}
	public ArrayList<ArrayList<Integer>> getMatrix() {
		return Matrix;
	}


	public void setMatrix(ArrayList<ArrayList<Integer>> matrix) {
		Matrix = matrix;
	}
	

	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}

	public UploadedFile getFile1() {
		return file1;
	}


	public void setFile1(UploadedFile file1) {
		this.file1 = file1;
	}


	public List<UserData> getDatas() {
		return datas;
	}


	public void setDatas(List<UserData> datas) {
		this.datas = datas;
	}
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	

	public String login()
	{
		Persist persist=new Persist();
		User user=persist.getUserDetails(Integer.parseInt(this.getId()));
		if(user==null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
		}
		String sampleString = getPass();
		String[] items; 
		if(sampleString.matches("[-+]?\\d*\\.?\\d+"))
		{
			items = sampleString.split("");
		}
		else
		{
	       items = sampleString.split(" ");
	      for(int i=0;i<items.length;i++)
	      {
	    	  if(items[i].equalsIgnoreCase("one"))
	    	  {
	    		  items[i]=1+"";
	    	  }
	    	  else if(items[i].equalsIgnoreCase("two"))
	    	  {
	    		  items[i]=2+"";
	    	  }
	    	  else if(items[i].equalsIgnoreCase("three"))
	    	  {
	    		  items[i]=3+"";
	    	  }
	    	  else if(items[i].equalsIgnoreCase("four"))
	    	  {
	    		  items[i]=4+"";
	    	  }
	    	  else if(items[i].equalsIgnoreCase("five"))
	    	  {
	    		  items[i]=5+"";  
	    	  }
	    	  else if(items[i].equalsIgnoreCase("six"))
	    	  {
	    		  items[i]=6+"";
	    	  }
	    	  else if(items[i].equalsIgnoreCase("seven"))
	    	  {
	    		  items[i]=7+"";
	    	  }
	    	  else if(items[i].equalsIgnoreCase("eight"))
	    	  {
	    		  items[i]=8+"";
	    	  }
	    	  else if(items[i].equalsIgnoreCase("nine"))
	    	  {
	    		  items[i]=9+"";
	    	  }
	    	  else 
	    	  {
	    		  items[i]="*";
	    		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "please try again"));
	    		  return"redo";
	    			
	    		  
	    	  }
	    	  
	      }
		}
		String matpass="";
		for(int i=0;i<items.length;i++)
		{
			for(int j=0;j<randomNumbers.size();j++)
			{
				if(randomNumbers.get(j)==Integer.parseInt(items[i]))
				{
					matpass=matpass+j;
				}
				
			}
			
		}
		
	     if(matpass.equalsIgnoreCase(user.getPassword()))
	     {
	    	 setAddress(user.getAddress());
	    	 setAlternateEmail(user.getAlternateEmail());
	    	 setCity(user.getCity());
	    	 setCountry(user.getCountry());
	    	 setEmailId(user.getEmailId());
	    	 setFirstName(user.getFirstName());
	    	 setLastName(user.getLastName());
	    	 setMobile(user.getMobile());
	    	 setPIN((short)user.getPIN());
	    	 setState(user.getState());
	    	 setUserName(user.getUserName());
	    	 setDatas(persist.getdata(Integer.parseInt(this.getId())));
	    	 return "login";
	     }
	     else
	     {
	    	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "user id or password mismatch"));
   		  return"redo";
	     }
		
		
		
		
	}
	public String contin()
	{
		return "continue";
	}
	public void refresh(ActionEvent actionEvent)
	{ System.out.println("refresh");
		Persist persist=new Persist();
		setDatas(persist.getdata(Integer.parseInt(this.getId())));
		
		
		
	}
	public void upload(ActionEvent actionEvent)
	{
		System.out.println("upload");
		Persist persist=new Persist();
		InputStream inputStream;
		try {
			if(getFile1() != null) {
	            FacesMessage message = new FacesMessage("Succesful", file1.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
			inputStream=getFile1().getInputstream();
			String filename=getFile1().getFileName(); 
			long length=getFile1().getSize();
			persist.uploadFile(Integer.parseInt(getId()),inputStream,filename,length);
		} catch (IOException e) {
			
			System.out.println("file upload error");
		}
		
		
		
		
		
		
	}
	public String logout() {
		System.out.println("logout");
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest)ec.getRequest(); 
		request.getSession( false ).invalidate(); 
        return "logout";
        
    }
	public String signup()
	{
		System.out.println("in signup method");
		Persist p=new Persist();
	////////////////////////////////////
	String sampleString = this.getPass();
	String[] items; 
	if(sampleString.matches("[-+]?\\d*\\.?\\d+"))
	{
		items = sampleString.split("");
	}
	else
	{
       items = sampleString.split(" ");
      for(int i=0;i<items.length;i++)
      {
    	  if(items[i].equalsIgnoreCase("one"))
    	  {
    		  items[i]=1+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("two"))
    	  {
    		  items[i]=2+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("three"))
    	  {
    		  items[i]=3+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("four"))
    	  {
    		  items[i]=4+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("five"))
    	  {
    		  items[i]=5+"";  
    	  }
    	  else if(items[i].equalsIgnoreCase("six"))
    	  {
    		  items[i]=6+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("seven"))
    	  {
    		  items[i]=7+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("eight"))
    	  {
    		  items[i]=8+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("nine"))
    	  {
    		  items[i]=9+"";
    	  }
    	  else 
    	  {
    		  items[i]="*";
    		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "please try password again"));
    		  return"redo";
    			
    		  
    	  }
      }
      
      }
	String matpass="";
	for(int i=0;i<items.length;i++)
	{
		for(int j=0;j<randomNumbers.size();j++)
		{
			if(randomNumbers.get(j)==Integer.parseInt(items[i]))
			{
				matpass=matpass+j;
			}
			
		}
		
	}
	this.setPassword(matpass);
	System.out.println("pass set");
	///////////////////////////////////////
	
		User usr=new User();
		usr.setAddress(this.getAddress());
		usr.setAlternateEmail(this.getAlternateEmail());
		usr.setCity(this.getCity());
		usr.setCountry(this.getCountry());
		usr.setEmailId(this.getEmailId());
		usr.setFirstName(this.getFirstName());
		usr.setLastName(this.getLastName());
		usr.setMobile(this.getMobile());
		usr.setPassword(this.getPassword());
		usr.setPIN(this.getPIN());
		usr.setSecurityQue(this.getSecurityQue());
		usr.setSecuirtyAns(this.getSecuirtyAns());
		usr.setState(this.getUserName());
		usr.setUserName(this.getUserName());
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(899999);
		while(p.isIdPresent(n))
		{
			n = 100000 + rnd.nextInt(899999);	
		}
		usr.setId(n);
		setId(n+"");
		p.sign(usr);
		
		return  "signup";
	}

	public String forgotpass()
	{
		
		Persist persist=new Persist();
		setUser(persist.getUserDetails(Integer.parseInt(getId())));
		setSecurityQue(getUser().getSecurityQue());
		
		if(user==null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
		}
		
		return "validate";
		
	}
	public String validate()
	{
		if(getSecuirtyAns().equalsIgnoreCase(getUser().getSecuirtyAns()))
		{
			return "true";	
		}
		
		return "false";
		
	}
	
public String newpass()
{
	Persist p=new Persist();
	////////////////////////////////////
	String sampleString = this.getPass();
	String[] items; 
	if(sampleString.matches("[-+]?\\d*\\.?\\d+"))
	{
		items = sampleString.split("");
	}
	else
	{
       items = sampleString.split(" ");
      for(int i=0;i<items.length;i++)
      {
    	  if(items[i].equalsIgnoreCase("one"))
    	  {
    		  items[i]=1+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("two"))
    	  {
    		  items[i]=2+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("three"))
    	  {
    		  items[i]=3+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("four"))
    	  {
    		  items[i]=4+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("five"))
    	  {
    		  items[i]=5+"";  
    	  }
    	  else if(items[i].equalsIgnoreCase("six"))
    	  {
    		  items[i]=6+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("seven"))
    	  {
    		  items[i]=7+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("eight"))
    	  {
    		  items[i]=8+"";
    	  }
    	  else if(items[i].equalsIgnoreCase("nine"))
    	  {
    		  items[i]=9+"";
    	  }
    	  else 
    	  {
    		  items[i]="*";
    		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "please try password again"));
    		  return"redo";
    			
    		  
    	  }
      }
      
      }
	String matpass="";
	for(int i=0;i<items.length;i++)
	{
		for(int j=0;j<randomNumbers.size();j++)
		{
			if(randomNumbers.get(j)==Integer.parseInt(items[i]))
			{
				matpass=matpass+j;
			}
			
		}
		
	}
	
	p.changepass(Integer.parseInt(getId()), matpass);
	return "changed";
	
}










	


	

}
