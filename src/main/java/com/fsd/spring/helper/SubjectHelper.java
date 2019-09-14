package com.fsd.spring.helper;

import com.fsd.spring.dao.BookDao;
import com.fsd.spring.dao.SubjectDao;
import com.fsd.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectHelper {

	@Autowired
    private BookDao bookDao;

    @Autowired
    private SubjectDao subjectDao;

    public int deleteSubject(String deleteSubTitle) throws Exception {
        int SubCount = subjectDao.getAllSubjectCount();
        if (SubCount==0) {
            System.out.println("There are no subjects in the system");
            return SubCount;
        }
        int count = subjectDao.deleteSubject(deleteSubTitle);
        System.out.println("Number of records deleted : "+count);
        return SubCount;
    }

    public List<Book> searchBySubject(String subTitle) throws Exception {
        int SubCount = subjectDao.getAllSubjectCount();
        List<Book> bookDetailsList  = new ArrayList<Book>();
        if (SubCount==0) {
            System.out.println("There are no subjects in the system");
            return bookDetailsList;
        }
        bookDetailsList=subjectDao.searchForSubjects(subTitle);
        if(bookDetailsList.isEmpty()){
            System.out.println("no books found for your search : "+subTitle);
        }else{
            System.out.println("Matching Books :\n"+bookDetailsList);
        }
        return bookDetailsList;
    }
}
