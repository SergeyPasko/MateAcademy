package lesson11.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import lesson10.xml.MateGroup;
import lesson10.xml.Person;

/**
 * @author spasko
 */
// Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface MateGroupService {

	@WebMethod
	public MateGroup getMateGroup();

	@WebMethod
	public MateGroup addStudents(List<Person> persons);
}