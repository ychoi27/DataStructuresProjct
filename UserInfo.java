public class UserInfo
{
	private String name,address,email;
	private int phone;

      // default constructor
      public UserInfo()
      {       
         name = "";
         address = "";
         email = "";

         id = 0;  
         phone = 0;
      }

      //constructor with all values 
	public UserInfo(String name, String address, int phone, String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

      // setters

	public void setName(String n){
		name=n;		
	}
	
	public void setAddress(String a){
		address=a;
	}
	
	public void setPhone(int ph){
		phone=ph;
	}
	
	public void setEmail(String e){
		email=e;
	}

      // getters

	public String getName(){
		return name;
	}

	public String getAddress(){
		return address;
	}

	public int getPhone(){
		return phone;
	}

	public String getEmail(){
		return email;
	}

} 
