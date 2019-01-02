package udemyCourse;


public class Room {

	private Bed bed;
	private Chair chair;
	
	
	public Room(Bed bed, Chair chair) {
		this.bed = bed;
		this.chair = chair;
	}

	public Bed getBed() {
		return bed;
	}


	public void setBed(Bed bed) {
		this.bed = bed;
	}


	private Chair getChair() {
		return chair;
	}


	private void setChair(Chair chair) {
		this.chair = chair;
	}
	
	public void sitInChair()
	{
		getChair().sit();
	}
}
