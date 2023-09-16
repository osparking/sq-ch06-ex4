package main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import model.Comment;
import services.CommentService;
import space.jbpark.utility.MyUtil;

public class Main {
	private static Logger logger = MyUtil.getLogger(Main.class.getName());
	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var service = ctx.getBean("commentService", CommentService.class);
		var comment = new Comment();
		comment.setText("반기성의 기상예보");
		comment.setAuthor("반기성");
		var result = service.publishComment(comment);
		logger.info("반기성 출판 행위: " + result);
		
	}

}
