package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.PostDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.PostDTO;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.PostsJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Post;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain_social_media.SocialMediaAddRequest;
import com.deguzman.domain_social_media.SocialMediaAddResponse;
import com.deguzman.domain_social_media.SocialMediaDeleteByIdRequest;
import com.deguzman.domain_social_media.SocialMediaDeleteByIdResponse;
import com.deguzman.domain_social_media.SocialMediaListResponse;
import com.deguzman.domain_social_media.SocialMediaSearchByUserIdRequest;

@Service
public class PostsService {

	@Autowired
	private PostDaoImpl postDaoImpl;
	
	@Autowired
	private PostsJpaDao postDao;
	
	public SocialMediaListResponse findAllPosts() {
		SocialMediaListResponse response = new SocialMediaListResponse();
		List<PostDTO> list = postDaoImpl.findAllPosts();
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTOSHOP_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTOSHOP_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> findAllPostsPagination(
			@RequestParam(required = false) String content, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {

			List<Post> shop = postDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<Post> pageBooks = null;

			if (content == null) {
				pageBooks = postDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("posts", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public SocialMediaListResponse findPostsByUser(SocialMediaSearchByUserIdRequest request) {
		SocialMediaListResponse response = new SocialMediaListResponse();
		List<PostDTO> list = postDaoImpl.findPostsByUser(request.getUserid());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_AUTOSHOP_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_AUTOSHOP_LIST_MSG);
		
		return response;
	}
	
	public SocialMediaAddResponse addPost(SocialMediaAddRequest request) {
		SocialMediaAddResponse response = new SocialMediaAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Post post = new com.deguzman.DeGuzmanStuffAnywhere.model.Post();
		int recordsAdded = postDaoImpl.addPost(request);
		
		post.setContent(request.getContent());
		post.setCreatedDate(request.getCreatedDate());
		post.setUser_id(request.getUser_id());
		
		response.setPost(post);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_SOCIAL_MEDIA_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_SOCIAL_MEDIA_INFORMATION_MSG);
		
		return response;
	}
	
	public SocialMediaDeleteByIdResponse deletePost(SocialMediaDeleteByIdRequest request) {
		SocialMediaDeleteByIdResponse response = new SocialMediaDeleteByIdResponse();
		int deletedRecords = postDaoImpl.deletePost(request.getPostId());
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_SOCIAL_MEDIA_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_SOCIAL_MEDIA_INFORMATION_MSG);
		
		return response;
	}
}
