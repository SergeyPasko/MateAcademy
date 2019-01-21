package lesson11.rest;

import javax.ws.rs.core.Response;

import lesson10.xml.Person;

/**
 * @author spasko
 */

public interface MateGroupService {

	public Response getMateGroup();

	public Response addStudents(int groupId, Person person);
}