package com.example.androidroomprojectcurd.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidroomprojectcurd.database.model.Member;
import com.example.androidroomprojectcurd.repository.MemberRepository;

import java.util.List;

public class MemberViewModel extends AndroidViewModel {

    private LiveData<List<Member>> allMemberItems;
    private MemberRepository memberRepository;

    public MemberViewModel(@NonNull Application application) {
        super(application);

        memberRepository = new MemberRepository(application);
        allMemberItems = memberRepository.getMemberItems();
    }

    public LiveData<List<Member>> getAllMemberItems(){ return memberRepository.getMemberItems();}

    public List<Member> getItems(){
        return memberRepository.getItems();
    }

    public Member getMemberItem(String emailId){
        return memberRepository.getMemberItem(emailId);
    }

    public void insertMemberItem(Member member){ memberRepository.insertMemberItem(member); }

    public void updateMemberItem(Member member){ memberRepository.updateMemberItem(member);}

    public void deleteMemberItem(Member member){ memberRepository.deleteMemberItem(member);}


}
