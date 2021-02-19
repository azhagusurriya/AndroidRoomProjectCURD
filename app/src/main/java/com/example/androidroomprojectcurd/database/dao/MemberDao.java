package com.example.androidroomprojectcurd.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidroomprojectcurd.database.model.Member;

import java.util.List;

@Dao
public interface MemberDao extends BaseDao<Member>{


    @Query("SELECT * FROM tblMember ORDER BY Email asc")
    LiveData<List<Member>> getMemberItems();

    @Query("SELECT * FROM tblMember ORDER BY Email asc")
    List<Member> getList();

    @Query("SELECT * FROM tblMember WHERE Email = :email")
    Member getMemberItem(String email);

    @Insert
    @Override
    void insert(Member member);

    @Update
    @Override
    void update(Member member);

    @Delete
    @Override
    void delete(Member member);


}
