package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test class for EventDAO class
 *
 */
public class TestEventDAO {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private ArrayList<Event> showAllEvents;
	private EventDAO dao;	

	/**
	 * Sets up database connection before other methods are executed in this class
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Closes the database connection after all the methods are executed
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		/**
		 * @TODO: Close connection object here  
		 */
		
		connection.close();
	}

	/**
	 * Sets up the objects required in other methods
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		showAllEvents = new ArrayList<Event>();
		dao = new EventDAO();
	}

	/**
	 * Deallocate the resources after execution of method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		showAllEvents = null ; 
		dao = null; 
	}

	/**
	 * Positive test case to test the method showAllEvents
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testShowAllEvents_Positive() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call showAllEvents method and assert it for
		 * size of returned type list
		 */		
		
		assertEquals(6, dao.showAllEvents().size());
	}	

	/**
	 * Junit test case to test positive case for updateEventDeletions
	 */
	@Test	
	public void testUpdateEventDeletions_Positive() {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventDeletions for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
		 */
		try {
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?"); 
			 preparedStatement.setInt(1, 1001);
			 resultSet = preparedStatement.executeQuery();
			 
			 assertTrue(resultSet.next());
			 
			 int previousValue = resultSet.getInt(1);
			 
			 
			 dao.updateEventDeletions(1001);
			 
			 preparedStatement.setInt(1, 1001);
			 resultSet = preparedStatement.executeQuery(); 
			 assertTrue(resultSet.next());
			 
			 assertEquals(previousValue+1, resultSet.getInt(1));
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
		
	}

	/**
	 * Negative test case for method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Negative() {
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 * throw an exception
		 */	
	}

	/**
	 * Positive test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Positive() {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventNominations for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 less then testSeatsAvailableAfter
		 */			
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?"); 
			preparedStatement.setInt(1, 1001);
			
			resultSet = preparedStatement.executeQuery(); 
			assertTrue(resultSet.next());
			int previousValue = resultSet.getInt(1); 
			dao.updateEventNominations(1001);
			preparedStatement.setInt(1, 1001);
			resultSet = preparedStatement.executeQuery(); 
			assertTrue(resultSet.next());
			assertEquals(previousValue-1,resultSet.getInt(1) );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * Negative test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Negative() {
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it should
		 * throw an exception
		 */	
	}

	/**
	 * Positive test case for method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsOfVisitor_Positive() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call checkEventsofVisitor method by passing this visitor object and
		 * valid eventId
		 * Assert the value of return type 
		 */		
	}

}
