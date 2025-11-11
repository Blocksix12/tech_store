package com.teamforone.tech_store.controller.admin;

import com.teamforone.tech_store.model.Comment;
import com.teamforone.tech_store.model.Reply;
import com.teamforone.tech_store.service.admin.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // ====== LẤY DANH SÁCH TẤT CẢ BÌNH LUẬN ======
    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.findAllComments();
        return ResponseEntity.ok(comments);
    }

    // ====== DUYỆT BÌNH LUẬN ======
    @PostMapping("/{id}/approve")
    public ResponseEntity<Comment> approveComment(@PathVariable("id") String commentId) {
        Comment approved = commentService.approveComment(commentId);
        return ResponseEntity.ok(approved);
    }

    // ====== ẨN (NỘI DUNG XẤU) ======
    @PostMapping("/{id}/hide")
    public ResponseEntity<Comment> hideComment(@PathVariable("id") String commentId) {
        Comment hidden = commentService.hideComment(commentId);
        return ResponseEntity.ok(hidden);
    }

    // ====== XOÁ BÌNH LUẬN ======
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") String commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    // ====== ADMIN TRẢ LỜI BÌNH LUẬN ======
    @PostMapping("/{id}/reply")
    public ResponseEntity<Reply> replyToComment(
            @PathVariable("id") String commentId,
            @RequestParam("adminId") String adminId,
            @RequestBody String content) {
        Reply reply = commentService.replyToComment(commentId, adminId, content);
        return ResponseEntity.ok(reply);
    }
}
