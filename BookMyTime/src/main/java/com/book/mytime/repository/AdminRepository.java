package com.book.mytime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.book.mytime.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

}
