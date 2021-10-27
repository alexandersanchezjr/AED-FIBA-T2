package model;

public class Player {

	private String name;
	private String lastName;
	private int age;
	private String team;
	private int points;
	private int rebounds;
	private int assists;
	private int robberies;
	private int blocks;

	public Player(String name, String lastName, int age, String team, int points, int rebounds, int assists,
			int robberies, int blocks) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.team = team;
		this.points = points;
		this.rebounds = rebounds;
		this.assists = assists;
		this.robberies = robberies;
		this.blocks = blocks;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRebounds() {
		return this.rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssists() {
		return this.assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getRobberies() {
		return this.robberies;
	}

	public void setRobberies(int robberies) {
		this.robberies = robberies;
	}

	public int getBlocks() {
		return this.blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	@Override
	public String toString() {
		return "{" + ", points='" + getPoints() + "'" + "}";
	}

}
