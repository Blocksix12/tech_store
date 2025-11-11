package com.teamforone.tech_store.repository.admin;

import com.teamforone.tech_store.model.Comment;
import com.teamforone.tech_store.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, String> {
    List<Reply> findAllByCommentOrderByCreatedAtAsc(Comment comment);
    void deleteAllByComment(Comment comment);
}
