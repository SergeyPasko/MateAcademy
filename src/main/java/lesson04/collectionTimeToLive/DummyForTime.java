package lesson04.collectionTimeToLive;

/**
 * @author spasko
 * @param <T>
 */
public class DummyForTime<T> {
	Long timeCreation;
	T internalObject;

	public Long getTimeCreation() {
		return timeCreation;
	}

	public T getInternalObject() {
		return internalObject;
	}

	public DummyForTime(T internalObject) {
		this.timeCreation = System.currentTimeMillis();
		this.internalObject = internalObject;
		System.out.println("Create dummyForTime " + internalObject + " in:" + timeCreation);
	}

	@Override
	public String toString() {
		return "DummyForTime [timeCreation=" + timeCreation + ", internalObject=" + internalObject + "]";
	}

}
