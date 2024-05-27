package by.vsu.twoa.service;

import by.vsu.twoa.dao.DaoException;
import by.vsu.twoa.dao.TaskDao;
import by.vsu.twoa.dao.UserDao;
import by.vsu.twoa.domain.Task;
import by.vsu.twoa.domain.User;
import by.vsu.twoa.geometry.Parallelogram;
import by.vsu.twoa.geometry.Point;
import by.vsu.twoa.geometry.Segment;
import by.vsu.twoa.geometry.Vector;
import by.vsu.twoa.service.exception.ServiceException;
import by.vsu.twoa.service.exception.TaskNotExistsException;
import by.vsu.twoa.service.exception.UserNotExistsException;

import java.util.Date;
import java.util.List;

public class TaskService {
	private TaskDao taskDao;
	private UserDao userDao;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<Task> findByOwner(Integer id) throws ServiceException {
		try {
			User owner = userDao.read(id).orElseThrow(() -> new UserNotExistsException(id));
			List<Task> tasks = taskDao.readByOwner(id);
			tasks.forEach(task -> task.setOwner(owner));
			return tasks;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Task findById(Integer id) throws ServiceException {
		try {
			Task task = taskDao.read(id).orElseThrow(() -> new TaskNotExistsException(id));
			task.setOwner(userDao.read(task.getOwner().getId()).orElseThrow(() -> new UserNotExistsException(id)));
			Point vertex1 = task.getVertex1();
			Point vertex2 = task.getVertex2();
			Point vertex3 = task.getVertex3();
			Point side1Middle = new Segment(vertex1, vertex2).middle();
			Point side2Middle = new Segment(vertex2, vertex3).middle();
			Point side3Middle = new Segment(vertex1, vertex3).middle();
			task.setParallelogramVariant1(new Parallelogram(vertex1, vertex2, vertex3, new Vector(vertex1, side2Middle).put(side3Middle)));
			task.setParallelogramVariant2(new Parallelogram(vertex2, vertex3, vertex1, new Vector(vertex2, side3Middle).put(side1Middle)));
			task.setParallelogramVariant3(new Parallelogram(vertex3, vertex1, vertex2, new Vector(vertex3, side1Middle).put(side2Middle)));
			return task;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Integer save(Task task) throws ServiceException {
		try {
			if(task.getId() == null) {
				task.setCreated(new Date(0));
				return taskDao.create(task);
			} else {
				throw new RuntimeException("Update operation not implemented yet");
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}
