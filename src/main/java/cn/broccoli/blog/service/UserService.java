package cn.broccoli.blog.service;

public interface UserService {
	int selectIdByName(String name);

	String countByName(String name);
}
