package services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import aspects.ToLog;
import model.Comment;
import space.jbpark.utility.MyUtil;

@Service
public class CommentService {
	private Logger logger = MyUtil.getLogger(CommentService.class.getName());

	@ToLog
	public String publishComment(Comment comment) {
		logger.info("출판한 코맨트 텍스트:" + comment.getText());
		return "성공";
	}

	@ToLog
	public String deleteComment(Comment comment) {
		logger.info("삭제한 코맨트 텍스트:" + comment.getText());
		return "성공";
	}

	public String editComment(Comment comment) {
		logger.info("편집한 코맨트 텍스트:" + comment.getText());
		return "성공";
	}
}
