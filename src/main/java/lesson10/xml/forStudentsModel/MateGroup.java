package lesson10.xml.forStudentsModel;
/**
 * @author spasko
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MateGroup implements Serializable {

	private Person teacher;
	private List<Person> students;
	private Room room;
	private Set<HumanResource> humanResources;

	public MateGroup(Teacher teacher, List<Person> students, Room room, Set<HumanResource> humanResources) {
		this.teacher = teacher;
		this.students = students;
		this.room = room;
		this.humanResources = humanResources;
	}

	public MateGroup() {
	}

	public Person getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Person> getStudents() {
		return students;
	}

	public void setStudents(List<Person> students) {
		this.students = students;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Set<HumanResource> getHumanResources() {
		return humanResources;
	}

	public void setHumanResources(Set<HumanResource> humanResources) {
		this.humanResources = humanResources;
	}

	@Override
	public String toString() {
		return "MateGroup [teacher=" + teacher + ", students=" + students + ", room=" + room + ", humanResources="
				+ humanResources + "]";
	}

	public static MateGroup mateGroupExampleCreator() {
		MateGroup mateGroup = new MateGroup();

		Teacher teacher = new Teacher("Serhii", "Pasko", 1988, 666);
		mateGroup.setTeacher(teacher);

		Room room = new Room("Kiyv", "Tarasivska", 16, 28);
		mateGroup.setRoom(room);

		Set<HumanResource> humanResources = new HashSet<>();
		humanResources.add(new HumanResource("Karmen", "", 1990, 2015));
		humanResources.add(new HumanResource("Efiria", "", 1989, 2016));
		mateGroup.setHumanResources(humanResources);

		List<Person> students = new ArrayList<>();
		students.add(new Student("Iza", "Rabinovish", 1997));
		students.add(new Student("Abram", "Kolom", 1998));
		students.add(new Teacher("Moisha", "Stefan", 1990, 666));
		mateGroup.setStudents(students);

		return mateGroup;
	}

}
