package com.example.androidroomprojectcurd.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.androidroomprojectcurd.database.MyDatabase;
import com.example.androidroomprojectcurd.database.dao.MemberDao;
import com.example.androidroomprojectcurd.database.model.Member;

import java.util.List;

public class MemberRepository {

    private LiveData<List<Member>> memberItems;
    private MyDatabase db;
    private MemberDao memberDao;

    public MemberRepository(Application application){
        db = MyDatabase.getDatabase(application);
        memberDao = db.memberDao();
        memberItems = memberDao.getMemberItems();
    }

    public List<Member> getItems(){
        return memberDao.getList();
    }
    public Member getMemberItem(String emailId){
        return memberDao.getMemberItem(emailId);
    }

    public LiveData<List<Member>> getMemberItems(){ return memberItems; };

    public void insertMemberItem(Member member){ memberDao.insert(member); }

    public void updateMemberItem(Member member){ memberDao.update(member);}

    public void deleteMemberItem(Member member){ memberDao.delete(member);}

}
