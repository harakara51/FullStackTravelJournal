package Entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	 @JoinColumn(name = "user_id", nullable = false)
	private int user_id;
	@OneToMany(mappedBy = "trip_id")
	private Collection<Location> Locations;
	
	public Trip()
	{
		
	}

	public Trip(int id, int user_id)
	{
		this.id = id;
		this.user_id = user_id;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id()
	{
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "trip [id=" + id + ", user_id=" + user_id + "]";
	}
	
	
	
	
	
	
}
