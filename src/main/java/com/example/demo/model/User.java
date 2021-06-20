package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 */
@Entity
@Table( name = "user", schema = "public" )
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    
	 @Id
    @SequenceGenerator( name = "USER_USERID_GENERATOR", sequenceName = "public.user_user_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "USER_USERID_GENERATOR", strategy = GenerationType.SEQUENCE )
    @Column( name = "user_id" )
    private Integer id;
     @Column( name = "identity_number" )
    private String identityNumber;
    
    @Column( name = "user_phone" )
    private String userPhone;

    @Column( name = "security_question" )
    private String securityQuestion;

    @Column( name = "security_answer" )
    private String securityAnswer;

    @Column( name = "user_state" )
    private String userState;

    private String names;
    private String password;
    private String surnames;
    private String username;
    private String email;
   

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurnames() {
		return this.surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdentityNumber() {
		return this.identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getSecurityQuestion() {
		return this.securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return this.securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}



    //bi-directional many-to-many association to Role
    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable( name = "user_role", joinColumns = { @JoinColumn( name = "user_id" ) },
            inverseJoinColumns = { @JoinColumn( name = "role_id" ) } )
    private List<Role> roles;

    /**
     * Constructors
     */

    public User( ){
        // Default constructor is required
    }
    
	public User(Integer id){
        this.id=id;
    }

	public User(String username){
        this.username=username;
    }
    
	public User(Integer id, String username){
		this.id = id;
		this.username= username;
	}
	 
	 
	 public User(Integer id, String username,String identityNumber){
		this.id = id;
		this.identityNumber=identityNumber;
		this.username= username;
	}

	 public User(Integer id, String username,String identityNumber,String userPhone){
		this.id = id;
		this.identityNumber=identityNumber;
		this.username= username;
	}
	 
	 public User(Integer id, String username,String identityNumber,String names,
	 String surnames){
		this.id = id;
		this.identityNumber=identityNumber;
		this.username= username;
		this.names=names;
        this.surnames=surnames;
	}
	
	public User(Integer id,String identityNumber, String userPhone,String securityQuestion
	,String securityAnswer
	,String userState,String names,String password, String surnames,String username,String email){
		
		this.id = id;
		this.username= username;
		this.identityNumber=identityNumber;
		this.userPhone=userPhone;
		this.securityQuestion=securityQuestion;
		this.securityAnswer=securityAnswer;
		this.userState=userState;
		this.names=names;
		this.password=password;
		this.surnames=surnames;
		this.email=email;
}
	/**
     * Getters and Setters
     */

     

    public List<Role> getRoles( ){
        return this.roles;
    }

    public void setRoles( List<Role> roles ){
        this.roles = roles;
    }

    /**
     * Methods
     */

    public void addRole( Role role ){
        roles.add( role );
    }

    public boolean hasRole( Role role ){
        return roles.contains( role );
    }

    @Override
    public boolean equals( Object object ){
        if( !(object instanceof User) ) return false;
        return id.equals( ((User) object).getId( ) );
    }

    @Override
    public int hashCode( ){
        return id;
    }

}