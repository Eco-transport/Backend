package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


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

    private String names;
    private String password;
    private String surnames;
    private String username;

    @Column( name = "identity_number" )
    private String identityNumber;
    private String email;

    @Column( name = "user_phone" )
    private String userPhone;

    @Column( name = "security_question" )
    private String securityQuestion;

    @Column( name = "security_answer" )
    private String securityAnswer;

    @Column( name = "user_state" )
    private String userState;

	/**
	 * Relationships: bi-directional many-to-many association to Role
	 */

	@ManyToMany( fetch = FetchType.EAGER )
	@JoinTable( name = "user_role", joinColumns = { @JoinColumn( name = "user_id" ) },
			inverseJoinColumns = { @JoinColumn( name = "role_id" ) } )
	private List<Role> roles;

	@JsonIgnore
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Order> orders;

	

	

	/**
	 * Getters and setters
	 */

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

    /**
     * Constructors
     */

    public User( ){
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

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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