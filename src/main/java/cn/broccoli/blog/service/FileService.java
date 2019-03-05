package cn.broccoli.blog.service;

public interface FileService {
	int selectIdByName(String name);

	String countByName(String name);
}
