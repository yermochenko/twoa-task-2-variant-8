package by.vsu.twoa.domain;

import by.vsu.twoa.geometry.Parallelogram;
import by.vsu.twoa.geometry.Point;

import java.util.Date;

public class Task extends Entity {
	private User owner;
	private String name;
	private Date created;
	private Point vertex1;
	private Point vertex2;
	private Point vertex3;
	private Parallelogram parallelogramVariant1;
	private Parallelogram parallelogramVariant2;
	private Parallelogram parallelogramVariant3;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Point getVertex1() {
		return vertex1;
	}

	public void setVertex1(Point vertex1) {
		this.vertex1 = vertex1;
	}

	public Point getVertex2() {
		return vertex2;
	}

	public void setVertex2(Point vertex2) {
		this.vertex2 = vertex2;
	}

	public Point getVertex3() {
		return vertex3;
	}

	public void setVertex3(Point vertex3) {
		this.vertex3 = vertex3;
	}

	public Parallelogram getParallelogramVariant1() {
		return parallelogramVariant1;
	}

	public void setParallelogramVariant1(Parallelogram parallelogramVariant1) {
		this.parallelogramVariant1 = parallelogramVariant1;
	}

	public Parallelogram getParallelogramVariant2() {
		return parallelogramVariant2;
	}

	public void setParallelogramVariant2(Parallelogram parallelogramVariant2) {
		this.parallelogramVariant2 = parallelogramVariant2;
	}

	public Parallelogram getParallelogramVariant3() {
		return parallelogramVariant3;
	}

	public void setParallelogramVariant3(Parallelogram parallelogramVariant3) {
		this.parallelogramVariant3 = parallelogramVariant3;
	}
}
