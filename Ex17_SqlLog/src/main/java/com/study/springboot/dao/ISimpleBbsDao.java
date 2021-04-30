package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.SimpleBbsDto;

//@Mapper 어노테이션은 다음 인터페이스의 구현을 XML로 한다는 의미이다.
@Mapper
@Repository
public interface ISimpleBbsDao {

	
		//리스트 보기를 위한 select메소드를 정의한다.
		public List<SimpleBbsDto> listDao();
		
		//개별 뷰 보기를 위한 select메소드를 정의한다.
		public SimpleBbsDto viewDao(String id);
		
		//글 작성을 윟나 insert메소드를 정의한다.
		public int writeDao(String writer,String title,String content);
		
		//글 삭제를 위한 delete메소드를 정의한다.
		public int deleteDao(String id);
		
	
}
